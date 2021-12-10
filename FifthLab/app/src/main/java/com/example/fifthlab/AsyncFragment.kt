package com.example.fifthlab

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import java.util.concurrent.TimeUnit

class AsyncFragment : Fragment() {
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
    class MessagesSender : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg p0: Void?): Void? {
            for (i in 1..HumanHolder.humans.count()) {
                TimeUnit.SECONDS.sleep(2)
                publishProgress()
            }
            return null
        }
        override fun onProgressUpdate(vararg p0: Void?) {
            super.onProgressUpdate()
            HumanHolder.sendMessage()
        }
    }
}