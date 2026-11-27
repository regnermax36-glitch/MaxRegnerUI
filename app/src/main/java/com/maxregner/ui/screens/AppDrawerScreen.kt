package com.maxregner.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maxregner.ui.data.MockData
import com.maxregner.ui.theme.*

@Composable
fun AppDrawerScreen(
    onBack: () -> Unit,
    onAppClick: (String) -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }

    val filteredApps = remember(searchQuery) {
        if (searchQuery.isBlank()) MockData.installedApps
        else MockData.installedApps.filter {
            it.label.contains(searchQuery, ignoreCase = true)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PureBlack)
            .statusBarsPadding()
            .padding(horizontal = 12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = CyanNeon)
            }
            Text(text = "All Apps", color = TextPrimary, fontSize = 20.sp, modifier = Modifier.weight(1f))
        }

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
            placeholder = { Text("Search apps", color = TextMuted) },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = CyanNeon) },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = CyanNeon,
                unfocusedBorderColor = CyanNeon.copy(alpha = 0.3f),
                focusedTextColor = TextPrimary,
                unfocusedTextColor = TextPrimary,
                cursorColor = CyanNeon,
                focusedContainerColor = CardGlass,
                unfocusedContainerColor = CardGlass
            ),
            shape = RoundedCornerShape(16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(bottom = 24.dp)
        ) {
            items(filteredApps, key = { it.packageName }) { app ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clip(RoundedCornerShape(12.dp)).clickable { onAppClick(app.packageName) }.padding(6.dp)
                ) {
                    Box(
                        modifier = Modifier.size(56.dp).clip(RoundedCornerShape(14.dp)).background(CardGlass),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(imageVector = app.icon, contentDescription = app.label, tint = if (app.isSystem) CyanNeon else MagentaNeon, modifier = Modifier.size(28.dp))
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text = app.label, color = TextSecondary, fontSize = 11.sp, textAlign = TextAlign.Center, maxLines = 1)
                }
            }
        }
    }
}
