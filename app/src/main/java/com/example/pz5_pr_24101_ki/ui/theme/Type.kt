package com.example.pz5_pr_24101_ki.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.R
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with

val InterFont = FontFamily(
    Font(com.example.pz5_pr_24101_ki.R.font.inter_regular, weight = FontWeight.Normal),
    Font(com.example.pz5_pr_24101_ki.R.font.inter_semibold, weight = FontWeight.SemiBold),
)



val Typography = Typography(
    // Стиль для имени автора
    titleSmall = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        letterSpacing = 0.sp
    ),
    // Стиль для текста сообщения
    bodyMedium = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        lineHeight = 19.5.sp,
        letterSpacing = 0.sp
    )
)
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
