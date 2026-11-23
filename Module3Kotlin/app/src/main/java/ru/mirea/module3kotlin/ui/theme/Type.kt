package ru.mirea.module3kotlin.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.mirea.module3kotlin.R

val FiraSans = FontFamily(
    Font(R.font.fira_sans_regular, FontWeight.Normal),
    Font(R.font.fira_sans_medium, FontWeight.Medium),
    Font(R.font.fira_sans_bold, FontWeight.Bold),
)

val AppTypography = Typography(
    displaySmall = TextStyle(fontFamily = FiraSans, fontWeight = FontWeight.Bold, fontSize = 36.sp, lineHeight = 42.sp),
    headlineMedium = TextStyle(fontFamily = FiraSans, fontWeight = FontWeight.Bold, fontSize = 28.sp, lineHeight = 34.sp),
    headlineSmall = TextStyle(fontFamily = FiraSans, fontWeight = FontWeight.SemiBold, fontSize = 23.sp, lineHeight = 29.sp),
    titleLarge = TextStyle(fontFamily = FiraSans, fontWeight = FontWeight.Medium, fontSize = 21.sp, lineHeight = 27.sp),
    titleMedium = TextStyle(fontFamily = FiraSans, fontWeight = FontWeight.Medium, fontSize = 17.sp, lineHeight = 23.sp),
    bodyLarge = TextStyle(fontFamily = FiraSans, fontWeight = FontWeight.Normal, fontSize = 16.sp, lineHeight = 24.sp),
    bodyMedium = TextStyle(fontFamily = FiraSans, fontWeight = FontWeight.Normal, fontSize = 14.sp, lineHeight = 21.sp),
    labelMedium = TextStyle(fontFamily = FiraSans, fontWeight = FontWeight.Medium, fontSize = 13.sp, lineHeight = 18.sp),
)

