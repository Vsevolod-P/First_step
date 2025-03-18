package helpers

import com.google.gson.Gson
import com.google.gson.JsonObject
import io.qameta.allure.Step
import kotlinx.coroutines.runBlocking

class UserApi : BaseHttpClient() {

    companion object {

        const val API_PATH = "/api/auth/register"
        const val API_LOGIN_PATH = "/api/auth/login"
        const val API_USER_PATH = "/api/auth/user"
    }

    private val gson = Gson()
    @Step("Создаем пользователя")
    fun createUserRequest(user: User): String {
        return doPostRequest(API_PATH, user)
    }
    @Step("Авторизуемся для получения токена и удаляем пользователя")
    fun deleteUser (email: String, password: String) {
        val loginRequest = UserLoginApi.LoginRequest(email, password)
        val response = doPostRequest(API_LOGIN_PATH, loginRequest)

        val userToken = gson.fromJson(response, JsonObject::class.java).get("accessToken").asString

        runBlocking {
            doDeleteRequest(API_USER_PATH, userToken)
        }
    }
}