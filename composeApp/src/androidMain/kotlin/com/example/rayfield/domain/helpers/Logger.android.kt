package com.example.rayfield.domain.helpers

import android.util.Log

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual object Logger {
    actual fun e(tag: String, message: String) { Log.e(tag, message) }
    actual fun i(tag: String, message: String) { Log.i(tag, message) }
}