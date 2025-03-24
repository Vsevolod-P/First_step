package helpers

import java.time.Instant

interface UserParams {
    val email: String
    val password: String
    val name: String
}

data class User(
    override val email : String = "testKurica${Instant.now().toEpochMilli()}@pivo.ru",
    override val password : String = "Parol4ek123",
    override val name : String = "SaskeOtstoy",
    var accessToken : String = null.toString()
) : UserParams

data class UserNoToken(
    override val email : String = "testKurica${Instant.now().toEpochMilli()}@pivo.ru",
    override val password : String = "Parol4ek123",
    override val name : String = "SaskeOtstoy",
) : UserParams
