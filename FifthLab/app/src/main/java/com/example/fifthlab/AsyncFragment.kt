package com.example.fifthlab


import android.os.AsyncTask
import android.os.Bundle

import java.util.concurrent.TimeUnit

class AsyncFragment : androidx.fragment.app.Fragment() {
    companion object{
        const val Tag = "Async"
    }
    var humans = mutableListOf<Human>()
    private val humansListener: HumansListener = {
        if (it != null) {
            humans.add(it)
            val activityCallback = requireActivity() as ActivityCallback
            activityCallback.getNewHuman(it)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        HumanHolder.addListener(humansListener)
        MessagesSender().execute()
    }
    class MessagesSender : AsyncTask<Unit, Unit, Unit>() {

        override fun doInBackground(vararg p0: Unit?) {
            try {
                for (i in 1..HumanHolder.humans.count()) {
                    TimeUnit.SECONDS.sleep(2)
                    publishProgress()
                }
            }catch (e: InterruptedException){
                e.printStackTrace()

            }
        }


        override fun onProgressUpdate(vararg p0: Unit?) {
            super.onProgressUpdate()
            HumanHolder.sendMessage()
        }
    }
}