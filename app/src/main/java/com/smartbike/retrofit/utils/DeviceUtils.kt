package com.smartbike.retrofit.utils

import android.content.Context
import android.view.KeyCharacterMap
import android.view.KeyEvent

/**
 * Devuelve true si el dispositivo tiene teclas físicas de navegación (Back o Home).
 * Se usa para decidir si mostrar un botón "Atrás" en la UI o dejar que el sistema lo provea.
 */
fun Context.hasPhysicalNavigationKeys(): Boolean {
    val hasBack = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK)
    val hasHome = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_HOME)
    return hasBack || hasHome
}

