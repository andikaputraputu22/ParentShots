package com.nandikacreativestudio.parentshots

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.nandikacreativestudio.parentshots.data.model.NavigationItem
import com.nandikacreativestudio.parentshots.ui.page.CategoryScreen
import com.nandikacreativestudio.parentshots.ui.page.HomeScreen
import com.nandikacreativestudio.parentshots.ui.page.PediaScreen
import com.nandikacreativestudio.parentshots.utils.Screen

@Composable
fun ParentShotsApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        val graph = navController.createGraph(startDestination = Screen.Home.route) {
            composable(route = Screen.Home.route) {
                HomeScreen()
            }
            composable(route = Screen.Category.route) {
                CategoryScreen()
            }
            composable(route = Screen.Pedia.route) {
                PediaScreen()
            }
        }
        NavHost(
            navController = navController,
            graph = graph,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val navItemList = listOf(
        NavigationItem(
            label = "Home",
            icon = R.drawable.ic_home,
            route = Screen.Home.route
        ),
        NavigationItem(
            label = "Category",
            icon = R.drawable.ic_category,
            route = Screen.Category.route
        ),
        NavigationItem(
            label = "Pedia",
            icon = R.drawable.ic_pedia,
            route = Screen.Pedia.route
        )
    )

    val colorScheme = MaterialTheme.colorScheme
    val selectedColor = colorScheme.primary
    val unselectedColor = colorScheme.onSurfaceVariant
    val backgroundColor = colorScheme.surface

    val selectedNavIndex = rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar(
        containerColor = backgroundColor
    ) {
        navItemList.forEachIndexed { index, navigationItem ->
            val isSelected = selectedNavIndex.intValue == index
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    selectedNavIndex.intValue = index
                    navController.navigate(navigationItem.route)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = navigationItem.icon),
                        contentDescription = navigationItem.label,
                        tint = if (isSelected) selectedColor else unselectedColor
                    )
                },
                label = {
                    Text(
                        text = navigationItem.label,
                        color = if (isSelected) selectedColor else unselectedColor
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = colorScheme.surfaceVariant
                )
            )
        }
    }
}