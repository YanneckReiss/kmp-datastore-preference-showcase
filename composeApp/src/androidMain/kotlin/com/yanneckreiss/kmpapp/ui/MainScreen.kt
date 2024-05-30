package com.yanneckreiss.kmpapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.yanneckreiss.kmpapp.R
import com.yanneckreiss.kmpapp.domain.GetAppOpeningCountUseCase
import kmp_datastore_preference_showcase.composeapp.generated.resources.Res
import org.koin.compose.koinInject

@Composable
fun MainScreen(
    getAppOpeningCountUseCase: GetAppOpeningCountUseCase = koinInject()
) {
    var appOpeningCounter: Int by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        appOpeningCounter = getAppOpeningCountUseCase.call()
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { MainAppBar() }
    ) { innerPadding ->

        MainContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            counter = appOpeningCounter
        )
    }
}

@Composable
private fun MainContent(
    counter: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Counter",
            fontSize = 20.sp
        )
        Text(
            text = counter.toString(),
            fontSize = 40.sp
        )
    }
}

@Composable
private fun MainAppBar() {
    TopAppBar {
        Text(stringResource(R.string.app_name))
    }
}

@Preview
@Composable
private fun Preview_MainScreen() {
    MainScreen()
}
