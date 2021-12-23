package com.example.notes.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Blue = Color(0xFF03A9F4)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val Gold = Color(0xFFFF9800)
val DarkGray = Color(0xFF202020)
val Gray = Color(0xFF888888)
val LightGray = Color(0xFFFCFCFC)
val DarkWhite = Color(0x55FFFFFF)
val LightBlue = Color(0xFFD7E8DE)
val Neutral4 = Color(0x1f000000)
val Neutral3 = Color(0x1fffffff)
val Transperent = Color( 0xff800000)


val Colors.topAppBarBackgroundColor: Color
    @Composable
    get() = if (isLight) Purple500 else DarkGray


val Colors.topAppBarContentColor: Color
    @Composable
    get() = if (isLight) Color.White else LightGray

val Colors.splashScreenBackground: Color
    @Composable
    get() = if (isLight) Purple700 else Color.Black

val Colors.taskItemTextColor: Color
    @Composable
    get() = if (isLight) DarkGray else LightGray

val Colors.taskItemBackgroundColor: Color
    @Composable
    get() = if (isLight) Color.White else DarkGray

val Colors.fabBackgroundColor: Color
    @Composable
    get() = if (isLight) Teal200 else Purple700
