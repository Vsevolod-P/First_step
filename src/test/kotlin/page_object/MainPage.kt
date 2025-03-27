package page_object

import io.qameta.allure.Step
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import kotlin.test.assertTrue

class MainPage(driver: WebDriver) : BasePage(driver)  {

    private val focusedMenuTab = "tab_tab_type_current__2BEPc"
    private val bunTab = By.xpath("//span[text()='Булки']/..")
    private val soucesTab = By.xpath("//span[text()='Соусы']/..")
    private val ingridientTab = By.xpath("//span[text()='Начинки']/..")
    private val waitBurgetText = By.xpath("//*[contains(text(),'Соберите бургер')]")

    @Step("Ждем загрузки главной")
    fun waitForMainPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitBurgetText))
    }

    @Step("переходим на булки")
    fun goToBun() {
        driver.findElement(bunTab).click()
    }

    @Step("переходим на соусы")
    fun goToSouces() {
        driver.findElement(soucesTab).click()
    }

    @Step("переходим на начинки")
    fun goToIngridient() {
        driver.findElement(ingridientTab).click()
    }


    @Step("ждем загрузки главной страницы переключенной на меню булок и проверяем локатор переключения")
    fun TextWaitForMainPageSelectBunsAndCheckSelectTab(){
        val tabElement = wait.until(ExpectedConditions.visibilityOfElementLocated(bunTab))
        val currentClassName = tabElement.getAttribute("class")
        assertTrue(currentClassName.contains(focusedMenuTab), "Не найден локатор")
    }

    @Step("ждем загрузки главной страницы переключенной на меню суосов и проверяем локатор переключения")
    fun waitForMainPageSoucesAndCheckSelectTab() {
        val tabElement = wait.until(ExpectedConditions.visibilityOfElementLocated(soucesTab))
        val currentClassName = tabElement.getAttribute("class")
        assertTrue(currentClassName.contains(focusedMenuTab), "Не найден локатор")
    }

    @Step("ждем загрузки главной страницы переключенной на меню начинок и проверяем локатор переключения")
    fun waitForMainPageIngridientAndCheckSelectTab() {
        val tabElement = wait.until(ExpectedConditions.visibilityOfElementLocated(ingridientTab))
        val currentClassName = tabElement.getAttribute("class")
        assertTrue(currentClassName.contains(focusedMenuTab), "Не найден локатор")
    }
}