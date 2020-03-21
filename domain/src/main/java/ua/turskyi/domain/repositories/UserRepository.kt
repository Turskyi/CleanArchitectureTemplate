package ua.turskyi.domain.repositories

import io.reactivex.Single
import ua.turskyi.domain.models.User

//TODO: 14
interface UserRepository {
    fun getUsers(): Single<List<User>>
}