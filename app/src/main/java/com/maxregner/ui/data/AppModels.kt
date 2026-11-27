package com.maxregner.ui.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

data class AppInfo(
    val packageName: String,
    val label: String,
    val icon: ImageVector,
    val isSystem: Boolean = false
)

data class QuickToggle(
    val id: String,
    val label: String,
    val icon: ImageVector,
    val isActive: Boolean = false
)

data class NotificationItem(
    val id: String,
    val appName: String,
    val title: String,
    val body: String,
    val icon: ImageVector,
    val time: String
)

data class MediaInfo(
    val title: String = "Neon Dreams",
    val artist: String = "MaxRegner",
    val album: String = "Synthwave Nights",
    val durationMs: Long = 198000,
    val positionMs: Long = 84000,
    val isPlaying: Boolean = true
)

object MockData {
    val installedApps = listOf(
        AppInfo("com.samsung.android.dialer", "Phone", Icons.Default.Phone, true),
        AppInfo("com.samsung.android.messaging", "Messages", Icons.Default.Message, true),
        AppInfo("com.sec.android.app.camera", "Camera", Icons.Default.CameraAlt, true),
        AppInfo("com.sec.android.gallery3d", "Gallery", Icons.Default.Photo, true),
        AppInfo("com.spotify.music", "Spotify", Icons.Default.MusicNote),
        AppInfo("com.android.settings", "Settings", Icons.Default.Settings, true),
        AppInfo("com.android.chrome", "Chrome", Icons.Default.Language),
        AppInfo("com.google.android.apps.maps", "Maps", Icons.Default.Map),
        AppInfo("com.sec.android.app.clockpackage", "Clock", Icons.Default.AccessTime, true),
        AppInfo("com.sec.android.app.myfiles", "Files", Icons.Default.Folder, true),
        AppInfo("com.samsung.android.app.notes", "Notes", Icons.Default.EditNote),
        AppInfo("com.samsung.android.weather", "Weather", Icons.Default.WbSunny),
        AppInfo("com.whatsapp", "WhatsApp", Icons.Default.Chat),
        AppInfo("com.instagram.android", "Instagram", Icons.Default.Camera),
        AppInfo("com.twitter.android", "X", Icons.Default.Tag),
        AppInfo("com.google.android.youtube", "YouTube", Icons.Default.PlayArrow),
        AppInfo("com.android.vending", "Play Store", Icons.Default.Shop),
        AppInfo("com.samsung.android.app.contacts", "Contacts", Icons.Default.Contacts, true),
        AppInfo("com.sec.android.app.sbrowser", "Samsung Internet", Icons.Default.Public),
        AppInfo("com.google.android.gm", "Gmail", Icons.Default.Email)
    )

    val defaultToggles = listOf(
        QuickToggle("wifi", "Wi-Fi", Icons.Default.Wifi, true),
        QuickToggle("bt", "Bluetooth", Icons.Default.Bluetooth, true),
        QuickToggle("flash", "Flashlight", Icons.Default.FlashlightOn),
        QuickToggle("dnd", "DND", Icons.Default.DoNotDisturb),
        QuickToggle("airplane", "Airplane", Icons.Default.AirplanemodeActive),
        QuickToggle("location", "Location", Icons.Default.LocationOn, true),
        QuickToggle("hotspot", "Hotspot", Icons.Default.WifiTethering),
        QuickToggle("rotate", "Auto Rotate", Icons.Default.ScreenRotation),
        QuickToggle("data", "Mobile Data", Icons.Default.SignalCellular4Bar, true),
        QuickToggle("sound", "Sound", Icons.Default.VolumeUp, true),
        QuickToggle("brightness", "Brightness", Icons.Default.BrightnessHigh),
        QuickToggle("caffeine", "Caffeine", Icons.Default.Coffee)
    )

    val sampleNotifications = listOf(
        NotificationItem("1", "WhatsApp", "Alex", "Hey, are you free later?", Icons.Default.Chat, "14:28"),
        NotificationItem("2", "Gmail", "Project Update", "The new designs are ready for review", Icons.Default.Email, "13:55"),
        NotificationItem("3", "Messages", "Mom", "Don't forget dinner tonight", Icons.Default.Message, "12:40"),
        NotificationItem("4", "YouTube", "Recommended", "New synthwave mix just dropped", Icons.Default.PlayArrow, "11:15")
    )
}
