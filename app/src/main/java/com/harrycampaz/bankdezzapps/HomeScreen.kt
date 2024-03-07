package com.harrycampaz.bankdezzapps

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.harrycampaz.bankdezzapps.components.BottomNavigationBar
import com.harrycampaz.bankdezzapps.sections.CardSection
import com.harrycampaz.bankdezzapps.sections.CurrenciesSection
import com.harrycampaz.bankdezzapps.sections.FinanceSection
import com.harrycampaz.bankdezzapps.sections.WalletSection

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    Scaffold(
        bottomBar = {

            BottomNavigationBar()
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {


            WalletSection()
            CardSection()
            Spacer(modifier = Modifier.height(16.dp))
            FinanceSection()
            CurrenciesSection()
        }
    }
}

