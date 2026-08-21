package com.foodgo.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.foodgo.designsystem.Colors
import com.foodgo.designsystem.R
import com.foodgo.designsystem.Radius
import com.foodgo.designsystem.Sizing
import com.foodgo.designsystem.TextSizing
import com.foodgo.domain.model.CartItem as CartItemModel


@Composable
fun CartItems(
    items: List<CartItemModel>,
    onIncrease: (Int) -> Unit,
    onDecrease: (Int) -> Unit,
    onRemove: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(bottom = Sizing.size16)
    ) {
        items(items) { item ->
            CartItem(
                uiItem = item,
                onIncrease = { onIncrease(item.id) },
                onDecrease = { onDecrease(item.id) },
                onRemove = { onRemove(item.id) }
            )

            HorizontalDivider(
                modifier = Modifier.padding(horizontal = Sizing.size14),
                thickness = Sizing.size0_5,
                color = Colors.DividerColor
            )
        }
    }
}

@Composable
fun CartItem(
    uiItem: CartItemModel,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit,
    onRemove: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = Sizing.size12,
                vertical = Sizing.size8
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(Sizing.size50)
                .clip(Radius.radius10)
                .background(Colors.CartItemBackground),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(
                    uiItem.imageRes ?: R.drawable.ic_pizza
                ),
                contentDescription = null,
                modifier = Modifier.size(Sizing.size36)
            )
        }

        Column(
            modifier = Modifier
                .padding(start = Sizing.size12)
                .weight(1f)
        ) {
            Text(
                text = uiItem.name,
                fontSize = TextSizing.size14,
                fontWeight = FontWeight.SemiBold,
                color = Colors.TextPrimary
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "₾ ${uiItem.price}",
                    fontSize = TextSizing.size12,
                    color = Colors.TextSecondary
                )
                Spacer(modifier = Modifier.padding(horizontal = Sizing.size4))
                Text(
                    text = "(Total: ₾ ${"%.2f".format(uiItem.total)})",
                    fontSize = TextSizing.size12,
                    fontWeight = FontWeight.Bold,
                    color = Colors.BadgeRed
                )
            }
        }

        QuantityCounter(
            quantity = uiItem.quantity,
            onMinusClick = onDecrease,
            onPlusClick = onIncrease
        )
    }
}

@Composable
fun QuantityCounter(
    quantity: Int,
    onMinusClick: () -> Unit,
    onPlusClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .height(Sizing.size36)
            .background(
                color = Colors.CardBg,
                shape = Radius.radius8
            )
            .border(
                width = Sizing.size1,
                color = Colors.DividerColor,
                shape = Radius.radius8
            )
            .clip(Radius.radius8),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(Sizing.size36)
                .clickable(onClick = onMinusClick),
            contentAlignment = Alignment.Center
        ) {
            if (quantity == 1) {
                Image(
                    painter = painterResource(R.drawable.ic_trash),
                    contentDescription = null
                )
            } else {
                Image(
                    painter = painterResource(R.drawable.ic_remove),
                    contentDescription = null
                )
            }
        }

        Box(
            modifier = Modifier
                .size(Sizing.size36),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = quantity.toString(),
                fontWeight = FontWeight.Bold,
                fontSize = TextSizing.size14
            )
        }

        Box(
            modifier = Modifier
                .size(Sizing.size36)
                .clickable(onClick = onPlusClick),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ic_plus),
                contentDescription = null
            )
        }
    }
}
