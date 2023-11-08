package com.example.composeapplication.presentation.sign_in


data class SignInResult(
    val data: UserData?,
    val errorMessage: String?
)