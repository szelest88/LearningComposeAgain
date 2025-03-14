package com.artmaj.myapplication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.artmaj.myapplication.R

// Set of Material typography styles to start with
object  CustomTypography{

    val SmallInfo = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 14.sp
    )
    val SemiInfo = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 18.sp,
        fontWeight =  FontWeight.Normal,
        lineHeight = 20.sp
    )
    val MainText = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 14.sp,
        fontWeight =  FontWeight.Normal,
        lineHeight = 16.sp
    )
    val Heading1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 22.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 24.sp
    )
}
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
