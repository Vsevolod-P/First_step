package page_object

import io.qameta.allure.Step
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions

class MainPage(driver: WebDriver) : BasePage(driver)  {

    private val personalCabinetButtonLink = ".//p[(text()='Личный Кабинет')]"
    private val loginButtonLink = "//button[text()='Войти в аккаунт']"

    @Step("Ждем загрузки главной")
    fun waitForMainPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Соберите бургер')]")))
    }

    @Step("переходим на булки")
    fun goToBun() {
        driver.findElement(By.xpath("//span[text()='Булки']/..")).click()
    }

    @Step("переходим на соусы")
    fun goToSouces() {
        driver.findElement(By.xpath("//span[text()='Соусы']/..")).click()
    }

    @Step("переходим на начинки")
    fun goToIngridient() {
        driver.findElement(By.xpath("//span[text()='Начинки']/..")).click()
    }

    @Step("ждем загрузки главной страницы переключенной на меню булок")
    fun returnTextWaitForMainPageSelectBuns(): String {
        // решить чтобы не возвращал при ошибке
        val tabElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By
                    .xpath("//span[text()='Булки']/..")
            )
        )
        val currentClassName = tabElement.getAttribute("class")
        return currentClassName
    }

    @Step("ждем загрузки главной страницы переключенной на меню суосов")
    fun waitForMainPageSouces(): String {
        val tabElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By
                    .xpath("//span[text()='Соусы']/..")
            )
        )
        val currentClassName = tabElement.getAttribute("class")
        return currentClassName
    }

    @Step("ждем загрузки главной страницы переключенной на меню начинок")
    fun waitForMainPageIngridient(): String {
        val tabElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By
                    .xpath("//span[text()='Начинки']/..")
            )
        )
        val currentClassName = tabElement.getAttribute("class")
        return currentClassName
    }
}