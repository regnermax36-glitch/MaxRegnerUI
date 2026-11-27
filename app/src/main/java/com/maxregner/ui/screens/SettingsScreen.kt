package com.maxregner.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maxregner.ui.theme.*

@Composable
fun SettingsScreen(
    onBack: () -> Unit,
    onOpenClockFaces: () -> Unit
) {
    var coverAlwaysOn by remember { mutableStateOf(true) }
    var showNotifications by remember { mutableStateOf(true) }
    var hapticFeedback by remember { mutableStateOf(true) }
    var useSystemDark by remember { mutableStateOf(false) }

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
            Text("MaxRegnerUI Settings", color = TextPrimary, fontSize = 20.sp)
        }

        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()).padding(horizontal = 16.dp).padding(bottom = 32.dp)
        ) {
            SettingsSection(title = "Cover Screen (Z Flip 5)") {
                SettingsToggleItem(Icons.Default.Visibility, "Keep cover screen on", "Prevent timeout while using MaxRegnerUI", coverAlwaysOn) { coverAlwaysOn = it }
                SettingsToggleItem(Icons.Default.Notifications, "Show notifications", "Display notification cards on cover", showNotifications) { showNotifications = it }
                SettingsClickItem(Icons.Default.AccessTime, "Clock faces", "Choose lock screen clock style", onOpenClockFaces)
            }

            SettingsSection(title = "Behavior") {
                SettingsToggleItem(Icons.Default.Vibration, "Haptic feedback", "Vibrate on interactions", hapticFeedback) { hapticFeedback = it }
                SettingsToggleItem(Icons.Default.DarkMode, "Follow system theme", "Currently forced MaxRegnerUI dark", useSystemDark) { useSystemDark = it }
            }

            SettingsSection(title = "About") {
                SettingsClickItem(Icons.Default.Info, "Version", "MaxRegnerUI 1.0.0-prototype") {}
                SettingsClickItem(Icons.Default.PhoneAndroid, "Target device", "Galaxy Z Flip 5 (cover screen optimized)") {}
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Note: Real outer display control on Z Flip 5 requires Accessibility Service, SYSTEM_ALERT_WINDOW and Samsung-specific APIs. This is a UI prototype only.",
                color = TextMuted,
                fontSize = 12.sp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }
}

@Composable
private fun SettingsSection(title: String, content: @Composable ColumnScope.() -> Unit) {
    Text(text = title, color = CyanNeon, fontSize = 13.sp, modifier = Modifier.padding(top = 20.dp, bottom = 8.dp, start = 4.dp))
    Column(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp)).background(CardGlass)) { content() }
}

@Composable
private fun SettingsToggleItem(icon: ImageVector, title: String, subtitle: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 12.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, null, tint = CyanNeon, modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(title, color = TextPrimary, fontSize = 15.sp)
            Text(subtitle, color = TextMuted, fontSize = 12.sp)
        }
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(checkedThumbColor = PureBlack, checkedTrackColor = CyanNeon, uncheckedThumbColor = TextMuted, uncheckedTrackColor = SurfaceDark)
        )
    }
}

@Composable
private fun SettingsClickItem(icon: ImageVector, title: String, subtitle: String, onClick: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth().clickable(onClick = onClick).padding(horizontal = 16.dp, vertical = 14.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, null, tint = CyanNeon, modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(title, color = TextPrimary, fontSize = 15.sp)
            Text(subtitle, color = TextMuted, fontSize = 12.sp)
        }
        Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, null, tint = TextMuted)
    }
}
