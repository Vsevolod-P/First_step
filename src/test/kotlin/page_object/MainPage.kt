package page_object

import io.qameta.allure.Step
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions

class MainPage(driver: WebDriver) : BasePage(driver)  {
    @Step("Ждем загрузки главной")
    fun waitForMainPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Соберите бургер')]")))
    }
}