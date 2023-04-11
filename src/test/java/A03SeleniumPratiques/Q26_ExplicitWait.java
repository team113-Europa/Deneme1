package A03SeleniumPratiques;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseMethod;

import java.time.Duration;

public class Q26_ExplicitWait {
    @Test
    public void implicitlyWait() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
//        1. Bir class olusturun : WaitTest
//        2. Iki tane metod olusturun : implicitWait() , explicitWait()
//        Iki metod icin de asagidaki adimlari test edin.
//        3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//        4. Remove butonuna basin.
        driver.findElement(By.xpath("(//*[@type='button'])[1]")).click();
//        5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneMessage=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsGoneMessage.isDisplayed());
//        6. Add buttonuna basin
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']")).click();
//        7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackMessage=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsBackMessage.isDisplayed());
        System.out.println(itsBackMessage);

        Thread.sleep(2000);
    }
    @Test
    public void explicitlyWait(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        //        1. Bir class olusturun : WaitTest
//        2. Iki tane metod olusturun : implicitWait() , explicitWait()
//        Iki metod icin de asagidaki adimlari test edin.
//        3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//        4. Remove butonuna basin.
        driver.findElement(By.xpath("(//*[@type='button'])[1]")).click();
//        5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement itsGoneMessage=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsGoneMessage.isDisplayed());

//        6. Add buttonuna basin
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']")).click();
//        7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackMessage=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsBackMessage.isDisplayed());

    }
}
