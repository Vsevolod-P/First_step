import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.chrome.ChromeDriver
import helpers.*

abstract class BaseTest {

    protected lateinit var driver: ChromeDriver
    protected lateinit var userApi: UserApi
    protected lateinit var user: User

    @BeforeEach
    open fun setUp() {
        driver = ChromeDriver()
        driver.get(Const_URL.BASE_URL)
    }

    @AfterEach
    fun tearDown() {
        if (::userApi.isInitialized) {
            userApi.deleteUser(user)
        }
        if (::driver.isInitialized) {
            driver.quit()
        }
    }
}