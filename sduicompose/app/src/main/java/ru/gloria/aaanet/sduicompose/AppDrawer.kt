package ru.gloria.aaanet.sduicompose

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun ColumnScope.AppDrawer(
    content: @Composable (ColumnScope.() -> Unit)? = null
) {
    AppInfo()
    Divider(Modifier.fillMaxWidth())
    content?.invoke(this)
    //bottom content
    Spacer(Modifier.weight(1f, true))
    Divider(Modifier.fillMaxWidth())
    DeviceInfo()
}

@Composable
fun ColumnScope.NavigationMenu(
    navController: NavController,
    content: @Composable() (ColumnScope.(navController: NavController) -> Unit)?
) {
    content?.invoke(this, navController)
}