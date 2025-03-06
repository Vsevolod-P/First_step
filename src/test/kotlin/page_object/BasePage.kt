package page_object

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait


abstract class BasePage(protected val driver: WebDriver) {
    protected val wait: WebDriverWait = WebDriverWait(driver, java.time.Duration.ofSeconds(10))
}