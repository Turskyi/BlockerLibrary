package ua.turskyi.blocker

import retrofit2.Call
import retrofit2.http.*

interface GitLabClient {
    @GET("users/{userId}/projects/")
    fun reposForUser(@Path("userId") userId: String): Call<List<GitLabRepo>>
}
