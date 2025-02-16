package com.faqihzain.movieguidekotlin.util

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

public class AppExecutors {
    val diskIO = Executors.newSingleThreadExecutor()
    //executor to put runnable into the main Thread queue from a background thread
    val mainThreadExecutor = MainThreadExecutor()

    class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())
        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }
}