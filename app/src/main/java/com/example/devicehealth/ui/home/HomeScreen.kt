package com.example.devicehealth.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
<<<<<<< HEAD
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.devicehealth.ServiceLocator
import com.example.devicehealth.data.local.User
import com.example.devicehealth.data.local.Tip
import com.example.devicehealth.ui.home.components.*
import com.example.devicehealth.ui.theme.DeviceHealthTheme
=======
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
>>>>>>> 04e30d32b4066876e58de37f6881e79e69005b51

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    user: User,
    onLogout: () -> Unit
) {
<<<<<<< HEAD
    val context = LocalContext.current
    
    val tipsViewModel: TipsViewModel = viewModel(
        factory = TipsViewModelFactory(ServiceLocator.tipRepository)
    )
    val tips by tipsViewModel.tipsLive.observeAsState(emptyList())

    val batteryViewModel: BatteryInfoViewModel = viewModel(
        factory = BatteryInfoViewModelFactory(context)
    )
    val batteryState by batteryViewModel.uiState.collectAsState()

=======
>>>>>>> 04e30d32b4066876e58de37f6881e79e69005b51
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Device Health Dashboard") }
            )
        }
    ) { padding ->
<<<<<<< HEAD
        HomeContent(
            user = user,
            tips = tips,
            batteryState = batteryState,
            onLogout = onLogout,
            onRefreshTips = { tipsViewModel.forceRefresh() },
            padding = padding
        )
    }
}

@Composable
fun HomeContent(
    user: User,
    tips: List<Tip>,
    batteryState: BatteryUiState,
    onLogout: () -> Unit,
    onRefreshTips: () -> Unit,
    padding: PaddingValues = PaddingValues(0.dp)
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        // Welcome container
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .border(1.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .padding(20.dp)
        ) {
            Text(
                text = "Welcome, ${user.email}",
                style = MaterialTheme.typography.headlineSmall
            )
        }

        // Tips Card
        TipsCardContent(tips = tips, onRefresh = onRefreshTips)

        // System Vitals Card
        SystemVitalsCard()

        // Battery Insights Card
        BatteryInsightsContent(state = batteryState)

        // Logout button
        OutlinedButton(
            onClick = onLogout,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.error),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = MaterialTheme.colorScheme.error
            )
        ) {
            Text("Logout")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    DeviceHealthTheme {
        HomeContent(
            user = User(firebaseUid = "preview_uid", email = "preview@example.com"),
            tips = listOf(Tip(id = 1, message = "Optimize background apps.")),
            batteryState = BatteryUiState(
                health = "Good", 
                status = "Discharging",
                temperature = 30f,
                voltage = 4000,
                capacity = 5000
            ),
            onLogout = {},
            onRefreshTips = {}
        )
    }
}
=======
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
>>>>>>> 04e30d32b4066876e58de37f6881e79e69005b51
