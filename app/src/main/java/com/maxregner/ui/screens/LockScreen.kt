package com.maxregner.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maxregner.ui.theme.*

@Composable
fun LockScreen(
    onUnlock: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PureBlack)
            .clickable { onUnlock() }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.radialGradient(
                        colors = listOf(
                            CyanNeon.copy(alpha = 0.14f),
                            PureBlack,
                            MagentaNeon.copy(alpha = 0.09f)
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "Locked",
                tint = CyanNeon.copy(alpha = 0.7f),
                modifier = Modifier
                    .padding(top = 28.dp)
                    .size(26.dp)
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "14:32",
                    color = CyanNeon,
                    fontSize = 78.sp,
                    fontWeight = FontWeight.Light,
                    letterSpacing = (-2).sp
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Friday, 27 November",
                    color = TextSecondary,
                    fontSize = 16.sp
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(bottom = 40.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(76.dp)
                        .clip(CircleShape)
                        .background(CardGlass)
                        .border(2.dp, MagentaNeon.copy(alpha = 0.65f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "87%",
                        color = MagentaNeon,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
                Spacer(modifier = Modifier.height(14.dp))
                Text(
                    text = "Tap to unlock",
                    color = TextMuted,
                    fontSize = 13.sp
                )
            }
        }
    }
}
