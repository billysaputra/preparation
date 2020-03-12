package com.billysaputra.preparation.helper

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Billy Saputra on 2020-03-12.
 */
object UserPreferences {
    private const val SP_NAME = "PreparationPreferences"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(SP_NAME, MODE)
    }

    enum class UserPreferencesEnum(val value: String) {
        EMAIL("EMAIL"),
        NAME("NAME"),
        ACCESS_TOKEN("ACCESS_TOKEN")
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var email: String
        get() = sharedPreferences.getString(UserPreferencesEnum.EMAIL.value, "") ?: ""
        set(email) = sharedPreferences.edit { it.putString(UserPreferencesEnum.EMAIL.value, email) }

    var name: String
        get() = sharedPreferences.getString(UserPreferencesEnum.NAME.value, "") ?: ""
        set(name) = sharedPreferences.edit{ it.putString(UserPreferencesEnum.NAME.value, name)}

    var accessToken: String
        get() = sharedPreferences.getString(UserPreferencesEnum.ACCESS_TOKEN.value, "") ?: ""
        set(accessToken) = sharedPreferences.edit{ it.putString(UserPreferencesEnum.ACCESS_TOKEN.value, accessToken)}
}