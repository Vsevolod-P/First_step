package tests


import BaseTest
import io.qameta.allure.Description
import io.qameta.allure.Step
import org.junit.jupiter.api.Test
import page_object.MainPage


class TestMainPage : BaseTest() {

    @Test
    @Description("Проверка отображения ингредиентов")
    @Step("Проверяем отображение булок и клик по булкам")
    fun testBun() {
        MainPage(driver).let {
            it.goToIngridient()
            it.goToBun()
            it.TextWaitForMainPageSelectBunsAndCheckSelectTab()
        }
    }

    @Test
    @Description("Проверка отображения соусов")
    @Step("Переключаем на вкладку соусов и проверяем отображение")
    fun testSouces() {
        MainPage(driver).let {
            it.goToSouces()
            it.waitForMainPageSoucesAndCheckSelectTab()
        }
    }

    @Test
    @Description("Проверка отображения начинки")
    @Step("Переключаем на вкладку начинки")
    fun testIngridient() {
        MainPage(driver).let {
            it.goToIngridient()
            it.waitForMainPageIngridientAndCheckSelectTab()
        }
    }
}