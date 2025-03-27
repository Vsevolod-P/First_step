package helpers

import io.qameta.allure.Step

class UserApi : BaseHttpClient() {

    private val API_PATH = "/api/auth/register"
    private val API_USER_PATH = "/api/auth/user"

    @Step("Создаем пользователя")
    fun createUserRequest(user: User): User {
        return doPostRequest(API_PATH, user)
    }
    @Step("Авторизуемся для получения токена и удаляем пользователя")
    fun deleteUser (user : User) {
            doDeleteRequest(API_USER_PATH, user.accessToken)
    }
}