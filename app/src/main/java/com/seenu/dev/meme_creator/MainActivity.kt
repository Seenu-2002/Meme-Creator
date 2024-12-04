package com.seenu.dev.meme_creator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.seenu.dev.meme_creator.presentation.meme_editor.MemeEditorScreen
import com.seenu.dev.meme_creator.presentation.meme_list.MemeListScreen
import com.seenu.dev.meme_creator.presentation.utils.Route
import com.seenu.dev.meme_creator.ui.theme.MemeCreatorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MemeCreatorTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Route.MemeList.name) {
                    composable(Route.MemeList.name) {
                        MemeListScreen(navController)
                    }
                    composable("${Route.MemeEdit.name}/{id}", arguments = listOf(navArgument("id") {
                        type = NavType.IntType
                    })) {
                        val drawableId =
                            it.arguments?.getInt("id") ?: R.drawable.jack_sparrow_being_chased_23
                        MemeEditorScreen(navController, drawableId)
                    }
                }
            }
        }
    }
}