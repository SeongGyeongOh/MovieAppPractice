package com.osg.movieapppractice.util

import android.util.Log

object Logger {
    private const val LOG_TAG = "SeongGGG"
    private const val FORMAT = "[%s]: %s"
    val isdebug = true
    fun d(message: String) {
        if (!isdebug) return
        val logMsg = String.format(FORMAT, getCallerInfo(), message)
        Log.d(LOG_TAG, logMsg)
    }
    fun e(message: String) {
        if (!isdebug) return
        val logMsg = String.format(FORMAT, getCallerInfo(), message)
        Log.e(LOG_TAG, logMsg)
    }
    private fun getCallerInfo(): String? {
        val elements = Exception().stackTrace
        /**
         * elements[2]를 하는 이유는 StacktraceElement[0] 은 첫번째로 StacktraceElement 가 호출된 부분 즉 getCallerInfo() 이며,
         * StacktraceElement[1] 은 두번째로 StacktraceElement 가 호출된 부분 즉 v, d, i, w, e 메소드이다.
         * 결국은 로그를 호출하는 부분은 그다음 StacktraceElement 가 호출되는 부분이므로 배열로는 0->1->2 부분이 되어진다.
         * 테스트를 위해 위에 주석된 부분을 해제하고 아래 실제코드를 주석처리하여 테스트를 해보면 바로 알 수가 있다.
         */
        if (elements.size < 2) return ""
        val className = elements[2].className
        val methodName = elements[2].methodName
        return " Class : " + className.substring(
            className.lastIndexOf(".") + 1,
            className.length
        ) + " , Method : " + methodName + " , LineNum : " + elements[2].lineNumber
    }
}
