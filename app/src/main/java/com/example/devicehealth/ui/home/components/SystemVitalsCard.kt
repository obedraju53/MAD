package com.example.devicehealth.ui.home.components

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Environment
import android.os.StatFs
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.devicehealth.ui.theme.DeviceHealthTheme
import java.io.File
import kotlin.math.roundToInt

data class SystemVitalsState(
    val batteryLevel: Int = 0,
    val storageUsedPercent: Float = 0f,
    val storageText: String = ""
)

@Composable
fun SystemVitalsCard() {
    val context = LocalContext.current
    var state by remember { mutableStateOf(SystemVitalsState()) }

    LaunchedEffect(Unit) {
        // Battery
        val batteryStatus: Intent? = try {
            context.registerReceiver(null, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
        } catch (e: Exception) {
            null
        }
        
        val level: Int = batteryStatus?.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) ?: -1
        val scale: Int = batteryStatus?.getIntExtra(BatteryManager.EXTRA_SCALE, -1) ?: -1
        val batteryLevel = if (level != -1 && scale != -1) {
            (level * 100 / scale.toFloat()).roundToInt()
        } else {
            0
        }

        // Storage
        val (storageUsedPercent, storageText) = try {
            val path = Environment.getDataDirectory()
            val stat = StatFs(path.path)
            val blockSize = stat.blockSizeLong
            val totalBlocks = stat.blockCountLong
            val availableBlocks = stat.availableBlocksLong

            val totalSize = totalBlocks * blockSize
            val availableSize = availableBlocks * blockSize
            val usedSize = totalSize - availableSize

            val percent = if (totalSize > 0) usedSize.toFloat() / totalSize else 0f
            
            val freeGb = availableSize / (1024 * 1024 * 1024)
            val totalGb = totalSize / (1024 * 1024 * 1024)
            percent to "$freeGb GB Free / $totalGb GB Total"
        } catch (e: Exception) {
            0f to "Storage Info Unavailable"
        }

        state = SystemVitalsState(batteryLevel, storageUsedPercent, storageText)
    }

    SystemVitalsContent(
        batteryLevel = state.batteryLevel,
        storageUsedPercent = state.storageUsedPercent,
        storageText = state.storageText
    )
}

@Composable
fun SystemVitalsContent(
    batteryLevel: Int,
    storageUsedPercent: Float,
    storageText: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("System Vitals", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(12.dp))

            // Battery
            Text("Battery: $batteryLevel%", style = MaterialTheme.typography.bodyMedium)
            LinearProgressIndicator(
                progress = { batteryLevel / 100f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .padding(vertical = 4.dp),
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Storage
            Text("Storage: $storageText", style = MaterialTheme.typography.bodyMedium)
            LinearProgressIndicator(
                progress = { storageUsedPercent },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .padding(vertical = 4.dp),
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SystemVitalsPreview() {
    DeviceHealthTheme {
        SystemVitalsContent(
            batteryLevel = 75,
            storageUsedPercent = 0.45f,
            storageText = "128 GB Free / 256 GB Total"
        )
    }
}
