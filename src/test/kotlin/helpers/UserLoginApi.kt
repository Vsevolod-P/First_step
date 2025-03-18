package helpers

data class UserLoginApi(
    val email: String,
    val password: String
) {
    data class LoginRequest(
        val email: String,
        val password: String
    )
}