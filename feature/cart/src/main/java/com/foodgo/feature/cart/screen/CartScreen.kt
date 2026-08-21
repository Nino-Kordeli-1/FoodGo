package com.foodgo.feature.cart.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.foodgo.designsystem.Colors
import com.foodgo.designsystem.Sizing
import com.foodgo.designsystem.Spacing
import com.foodgo.designsystem.TextSizing
import com.foodgo.feature.cart.contract.CartUiEvent
import com.foodgo.feature.cart.contract.CartUiState
import com.foodgo.feature.cart.vm.CartViewModel
import com.foodgo.ui.CartItems
import org.koin.androidx.compose.koinViewModel

@Composable
fun CartScreen(
    onBackClick: () -> Unit,
    onBrowseMenuClick: () -> Unit,
    onPlaceOrderClick: () -> Unit
) {
    val viewModel: CartViewModel = koinViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    CartScreenContent(
        state = state,
        onBackClick = onBackClick,
        onBrowseMenuClick = onBrowseMenuClick,
        onPlaceOrderClick = {
            viewModel.onEvent(CartUiEvent.PlaceOrder)
            onPlaceOrderClick()
        },
        onEvent = viewModel::onEvent
    )
}

@Composable
private fun CartScreenContent(
    state: CartUiState,
    onBackClick: () -> Unit,
    onBrowseMenuClick: () -> Unit,
    onPlaceOrderClick: () -> Unit,
    onEvent: (CartUiEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Colors.BgScreen)
    ) {
        CartTopBar(onBackClick = onBackClick)

        if (state.items.isEmpty()) {
            EmptyCartState(
                modifier = Modifier.weight(1f),
                onBrowseMenuClick = onBrowseMenuClick
            )
        } else {
            CartItems(
                items = state.items,
                modifier = Modifier.weight(1f),
                onIncrease = { id -> onEvent(CartUiEvent.AddOrIncrease(state.items.first { it.id == id })) },
                onDecrease = { id -> onEvent(CartUiEvent.Decrease(id)) },
                onRemove = { id -> onEvent(CartUiEvent.Remove(id)) }
            )

            CartFooter(
                total = state.items.sumOf { it.price * it.quantity },
                enabled = state.items.isNotEmpty(),
                onPlaceOrderClick = onPlaceOrderClick
            )
        }
    }
}

@Composable
private fun CartTopBar(onBackClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = Sizing.size36, start = Sizing.size10),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onBackClick) {
            Icon(
                painter = painterResource(com.foodgo.designsystem.R.drawable.ic_back_arrow),
                contentDescription = null
            )
        }
        Text(
            text = "My cart",
            fontSize = TextSizing.size20,
            fontWeight = FontWeight.Bold,
            color = Colors.TextPrimary,
            modifier = Modifier.padding(start = Spacing.spacing8)
        )
    }
}

@Composable
private fun EmptyCartState(
    modifier: Modifier = Modifier,
    onBrowseMenuClick: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Your cart is empty",
            fontSize = TextSizing.size16,
            fontWeight = FontWeight.SemiBold,
            color = Colors.TextPrimary
        )
        Text(
            text = "Add items from the menu",
            fontSize = TextSizing.size14,
            color = Colors.TextSecondary,
            modifier = Modifier.padding(top = Spacing.spacing4)
        )
        Spacer(Modifier.height(Spacing.spacing16))
        Button(onClick = onBrowseMenuClick) {
            Text("Browse menu")
        }
    }
}

@Composable
private fun CartFooter(
    total: Double,
    enabled: Boolean,
    onPlaceOrderClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Spacing.spacing16)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Total", fontSize = TextSizing.size16, color = Colors.TextSecondary)
            Text(
                text = "₾ " + "%.2f".format(total),
                fontSize = TextSizing.size18,
                fontWeight = FontWeight.Bold,
                color = Colors.TextPrimary
            )
        }
        Spacer(Modifier.height(Spacing.spacing12))
        Button(
            onClick = onPlaceOrderClick,
            enabled = enabled,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Place order")
        }
    }
}