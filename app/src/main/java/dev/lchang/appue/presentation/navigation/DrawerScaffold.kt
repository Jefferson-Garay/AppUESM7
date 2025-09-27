package dev.lchang.appue.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.ModifierLocalMap
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerScaffold(navController: NavController, content: @Composable () -> Unit){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Spacer(modifier= Modifier.height(12.dp))
                Text(text = "Menu Principal", modifier = Modifier.padding(16.dp))
                // Nav Item
                NavigationDrawerItem(
                    label = {Text(text="Inicio")},
                    selected = false,
                    onClick={
                        navController.navigate(route = "home")
                        scope.launch { drawerState.close() }
                    }
                )

                // Nav permisissions
                NavigationDrawerItem(
                    label = {Text(text="Permisos")},
                    selected = false,
                    onClick={
                        navController.navigate(route = "permissions")
                        scope.launch { drawerState.close() }
                    }
                )

                // Favorite Item
                NavigationDrawerItem(
                    label = {Text(text="Favoritos")},
                    selected = false,
                    onClick={
                        navController.navigate(route = "favorites")
                        scope.launch { drawerState.close() }
                    }
                )


            }
        }
    ) {
        //ACa ira el icono Que queremos mostar, Es poco inusial pero is lo ahremos
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {Text(text="App UESAN")},
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch { drawerState.close() }
                            }
                        ){
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) {
            paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)){
                content()
            }
        }

    }
}