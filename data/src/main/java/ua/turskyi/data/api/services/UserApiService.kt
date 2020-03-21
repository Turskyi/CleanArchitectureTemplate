package ua.turskyi.data.api.services

import io.reactivex.Single
import retrofit2.http.GET
import ua.turskyi.data.api.responses.UserListResponse

interface UserApiService {
    @GET("users")
    fun getUsers(): Single<UserListResponse>
}