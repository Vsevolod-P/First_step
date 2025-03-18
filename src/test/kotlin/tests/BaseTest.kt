import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.chrome.ChromeDriver
import page_object.*
import helpers.*

abstract class BaseTest {

    protected lateinit var driver: ChromeDriver
    protected lateinit var loginPage: LoginPage
    protected lateinit var mainPage: MainPage
    protected lateinit var userCreationAPI: UserCreationApi
    protected lateinit var userApi: UserApi
    protected lateinit var user: User

    @BeforeEach
    fun setUp() {
        driver = ChromeDriver()
        driver.get(Const_URL.BASE_URL_LOGIN)
        loginPage = LoginPage(driver)
        mainPage = MainPage(driver)
        userCreationAPI = UserCreationApi()
        user = userCreationAPI.createUserData()
        userApi = UserApi()
    }

    @AfterEach
    fun tearDown() {
        if (::userApi.isInitialized) {
            userApi.deleteUser(user.email, user.password)
        }
        if (::driver.isInitialized) {
            driver.quit()
        }
    }
}