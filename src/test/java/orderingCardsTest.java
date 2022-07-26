import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import static org.junit.jupiter.api.Assertions.assertEquals;
class orderingCardsTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "/home/anna/Automator/OrderingCards/driver/linux/chromedriver");
    }

    @BeforeEach
    void setUp() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--headless");
        driver = new ChromeDriver();
    }
    
    @Test
    void test2() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("span[data-test-id='name'] input")).sendKeys("Пантелеймон Пантелеймонов");
        driver.findElement(By.cssSelector("span[data-test-id='phone'] input")).sendKeys("+79012345678");
        driver.findElement(By.cssSelector("span[class='checkbox__box']")).click();
        driver.findElement(By.cssSelector("button[role='button']")).click();
        String text = driver.findElement(By.cssSelector("p[data-test-id='order-success'] ")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }
}
