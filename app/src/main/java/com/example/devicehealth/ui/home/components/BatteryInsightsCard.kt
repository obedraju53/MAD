package com.example.devicehealth.ui.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
<<<<<<< HEAD
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.devicehealth.ui.home.BatteryInfoViewModel
import com.example.devicehealth.ui.home.BatteryUiState
import com.example.devicehealth.ui.theme.DeviceHealthTheme
=======
import androidx.compose.ui.unit.dp
import com.example.devicehealth.ui.home.BatteryInfoViewModel
>>>>>>> 04e30d32b4066876e58de37f6881e79e69005b51

@Composable
fun BatteryInsightsCard(viewModel: BatteryInfoViewModel) {
    val state by viewModel.uiState.collectAsState()
<<<<<<< HEAD
    BatteryInsightsContent(state = state)
}

@Composable
fun BatteryInsightsContent(state: BatteryUiState) {
=======

>>>>>>> 04e30d32b4066876e58de37f6881e79e69005b51
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Battery Insights", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text("Health", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.secondary)
                    Text(state.health, style = MaterialTheme.typography.bodyMedium)
                }
                Column {
                    Text("Status", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.secondary)
                    Text(state.status, style = MaterialTheme.typography.bodyMedium)
                }
                Column {
                    Text("Source", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.secondary)
                    Text(state.plugged, style = MaterialTheme.typography.bodyMedium)
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider(color = MaterialTheme.colorScheme.surfaceVariant)
            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text("Temp", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.secondary)
                    Text("${state.temperature}°C", style = MaterialTheme.typography.bodyMedium)
                }
                Column {
                    Text("Voltage", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.secondary)
                    Text("${state.voltage} mV", style = MaterialTheme.typography.bodyMedium)
                }
                Column {
                    Text("Capacity", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.secondary)
                    Text("${state.capacity} mAh", style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}
<<<<<<< HEAD

@Preview(showBackground = true)
@Composable
fun BatteryInsightsPreview() {
    DeviceHealthTheme {
        BatteryInsightsContent(
            state = BatteryUiState(
                health = "Good",
                status = "Discharging",
                plugged = "On Battery",
                temperature = 35.5f,
                voltage = 3800,
                capacity = 4500
            )
        )
    }
}
=======
>>>>>>> 04e30d32b4066876e58de37f6881e79e69005b51
