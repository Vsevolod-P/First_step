package tests

import BaseTest
import helpers.Const_URL
import helpers.UserApi
import io.qameta.allure.Description
import io.qameta.allure.Step
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestLogin : BaseTest() {

    @Test
    @Description("Проверка авторизации")
    @Step("Вводим данные пользователя")
    fun testLogin() {
        UserApi().createUserRequest(user)
        loginPage.loginData(user.email, user.password)
        loginPage.loginClick()
        mainPage.waitForMainPage()
        assertEquals(
            Const_URL.BASE_URL_AFTER_RETURN,
            driver.currentUrl,
            "Не произошел переход на главную страницу после авторизации со страницы логина"
        )
    }
}
