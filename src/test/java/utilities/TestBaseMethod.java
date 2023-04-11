package utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.time.Duration;
import java.util.List;

public class TestBaseMethod {
    protected static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() {

        //driver.quit();
    }

    public void selectFromDropdown(WebElement dropdown, String secenek) {
//        selectFromDropdown(driver.findElement(By.xpath("//select[@id='year']")), "2005"); -> year dan 2005
//        selectFromDropdown(driver.findElement(By.xpath("//select[@id='month']")), "January"); -> month January
//        selectFromDropdown(driver.findElement(By.id("day")), "12"); -> Day 12
//        Gonderilen dropdown elemention tum optionslari alinir
        List<WebElement> options = dropdown.findElements(By.tagName("option"));//Tum option tagli elementleri aliyorum
        for (WebElement eachOption : options) {
            if (eachOption.getText().equals(secenek)) {
                eachOption.click();
                break;
            }
        }
    }
}
