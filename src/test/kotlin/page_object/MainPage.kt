package page_object

import io.qameta.allure.Step
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import kotlin.test.assertTrue

class MainPage(driver: WebDriver) : BasePage(driver)  {

    private val focusedMenuTab = "tab_tab_type_current__2BEPc"
    private val bunTab = "//span[text()='Булки']/.."
    private val soucesTab = "//span[text()='Соусы']/.."
    private val ingridientTab = "//span[text()='Начинки']/.."

    @Step("Ждем загрузки главной")
    fun waitForMainPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Соберите бургер')]")))
    }

    @Step("переходим на булки")
    fun goToBun() {
        driver.findElement(By.xpath(bunTab)).click()
    }

    @Step("переходим на соусы")
    fun goToSouces() {
        driver.findElement(By.xpath(soucesTab)).click()
    }

    @Step("переходим на начинки")
    fun goToIngridient() {
        driver.findElement(By.xpath(ingridientTab)).click()
    }


    @Step("ждем загрузки главной страницы переключенной на меню булок и проверяем локатор переключения")
    fun TextWaitForMainPageSelectBunsAndCheckSelectTab(){
        val tabElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(bunTab)))
        val currentClassName = tabElement.getAttribute("class")
        assertTrue(currentClassName.contains(focusedMenuTab), "Не найден локатор")
    }

    @Step("ждем загрузки главной страницы переключенной на меню суосов и проверяем локатор переключения")
    fun waitForMainPageSoucesAndCheckSelectTab() {
        val tabElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(soucesTab)))
        val currentClassName = tabElement.getAttribute("class")
        assertTrue(currentClassName.contains(focusedMenuTab), "Не найден локатор")
    }

    @Step("ждем загрузки главной страницы переключенной на меню начинок и проверяем локатор переключения")
    fun waitForMainPageIngridientAndCheckSelectTab() {
        val tabElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ingridientTab)))
        val currentClassName = tabElement.getAttribute("class")
        assertTrue(currentClassName.contains(focusedMenuTab), "Не найден локатор")
    }
}