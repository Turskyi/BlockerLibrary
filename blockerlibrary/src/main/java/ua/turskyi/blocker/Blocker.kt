package ua.turskyi.blocker

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ua.turskyi.blocker.Constants.API_BASE_URL
import ua.turskyi.blocker.Constants.SHARED_PREFS_BLOCKED

object Blocker {
    fun appIsBlocked(context: Context): Boolean {
        val sharedPreferences: SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)
        return sharedPreferences.getBoolean(SHARED_PREFS_BLOCKED, false)
    }

    fun checkIfAppIsBlocked(activity: Activity, projectName: String, userId: String) {
        val builder: Retrofit.Builder = Retrofit.Builder().baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
        val retrofitClient: Retrofit = builder.build()
        val gitLabClient:GitLabClient = retrofitClient.create(GitLabClient::class.java)
        val call: Call<List<GitLabRepo>> = gitLabClient.reposForUser(userId)
        call.enqueue(object : Callback<List<GitLabRepo>> {
            override fun onResponse(
                call: Call<List<GitLabRepo>>, response: Response<List<GitLabRepo>>
            ) {
                response.body()?.let { projectList: List<GitLabRepo> ->
                    projectList.forEach {
                        if (it.name.equals(projectName)) {
                            true.saveAnswerIfBlocked(activity)
                            activity.finishAndRemoveTask()
                        }
                    }
                }
            }

            @Suppress("EmptyMethod")
            override fun onFailure(call: Call<List<GitLabRepo>>, t: Throwable) {
                // the network call was a failure
            }
        })
    }

    private fun Boolean.saveAnswerIfBlocked(context: Context) {
        val sharedPreferences: SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putBoolean(SHARED_PREFS_BLOCKED, this)
        editor.apply()
    }
}
