package com.example.devicehealth.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import com.example.devicehealth.data.local.User
import com.example.devicehealth.ui.home.components.BatteryInsightsCard
import com.example.devicehealth.ui.home.components.SystemVitalsCard
import com.example.devicehealth.ui.home.components.TipsCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    user: User,
    onLogout: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Device Health Dashboard") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {

            // Tips Card
            TipsCard()

            // System Vitals Card
            SystemVitalsCard()

            // Battery Insights Card
            val context = LocalContext.current
            val batteryViewModel: BatteryInfoViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
                factory = BatteryInfoViewModelFactory(context)
            )
            BatteryInsightsCard(viewModel = batteryViewModel)

            // Logout button
            OutlinedButton(
                onClick = onLogout,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.error), // Changed to error color for distinction
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = MaterialTheme.colorScheme.error
                )
            ) {
                Text("Logout")
            }
        }
    }
}
