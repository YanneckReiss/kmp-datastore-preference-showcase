package com.yanneckreiss.kmpapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.yanneckreiss.kmpapp.R

@Composable
fun MainScreen() {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { MainAppBar() }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Text("Hello")
        }
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
