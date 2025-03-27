package page_object

import helpers.User
import org.openqa.selenium.WebDriver
import io.qameta.allure.Step
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions


class LoginPage(driver: WebDriver) : BasePage(driver) {

    val buttonLogin  = "//button[text()='Войти']"
    val inputEmail = "(//fieldset)[1]/div/div/input"
    val inputPassword = "//input[@type='password']"
    val buttonRegistrtion = "//a[text()='Зарегистрироваться']"
    val buttonRestorPassword = "//a[text()='Восстановить пароль']" //в целом по одному можно было не выносить, но увлекся

    @Step("Вводим данные для входа")
    fun loginData(user : User) {
        driver.findElement(By.xpath(inputEmail)).sendKeys(user.email)
        driver.findElement(By.xpath(inputPassword)).sendKeys(user.password)
    }

    @Step("Кликаем по кнопке Войти")
    fun loginClick() {
        val bySmthng = By.xpath(buttonLogin)
        val test: WebElement = driver.findElement(bySmthng)
        test.click()
    }

    private fun getEnterButton(): WebElement {
        val bySmthng = By.xpath(buttonLogin)
        return driver.findElement(bySmthng)
    }

    fun loginText(): String {
        return getEnterButton().text
    }

    @Step("Кликаем по кнопке зарегистрироваться")
    fun registrationClick() {
        driver.findElement(By.xpath(buttonRegistrtion)).click()
    }

    @Step("Кликаем по кнопке Восстановить пароль")
    fun restorePasswordClick() {
        driver.findElement(By.xpath(buttonRestorPassword)).click()
    }

    fun waitLoginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonLogin)))
    }
}