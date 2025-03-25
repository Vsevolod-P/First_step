package tests

import BaseTest
import helpers.Const_URL
import helpers.User
import helpers.UserApi
import io.qameta.allure.Description
import io.qameta.allure.Step
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import page_object.LoginPage
import page_object.MainPage

class TestLogin : BaseTest() {

    @BeforeEach
    override fun setUp() {
        super.setUp()
        driver.get(Const_URL.BASE_URL_LOGIN)
    }


    @Test
    @Description("Проверка авторизации")
    @Step("Вводим данные пользователя")
    fun testLogin() {
        userApi = UserApi()
        user = User()
        UserApi().createUserRequest(user)
        LoginPage(driver).let{
            it.loginData(user)
            it.loginClick()
        }
        MainPage(driver).let{
            it.waitForMainPage()
        }
        assertEquals(
            Const_URL.BASE_URL_AFTER_RETURN,
            driver.currentUrl,
            "Не произошел переход на главную страницу после авторизации со страницы логина"
        )
    }
}
