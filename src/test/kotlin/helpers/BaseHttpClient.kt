package helpers

import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.coroutines.awaitStringResponseResult
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.coroutines.runBlocking

abstract class BaseHttpClient {

    private val fuelManager : FuelManager = FuelManager().apply {
        basePath = Const_URL.BASE_URL
    }
    private val gson = Gson()


    fun doPostRequest(path: String, body : User) : User {
        return runBlocking {
            val (request, response, result) = fuelManager.post(path)
                .header("Content-Type", "application/json")
                .body(gson.toJson(body))
                .awaitStringResponseResult()

            when (result) {
                is Result.Failure -> {
                    throw Exception("Error: ${result.getException().message}")
                }
                is Result.Success -> {
                    val authResponse = gson.fromJson(result.get(), JsonObject::class.java).get("accessToken").asString
                    body.accessToken = authResponse
                    return@runBlocking body
                }
            }
        }
    }
    suspend fun doDeleteRequest(path: String, accessToken: String): String {
        val (request, response, result) = fuelManager.delete(path)
            .header("Content-Type", "application/json")
            .header("Authorization", accessToken)
            .awaitStringResponseResult()

        return when (result) {
            is Result.Failure -> {
                throw Exception("Error: ${result.getException().message}")
            }
            is Result.Success -> {
                result.get()
            }
        }
    }
}