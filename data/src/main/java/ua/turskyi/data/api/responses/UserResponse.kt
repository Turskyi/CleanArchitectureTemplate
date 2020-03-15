package ua.turskyi.data.api.responses

import com.google.gson.annotations.SerializedName
import ua.turskyi.domain.models.User

typealias UserListResponse = List<UserResponse>
class UserResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("phone") val phone: String
) {
    fun mapToDomain() = User(id, name, phone)
}