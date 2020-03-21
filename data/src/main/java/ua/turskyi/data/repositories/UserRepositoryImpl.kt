package ua.turskyi.data.repositories

import io.reactivex.Single
import ua.turskyi.data.api.services.UserApiService
import ua.turskyi.domain.models.User
import ua.turskyi.domain.repositories.UserRepository
import javax.inject.Inject

// TODO: 17
class UserRepositoryImpl @Inject constructor(private val userApiService: UserApiService
) : UserRepository {

    override fun getUsers(): Single<List<User>> {
        return userApiService.getUsers().map {
            it.map { userResponse ->
                userResponse.mapToDomain()
            }
        }
    }
}