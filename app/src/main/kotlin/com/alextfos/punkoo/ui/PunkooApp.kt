package com.alextfos.punkoo.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alextfos.beer.navigation.addBeerDetailScreen
import com.alextfos.beer.navigation.addBeerListScreen
import com.alextfos.beer.navigation.addSearchScreen
import com.alextfos.punkoo.R
import com.alextfos.punkoo.navigation.CreateNavigation
import com.alextfos.punkoo.common.navigation.Screen
import com.alextfos.punkoo.styles.ui.theme.PunkooTheme
import com.alextfos.punkoo.styles.ui.theme.ThemeType


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PunkooApp(
    navController: NavHostController = rememberNavController(),
) {
    val selectedTheme = if (isSystemInDarkTheme()) {
        ThemeType.DARK
    } else {
        ThemeType.LIGHT
    }

    PunkooTheme(selectedTheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .nestedScroll(scrollBehavior.nestedScrollConnection),
                topBar = {
                    TopAppBar(
                        title = { Text(
                            stringResource(R.string.app_name)
                        ) },
                        actions = {
                            IconButton( onClick = {

                            }) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = stringResource(id = com.alextfos.punkoo.common.R.string.action_search)
                                )
                            }
                        },
                        scrollBehavior = scrollBehavior
                    )
                }
            ) {
                Box(
                    modifier = Modifier
                        .padding(it)
                ) {
                    CreateNavigation(navController) { navBuilder ->
                        navBuilder.addBeerListScreen {
                            navController.navigate(Screen.BeerDetail.createRoute(it))
                        }
                        navBuilder.addSearchScreen {
                            navController.navigate(Screen.BeerDetail.route)
                        }
                        navBuilder.addBeerDetailScreen()
                    }
                }
            }
        }
    }
}
