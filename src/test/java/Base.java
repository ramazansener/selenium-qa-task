
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Base {

    protected static WebDriver driver;
    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }



    @BeforeClass
    public static void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium files\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.get("https://www.lcwaikiki.com/tr-TR/TR");
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void quit() {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.quit();
    }
}