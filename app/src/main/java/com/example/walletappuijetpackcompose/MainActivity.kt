package com.example.walletappuijetpackcompose

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.example.walletappuijetpackcompose.ui.ActionSection
import com.example.walletappuijetpackcompose.ui.CardSection
import com.example.walletappuijetpackcompose.ui.TopBar
import com.example.walletappuijetpackcompose.ui.theme.WalletAppUIJetpackComposeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WalletAppUIJetpackComposeTheme {

                val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
                    state = rememberTopAppBarState()
                )

                Scaffold(
                    modifier = Modifier.nestedScroll(
                        scrollBehavior.nestedScrollConnection
                    ),
                    topBar = {
                        TopBar(
                            modifier = Modifier.fillMaxWidth(),
                            scrollBehavior = scrollBehavior
                        )
                    },

                    )
                { innerPadding ->
                    MainScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }

    @Composable
    fun MainScreen(modifier: Modifier = Modifier) {
          Column(
              modifier = Modifier.verticalScroll(rememberScrollState())
          ) {
              Spacer(modifier = Modifier.height(30.dp))
              CardSection(
                  modifier = Modifier.fillMaxWidth()
              )
              Spacer(modifier =Modifier.height(20.dp))
              ActionSection(modifier = Modifier.fillMaxWidth())
          }
    }
}

