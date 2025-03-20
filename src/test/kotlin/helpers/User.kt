package helpers

import java.time.Instant

data class User(val email : String = "testKurica${Instant.now().toEpochMilli()}@pivo.ru",
                val password : String = "Parol4ek123",
                val name : String = "SaskeOtstoy",
                var accessToken : String = null.toString()
)
