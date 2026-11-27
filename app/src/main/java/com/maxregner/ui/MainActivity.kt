package com.maxregner.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.maxregner.ui.navigation.MaxRegnerNavGraph
import com.maxregner.ui.theme.MaxRegnerTheme
import com.maxregner.ui.theme.PureBlack

/**
 * MaxRegnerUI - Cover screen style launcher prototype
 * Visually optimized for Galaxy Z Flip 5 cover screen proportions.
 *
 * Real outer-display takeover on Z Flip 5 requires:
 * - AccessibilityService
 * - SYSTEM_ALERT_WINDOW permission
 * - QUERY_ALL_PACKAGES
 * - Samsung-specific cover screen / Good Lock style integration
 *
 * This project is a high-fidelity UI + navigation architecture prototype only.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaxRegnerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = PureBlack
                ) {
                    MaxRegnerNavGraph()
                }
            }
        }
    }
}
