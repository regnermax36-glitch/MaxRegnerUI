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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maxregner.ui.theme.*

data class ClockFace(val id: String, val name: String, val style: String)

@Composable
fun ClockFacesScreen(onBack: () -> Unit) {
    val faces = listOf(
        ClockFace("neon_digital", "Neon Digital", "Large cyan numbers"),
        ClockFace("minimal", "Minimal", "Thin elegant"),
        ClockFace("bold", "Bold Block", "Heavy weight"),
        ClockFace("analog_neon", "Analog Neon", "Glowing hands"),
        ClockFace("binary", "Binary", "For the nerds"),
        ClockFace("word", "Word Clock", "Text based")
    )

    var selected by remember { mutableStateOf("neon_digital") }

    Column(modifier = Modifier.fillMaxSize().background(PureBlack).statusBarsPadding()) {
        Row(modifier = Modifier.fillMaxWidth().padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onBack) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, null, tint = CyanNeon)
            }
            Text("Clock Faces", color = TextPrimary, fontSize = 20.sp)
        }

        Box(
            modifier = Modifier.fillMaxWidth().height(180.dp).padding(16.dp).clip(RoundedCornerShape(20.dp)).background(CardGlass).border(1.dp, CyanNeon.copy(alpha = 0.4f), RoundedCornerShape(20.dp)),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "14:32", color = CyanNeon, fontSize = 56.sp, fontWeight = FontWeight.Light)
                Text(text = faces.find { it.id == selected }?.name ?: "", color = TextSecondary, fontSize = 14.sp)
            }
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(faces) { face ->
                val isSelected = selected == face.id
                Column(
                    modifier = Modifier.clip(RoundedCornerShape(16.dp)).background(if (isSelected) CyanNeon.copy(alpha = 0.15f) else CardGlass).border(1.dp, if (isSelected) CyanNeon else CyanNeon.copy(alpha = 0.2f), RoundedCornerShape(16.dp)).clickable { selected = face.id }.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "14:32", color = if (isSelected) CyanNeon else TextPrimary, fontSize = 28.sp, fontWeight = FontWeight.Light)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(face.name, color = TextPrimary, fontSize = 14.sp)
                    Text(face.style, color = TextMuted, fontSize = 11.sp)
                }
            }
        }
    }
}
