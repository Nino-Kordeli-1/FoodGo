package com.foodgo.feature.menu.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.foodgo.designsystem.Colors
import com.foodgo.designsystem.Sizing
import com.foodgo.designsystem.Spacing
import com.foodgo.designsystem.TextSizing
import com.foodgo.feature.menu.components.FoodFilterRow
import com.foodgo.feature.menu.components.MenuItemGrid
import com.foodgo.feature.menu.contract.MenuUiEvent
import com.foodgo.feature.menu.contract.MenuUiState
import com.foodgo.feature.menu.screen.vm.MenuViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MenuScreen(
    onCartClick: () -> Unit
) {
    val viewModel: MenuViewModel = koinViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    MenuScreenContent(
        state = state,
        onCartClick = onCartClick,
        onEvent = viewModel::onEvent
    )
}

@Composable
private fun MenuScreenContent(
    state: MenuUiState,
    onCartClick: () -> Unit,
    onEvent: (MenuUiEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Colors.BgScreen)
            .padding(top = Spacing.spacing22)

    ) {
        MenuTopBar(
            cartItemCount = state.cartItemCount,
            onCartClick = onCartClick
        )

        FoodFilterRow(
            selected = state.selectedFilter,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = Spacing.spacing12),
            onFilterSelected = { filter -> onEvent(MenuUiEvent.SelectCategory(filter)) }
        )

        Spacer(modifier = Modifier.size(Spacing.spacing12))

        MenuItemGrid(
            items = state.items,
            cartItemIds = state.cartItemIds,
            modifier = Modifier.fillMaxSize(),
            onAddClicked = { item -> onEvent(MenuUiEvent.AddToCart(item)) }
        )
    }
}

@Composable
private fun MenuTopBar(
    cartItemCount: Int,
    onCartClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = Spacing.spacing16, end = Spacing.spacing16, top = Sizing.size22),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Column {
            Text(
                text = "FoodGo",
                fontSize = TextSizing.size20,
                fontWeight = FontWeight.Bold,
                color = Colors.TextPrimary
            )
            Text(
                text = "What would you like to eat?",
                modifier = Modifier.padding(top = Spacing.spacing4),
                fontSize = TextSizing.size14,
                color = Colors.TextSecondary
            )
        }

        CartButton(count = cartItemCount, onClick = onCartClick)
    }
}

@Composable
private fun CartButton(
    count: Int,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(Sizing.size40)
            .clickable(onClick = onClick)
    ) {
        Icon(
            painter = painterResource(com.foodgo.designsystem.R.drawable.cart),
            contentDescription = null,
            tint = Colors.TextPrimary,
            modifier = Modifier
                .align(Alignment.Center)
                .size(Sizing.size28)
        )

        if (count > 0) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(Sizing.size16)
                    .clip(CircleShape)
                    .background(Colors.BadgeRed),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = count.toString(),
                    color = Color.White,
                    fontSize = TextSizing.size12,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxSize(),
                    textAlign = TextAlign.Center,
                    lineHeight = TextSizing.size12
                )
            }
        }
    }
}