package ro.dragossusi.logger

import android.util.Log

open class AndroidLogger(
    val tag: String
) : TagLogger {
    override fun i(message: String) {
        Log.i(tag, message)
    }

    override fun d(message: String) {
        Log.d(tag, message)
    }

    override fun e(message: String) {
        Log.e(tag, message)
    }

    override fun e(throwable: Throwable) {
        Log.e(tag, throwable.message, throwable)
    }

    override fun w(message: String) {
        Log.w(tag, message)
    }
}