package helpers

import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.coroutines.awaitStringResponseResult
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import kotlinx.coroutines.runBlocking



abstract class BaseHttpClient {

    private val fuelManager : FuelManager = FuelManager().apply {
        basePath = Const_URL.BASE_URL
    }
    private val gson = Gson()


    fun doPostRequest(path: String, body: Any): String {
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
                    result.get()
                }
            }
        }
    }
    suspend fun doDeleteRequest(path: String, token: String): String {
        val (request, response, result) = fuelManager.delete(path)
            .header("Content-Type", "application/json")
            .header("Authorization", token)
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