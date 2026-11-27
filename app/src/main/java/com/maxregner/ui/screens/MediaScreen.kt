package com.maxregner.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maxregner.ui.data.MediaInfo
import com.maxregner.ui.theme.*

@Composable
fun MediaScreen(
    onBack: () -> Unit = {}
) {
    var media by remember { mutableStateOf(MediaInfo()) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PureBlack)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBack) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, null, tint = CyanNeon)
                }
                Text("Now Playing", color = TextMuted, fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .size(190.dp)
                    .clip(CircleShape)
                    .background(
                        Brush.radialGradient(
                            colors = listOf(CyanNeon.copy(alpha = 0.35f), CardGlass)
                        )
                    )
                    .border(
                        width = 2.5.dp,
                        brush = Brush.sweepGradient(listOf(CyanNeon, MagentaNeon, CyanNeon)),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Default.MusicNote,
                    contentDescription = null,
                    tint = CyanNeon,
                    modifier = Modifier.size(70.dp)
                )
            }

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = media.title,
                color = TextPrimary,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "${media.artist} • ${media.album}",
                color = CyanSoft,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            val progress = media.positionMs.toFloat() / media.durationMs
            Column(modifier = Modifier.fillMaxWidth()) {
                LinearProgressIndicator(
                    progress = { progress },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                        .clip(RoundedCornerShape(2.dp)),
                    color = CyanNeon,
                    trackColor = CardGlass
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(formatTime(media.positionMs), color = TextMuted, fontSize = 12.sp)
                    Text(formatTime(media.durationMs), color = TextMuted, fontSize = 12.sp)
                }
            }

            Spacer(modifier = Modifier.height(36.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.SkipPrevious, null, tint = MagentaNeon, modifier = Modifier.size(38.dp))
                }

                Box(
                    modifier = Modifier
                        .size(74.dp)
                        .clip(CircleShape)
                        .background(CyanNeon)
                        .clickable {
                            media = media.copy(isPlaying = !media.isPlaying)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        if (media.isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                        contentDescription = null,
                        tint = PureBlack,
                        modifier = Modifier.size(38.dp)
                    )
                }

                IconButton(onClick = {}) {
                    Icon(Icons.Default.SkipNext, null, tint = MagentaNeon, modifier = Modifier.size(38.dp))
                }
            }
        }
    }
}

private fun formatTime(ms: Long): String {
    val totalSec = ms / 1000
    val min = totalSec / 60
    val sec = totalSec % 60
    return "%d:%02d".format(min, sec)
}
