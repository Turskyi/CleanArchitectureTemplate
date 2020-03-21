package ua.turskyi.domain.models

//TODO:13
class User(
    val id: Int,
    val name: String,
    val phone: String
){
    companion object {
        val users = arrayOf(
            User(
                1,
                "Bob",
                "555"
            ),
            User(2,
                "Jobs",
                "8095"
            ),
            User(3,
                "Alice",
                "0943"
            ),
            User(4,
                "Lucy",
                "067"
            )
        )
    }
}
