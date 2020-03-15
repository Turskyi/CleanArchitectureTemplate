package ua.turskyi.domain.repositories

import io.reactivex.Single
import ua.turskyi.domain.models.User

interface UserRepository {
    fun getUsers(): Single<List<User>>
}