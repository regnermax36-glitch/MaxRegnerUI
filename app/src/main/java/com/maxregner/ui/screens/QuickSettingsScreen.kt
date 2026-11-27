package com.maxregner.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maxregner.ui.components.NeonCard
import com.maxregner.ui.data.MockData
import com.maxregner.ui.theme.*

@Composable
fun QuickSettingsScreen(
    onBack: () -> Unit = {}
) {
    var toggles by remember { mutableStateOf(MockData.defaultToggles) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PureBlack)
            .statusBarsPadding()
            .padding(horizontal = 14.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, null, tint = CyanNeon)
            }
            Column {
                Text("14:32", color = CyanNeon, fontSize = 26.sp)
                Text("Berlin • 18°C", color = TextSecondary, fontSize = 13.sp)
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.height(230.dp)
        ) {
            items(toggles, key = { it.id }) { toggle ->
                val active = toggle.isActive
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(if (active) CyanNeon.copy(alpha = 0.18f) else CardGlass)
                        .border(
                            1.dp,
                            if (active) CyanNeon else CyanNeon.copy(alpha = 0.2f),
                            RoundedCornerShape(16.dp)
                        )
                        .clickable {
                            toggles = toggles.map {
                                if (it.id == toggle.id) it.copy(isActive = !it.isActive) else it
                            }
                        }
                        .padding(vertical = 12.dp)
                ) {
                    Icon(
                        toggle.icon,
                        contentDescription = toggle.label,
                        tint = if (active) CyanNeon else TextSecondary,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        toggle.label,
                        color = if (active) CyanNeon else TextMuted,
                        fontSize = 10.sp,
                        maxLines = 1
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text("Notifications", color = TextSecondary, fontSize = 13.sp)
        Spacer(modifier = Modifier.height(10.dp))

        MockData.sampleNotifications.take(3).forEach { notif ->
            NeonCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(notif.icon, null, tint = CyanNeon, modifier = Modifier.size(26.dp))
                    Spacer(modifier = Modifier.width(12.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(notif.appName, color = TextPrimary, fontSize = 13.sp)
                        Text(notif.body, color = TextSecondary, fontSize = 12.sp, maxLines = 1)
                    }
                    Text(notif.time, color = TextMuted, fontSize = 11.sp)
                }
            }
        }
    }
}
