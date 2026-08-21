package com.foodgo.feature.menu.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.foodgo.designsystem.Colors
import com.foodgo.designsystem.Radius
import com.foodgo.designsystem.Spacing
import com.foodgo.designsystem.TextSizing
import com.foodgo.domain.model.MenuItem

@Composable
fun MenuItemGrid(
    items: List<MenuItem>,
    cartItemIds: Set<Int>,
    modifier: Modifier = Modifier,
    onAddClicked: (MenuItem) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        contentPadding = PaddingValues(Spacing.spacing16),
        horizontalArrangement = Arrangement.spacedBy(Spacing.spacing12),
        verticalArrangement = Arrangement.spacedBy(Spacing.spacing12)
    ) {
        items(items, key = { it.id }) { item ->
            MenuItemCard(
                item = item,
                isInCart = item.id in cartItemIds,
                onAddClicked = { onAddClicked(item) }
            )
        }
    }
}

@Composable
private fun MenuItemCard(
    item: MenuItem,
    isInCart: Boolean = false,
    onAddClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(Radius.radius16)
            .background(Colors.CardBg)
            .padding(Spacing.spacing12)
    ) {
        val imageRes = item.imageRes

        if (imageRes != null) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = item.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(Radius.radius12)
            )
        } else {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(Radius.radius12)
                    .background(Colors.BgScreen)
            )
        }

        Spacer(Modifier.height(Spacing.spacing8))

        Text(
            text = item.name,
            fontSize = TextSizing.size14,
            fontWeight = FontWeight.SemiBold,
            color = Colors.TextPrimary
        )

        Text(
            text = item.description,
            fontSize = TextSizing.size12,
            color = Colors.TextSecondary,
            maxLines = 1
        )

        Spacer(Modifier.height(Spacing.spacing4))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "₾ " + "%.2f".format(item.price),
                fontSize = TextSizing.size14,
                fontWeight = FontWeight.Bold,
                color = Colors.TextPrimary
            )

            AddButton(isInCart = isInCart, onClick = onAddClicked)
        }
    }
}

@Composable
private fun AddButton(
    isInCart: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .clip(Radius.radius4)
            .background(
                if (isInCart) {
                    Color.Transparent
                } else {
                    Colors.PrimaryBlue
                }
            )
            .clickable(onClick = onClick)
            .padding(horizontal = Spacing.spacing12)
    ) {
        Text(
            text = if (isInCart) "Added ✓" else "Add +",
            color = if (isInCart) {
                Colors.ButtonTextSelected
            } else {
                Colors.ButtonTextUnselected
            },
            fontSize = TextSizing.size12,
            fontWeight = FontWeight.Medium
        )
    }
}