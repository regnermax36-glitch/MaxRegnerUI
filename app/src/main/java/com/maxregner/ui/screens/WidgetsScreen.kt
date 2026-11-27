package com.maxregner.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maxregner.ui.components.NeonCard
import com.maxregner.ui.theme.*

@Composable
fun WidgetsScreen(onBack: () -> Unit) {
    val widgets = listOf(
        "Weather" to "18°C • Clear • Berlin",
        "Calendar" to "Next: Meeting at 16:00",
        "Battery" to "87% • Charging slowly",
        "Steps" to "6,240 steps today",
        "Music" to "Now Playing: Neon Dreams"
    )

    Column(
        modifier = Modifier.fillMaxSize().background(PureBlack).statusBarsPadding()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, null, tint = CyanNeon)
            }
            Text("Widgets", color = TextPrimary, fontSize = 20.sp)
        }

        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(widgets) { (title, subtitle) ->
                NeonCard(modifier = Modifier.fillMaxWidth()) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            when (title) {
                                "Weather" -> Icons.Default.WbSunny
                                "Calendar" -> Icons.Default.CalendarMonth
                                "Battery" -> Icons.Default.BatteryChargingFull
                                "Steps" -> Icons.Default.DirectionsWalk
                                else -> Icons.Default.MusicNote
                            },
                            contentDescription = null,
                            tint = CyanNeon,
                            modifier = Modifier.size(32.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(title, color = TextPrimary, fontSize = 16.sp)
                            Text(subtitle, color = TextSecondary, fontSize = 13.sp)
                        }
                    }
                }
            }

            item {
                Text(
                    text = "On real Z Flip 5 cover screen you can place resizable widgets in the home grid. This prototype shows the visual style only.",
                    color = TextMuted,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }
    }
}
