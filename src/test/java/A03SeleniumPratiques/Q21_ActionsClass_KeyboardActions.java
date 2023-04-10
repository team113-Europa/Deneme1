package A03SeleniumPratiques;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.ReusableMethods2;
import utilities.TestBaseMethod;

public class Q21_ActionsClass_KeyboardActions extends TestBaseMethod {
    @Test
    public void test01() {
//        1.	"http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.navigate().to("http://webdriveruniversity.com/Actions");
//        2.	Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement hoverOverElement=driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        actions.moveToElement(hoverOverElement).perform();
        ReusableMethods2.bekle(2);
//        3.	Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();
        ReusableMethods2.bekle(2);
//        4.	Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
//        5.	Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        ReusableMethods2.bekle(2);
//        6.	“Click and hold" kutusuna basili tutun
        WebElement clickAndHoldElement=driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(clickAndHoldElement).perform();
        ReusableMethods2.bekle(2);
//        7.	“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHoldElement.getText());
//        8.	“Double click me" butonunu cift tiklayin
        WebElement doubleClickElement=driver.findElement(By.xpath("//div[@id='double-click']"));
        actions.doubleClick(doubleClickElement).perform();
        ReusableMethods2.bekle(2);


    }
}
