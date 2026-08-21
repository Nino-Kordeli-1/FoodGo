package com.foodgo.feature.menu.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.foodgo.designsystem.Colors
import com.foodgo.designsystem.Radius
import com.foodgo.designsystem.Sizing
import com.foodgo.designsystem.Spacing
import com.foodgo.designsystem.TextSizing
import com.foodgo.feature.menu.model.FoodFilter

@Composable
fun FoodFilterRow(
    selected: FoodFilter,
    modifier: Modifier = Modifier,
    onFilterSelected: (FoodFilter) -> Unit
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = Spacing.spacing16),
        horizontalArrangement = Arrangement.spacedBy(Spacing.spacing8)
    ) {
        items(FoodFilter.entries) { filter ->
            FilterChipItem(
                label = filter.label,
                isSelected = filter == selected,
                onClick = { onFilterSelected(filter) }
            )
        }
    }
}

@Composable
private fun FilterChipItem(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val textColor by animateColorAsState(
        targetValue = if (isSelected) Color.White else Colors.TextSecondary
    )
    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) Colors.PrimaryBlue else Colors.CardBg
    )
    val borderColor = if (isSelected) Color.Transparent else Colors.BorderNeutral

    Box(
        modifier = Modifier
            .clip(Radius.radius50)
            .background(backgroundColor)
            .border(width = Sizing.size1, color = borderColor, shape = Radius.radius50)
            .clickable(onClick = onClick)
            .padding(horizontal = Spacing.spacing20, vertical = Spacing.spacing10)
    ) {
        Text(
            text = label,
            color = textColor,
            fontSize = TextSizing.size14,
            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal
        )
    }
}