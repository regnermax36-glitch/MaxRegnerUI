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
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maxregner.ui.components.NeonIconButton
import com.maxregner.ui.data.MockData
import com.maxregner.ui.theme.*

@Composable
fun HomeScreen(
    onOpenDrawer: () -> Unit = {},
    onOpenMedia: () -> Unit = {},
    onOpenQuickSettings: () -> Unit = {},
    onOpenSettings: () -> Unit = {},
    onOpenWidgets: () -> Unit = {}
) {
    val homeApps = MockData.installedApps.take(12)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PureBlack)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            CyanNeon.copy(alpha = 0.06f),
                            PureBlack,
                            MagentaNeon.copy(alpha = 0.05f)
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(horizontal = 14.dp)
        ) {
            // Status bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("14:32", color = CyanNeon, fontSize = 15.sp)
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    Icon(Icons.Default.Wifi, null, tint = CyanNeon, modifier = Modifier.size(16.dp))
                    Icon(Icons.Default.SignalCellular4Bar, null, tint = CyanNeon, modifier = Modifier.size(16.dp))
                    Icon(Icons.Default.BatteryFull, null, tint = CyanNeon, modifier = Modifier.size(16.dp))
                    Text("87%", color = CyanNeon, fontSize = 13.sp)
                }
            }

            // Weather strip
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(CardGlass)
                    .clickable { onOpenWidgets() }
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.WbSunny, null, tint = CyanNeon, modifier = Modifier.size(22.dp))
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text("Berlin • 18°C", color = TextPrimary, fontSize = 14.sp)
                    Text("Clear • Perfect cover weather", color = TextMuted, fontSize = 12.sp)
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(homeApps) { app ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .clickable { }
                            .padding(4.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(56.dp)
                                .clip(RoundedCornerShape(15.dp))
                                .background(CardGlass)
                                .border(1.dp, CyanNeon.copy(alpha = 0.25f), RoundedCornerShape(15.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = app.icon,
                                contentDescription = app.label,
                                tint = CyanNeon,
                                modifier = Modifier.size(26.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = app.label,
                            color = TextSecondary,
                            fontSize = 11.sp,
                            textAlign = TextAlign.Center,
                            maxLines = 1
                        )
                    }
                }
            }

            // Dock
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp, top = 8.dp)
                    .clip(RoundedCornerShape(22.dp))
                    .background(CardGlass.copy(alpha = 0.85f))
                    .border(1.dp, CyanNeon.copy(alpha = 0.2f), RoundedCornerShape(22.dp))
                    .padding(vertical = 10.dp, horizontal = 6.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                NeonIconButton(icon = Icons.Default.Phone, onClick = {}, size = 50.dp)
                NeonIconButton(icon = Icons.Default.Message, onClick = {}, size = 50.dp)
                NeonIconButton(icon = Icons.Default.Apps, onClick = onOpenDrawer, size = 50.dp, tint = MagentaNeon)
                NeonIconButton(icon = Icons.Default.MusicNote, onClick = onOpenMedia, size = 50.dp)
                NeonIconButton(icon = Icons.Default.Settings, onClick = onOpenSettings, size = 50.dp)
            }
        }
    }
}
