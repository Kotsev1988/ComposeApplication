package com.example.composeapplication.presentation.screens


import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.composeapplication.R
import com.example.composeapplication.presentation.BottomMenuItem
import com.example.composeapplication.presentation.screens.blogs.BlogsScreen
import com.example.composeapplication.presentation.screens.details.DetailScreen
import com.example.composeapplication.presentation.screens.messages.MessageScreen
import com.example.composeapplication.presentation.screens.more.MoreScreen
import com.example.composeapplication.presentation.screens.search.SearchScreen
import com.example.composeapplication.presentation.screens.shopping.ShoppingScreen
import com.example.composeapplication.presentation.sign_in.UserData
import com.example.composeapplication.presentation.util.Screens

private const val TAB_MAIN = "tab_main"
private const val TAB_SEARCH = "tab_search"
private const val TAB_SHOPPING = "tab_shopping"
private const val TAB_MESSAGE = "tab_message"
private const val TAB_MORE = "tab_more"
private const val TAB_DETAILS = "DetailScreen/{id}"

@SuppressLint("SuspiciousIndentation")
@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    activity: ComponentActivity,
    userData: UserData?,
    onSignOut: () -> Unit,
) {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val context: Context = LocalContext.current
    var title by remember { mutableStateOf("") }

    LaunchedEffect(navController){
        navController.currentBackStackEntryFlow.collect {
            title = it.destination.route ?: ""
        }
    }


    val bottomItems = listOf(

        BottomMenuItem(
            label = "blog_screen",
            stringId = R.string.blog_screen,
            icon = painterResource(id = R.drawable.map_search_ic)
        ),
        BottomMenuItem(
            label = "shopping_screen",
            stringId = R.string.shopping_screen,
            icon = painterResource(id = R.drawable.home_ic)
        ),
        BottomMenuItem(
            label = "search_screen",
            stringId = R.string.search_screen,
            icon = painterResource(id = R.drawable.shopping_ic)
        ),
        BottomMenuItem(
            label = "message_screen",
            stringId = R.string.message_screen,
            icon = painterResource(id = R.drawable.message_ic)
        ),
        BottomMenuItem(
            label = "more_screen",
            stringId = R.string.more_screen,
            icon = painterResource(id = R.drawable.else_ic)
        ),
    )

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = getTitle(title, context),
                style = TextStyle(
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 24.sp,
                    fontWeight = FontWeight(400),
                    lineHeight = 28.8.sp
                )
                ) },

                actions = {

                    IconButton(
                        onClick = onSignOut,

                    ) {
                        Icon(Icons.Filled.ExitToApp, "backIcon")
                    }
                },


                navigationIcon = {

                    if (currentDestination?.route != TAB_MAIN && currentDestination?.route!=null) {

                            IconButton(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(100))
                                    .requiredWidth(40.dp)
                                    .requiredHeight(40.dp)
                                    .background(MaterialTheme.colorScheme.inversePrimary),
                                onClick = {
                                    navController.navigateUp()
                                },
                            )
                            {
                                Icon(
                                    Icons.Filled.ArrowBack,
                                    "backIcon")
                            }


                    }
                }
            )
        },

        bottomBar = {
            BottomNavigation(backgroundColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.primary
                ) {
                bottomItems.forEach { screen ->
                    val selected =
                        currentDestination?.hierarchy?.any { it.route == screen.label } == true

                    BottomNavigationItem(
                        selected = selected,
                        onClick = {
                            navController.navigate(screen.label) {

                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },

                        selectedContentColor = Color(0xFF4096FB),
                        unselectedContentColor = Color(0x4D0D0D0D),
                        label = {
                            Text(
                                stringResource(screen.stringId),

                                color = if (selected) Color(0xFF4096FB) else MaterialTheme.colorScheme.onSecondary,
                                textAlign = TextAlign.Center,
                                fontSize = 12.sp,
                                fontWeight = FontWeight(400),
                                lineHeight = 16.sp
                            )
                        },
                        icon = {

                            Icon(
                                painter = screen.icon, contentDescription = screen.label,
                                tint = if (selected) Color(0xFF4096FB) else MaterialTheme.colorScheme.onSecondary
                            )
                        }
                    )
                }
            }
        }
    ) { contentPadding ->



        NavHost(
            navController = navController,
            startDestination = Screens.BlogScreen.route,
            Modifier.padding(contentPadding)
        ) {

            navigation(
                startDestination = TAB_MAIN,
                route = Screens.BlogScreen.route
            ) {
                composable(TAB_MAIN) { BlogsScreen(navController) }

                composable(
                    route = Screens.DetailScreen.route,
                    arguments = listOf(navArgument("id") { type = NavType.IntType })

                ) {
                    it.arguments?.getInt("id")?.let { id -> DetailScreen(id) }
                }
            }

            navigation(
                startDestination = TAB_SEARCH,
                route = Screens.SearchScreen.route
            ) {
                composable(TAB_SEARCH) { SearchScreen() }
            }

            navigation(
                startDestination = TAB_SHOPPING,
                route = Screens.ShoppingScreen.route
            ) {
                composable(TAB_SHOPPING) { ShoppingScreen() }
            }

            navigation(
                startDestination = TAB_MESSAGE,
                route = Screens.MessageScreen.route
            ) {
                composable(TAB_MESSAGE) { MessageScreen() }
            }

            navigation(
                startDestination = TAB_MORE,
                route = Screens.MoreScreen.route
            ) {
                composable(TAB_MORE) { MoreScreen() }
            }
        }
    }
}

fun getTitle(route: String, context: Context): String{
    return  when(route){
        TAB_DETAILS -> context.getString(R.string.detail_screen)
        TAB_MAIN -> context.getString(R.string.blog_screen)
        TAB_SEARCH -> context.getString(R.string.search_screen)
        TAB_SHOPPING -> context.getString(R.string.shopping_screen)
        TAB_MESSAGE -> context.getString(R.string.message_screen)
        TAB_MORE -> context.getString(R.string.more_screen)
        else -> ""
    }
}



