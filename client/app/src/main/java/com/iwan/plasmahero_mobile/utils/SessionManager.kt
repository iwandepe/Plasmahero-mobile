package com.iwan.plasmahero_mobile.utils

import android.content.Context
import android.content.SharedPreferences

object SessionManager {
    val USER_ID = "USER_ID"
    val USER_EMAIL = "EMAIL"
    val USER_NAME = "NAME"
    val USER_TOKEN = "TOKEN"

    fun getSharedPreferences(context: Context): SharedPreferences = context.getSharedPreferences("Session", Context.MODE_PRIVATE)

    inline fun SharedPreferences.editMe(operation: (SharedPreferences.Editor) -> Unit) {
        val editMe = edit()
        operation(editMe)
        editMe.apply()
    }

    var SharedPreferences.userId
        get() = getInt(USER_ID, 0)
        set(value) {
            editMe {
                it.putInt(USER_ID, value)
            }
        }

    var SharedPreferences.token
        get() = getString(USER_TOKEN, "")
        set(value) {
            editMe {
                it.putString(USER_TOKEN, value)
            }
        }

    var SharedPreferences.name
        get() = getString(USER_NAME, "")
        set(value) {
            editMe {
                it.putString(USER_NAME, value)
            }
        }

    var SharedPreferences.email
        get() = getString(USER_EMAIL, "")
        set(value) {
            editMe {
                it.putString(USER_EMAIL, value)
            }
        }

    var SharedPreferences.clearValues
        get() = { }
        set(value) {
            editMe {
                it.clear()
            }
        }
}