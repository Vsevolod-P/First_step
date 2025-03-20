package helpers

import io.qameta.allure.Step
import kotlinx.coroutines.runBlocking

class UserApi : BaseHttpClient() {

    companion object {

        const val API_PATH = "/api/auth/register"
        const val API_USER_PATH = "/api/auth/user"
    }

    @Step("Создаем пользователя")
    fun createUserRequest(user: User): User {
        return doPostRequest(API_PATH, user)
    }
    @Step("Авторизуемся для получения токена и удаляем пользователя")
    fun deleteUser (user : User) {
        runBlocking {
            doDeleteRequest(API_USER_PATH, user.accessToken)
        }
    }
}