package page_object

import org.openqa.selenium.WebDriver
import io.qameta.allure.Step
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions


class LoginPage(driver: WebDriver) : BasePage(driver) {

    @Step("Вводим данные для входа")
    fun loginData(email: String, password: String) {
        driver.findElement(By.xpath("(//fieldset)[1]/div/div/input")).sendKeys(email)
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password)
    }

    @Step("Кликаем по кнопке Войти")
    fun loginClick() {
        val bySmthng = By.xpath("//button[text()='Войти']")
        val test: WebElement = driver.findElement(bySmthng)
        test.click()
    }

    private fun getEnterButton(): WebElement {
        val bySmthng = By.xpath("//button[text()='Войти']")
        return driver.findElement(bySmthng)
    }

    fun loginText(): String {
        return getEnterButton().text
    }

    @Step("Кликаем по кнопке зарегистрироваться")
    fun registrationClick() {
        driver.findElement(By.xpath("//a[text()='Зарегистрироваться']")).click()
    }

    @Step("Кликаем по кнопке Восстановить пароль")
    fun restorePasswordClick() {
        driver.findElement(By.xpath("//a[text()='Восстановить пароль']")).click()
    }

    fun waitLoginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Войти']")))
    }
}