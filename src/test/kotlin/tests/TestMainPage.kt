//package tests
//
//import helperApi.BaseTest
//import helperClasses.MainPage
//import io.qameta.allure.Description
//import io.qameta.allure.Step
//import org.junit.Assert
//import org.junit.Test
//
//class TestMainPage : BaseTest() {
//    private var mainPage: MainPage? = null
//    private val focusedMenuTab = "tab_tab_type_current__2BEPc"
//
//    @Test
//    @Description("Проверка отображения ингредиентов")
//    @Step("Проверяем отображение булок и клик по булкам")
//    fun testBun() {
//        mainPage = MainPage(driver)
//        mainPage.goToIngridient()
//        mainPage.goToBun()
//        val text: String = mainPage.returnTextWaitForMainPageSelectBuns()
//        Assert.assertTrue("Класс элемента не изменился на ожидаемое значение", text.contains(focusedMenuTab))
//    }
//
//    @Test
//    @Description("Проверка отображения соусов")
//    @Step("Переключаем на вкладку соусов и проверяем отображение")
//    fun testSouces() {
//        mainPage = MainPage(driver)
//        mainPage.goToSouces()
//        val text: String = mainPage.waitForMainPageSouces()
//        Assert.assertTrue("Класс элемента не изменился на ожидаемое значение", text.contains(focusedMenuTab))
//    }
//
//    @Test
//    @Description("Проверка отображения начинки")
//    @Step("Переключаем на вкладку начинки")
//    fun testIngridient() {
//        mainPage = MainPage(driver)
//        mainPage.goToIngridient()
//        val text: String = mainPage.waitForMainPageIngridient()
//        Assert.assertTrue("Класс элемента не изменился на ожидаемое значение", text.contains(focusedMenuTab))
//    }
//}