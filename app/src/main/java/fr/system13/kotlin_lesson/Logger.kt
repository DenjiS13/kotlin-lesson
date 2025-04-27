package fr.system13.kotlin_lesson

import android.util.Log

class Logger {

    companion object {
        //        fun verbose(tag: String, message: String) = Log.v(tag, message)
        fun debug(tag: String, message: String) = Log.d(tag, message)
        //        fun info(tag: String, message: String) = Log.i(tag, message)
        //        fun warning(tag: String, message: String) = Log.w(tag, message)
        //        fun error(tag: String, message: String) = Log.e(tag, message)
        //        fun assert(tag: String, message: String) = Log.wtf(tag, message)
    }
}