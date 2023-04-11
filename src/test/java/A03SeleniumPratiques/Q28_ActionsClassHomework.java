package A03SeleniumPratiques;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods2;
import utilities.TestBaseMethod;

public class Q28_ActionsClassHomework extends TestBaseMethod {
    @Test
    public void test01() {
//        1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
//        2. "Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement hoverBoxElementi=driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));
        actions.moveToElement(hoverBoxElementi).perform();
        ReusableMethods2.bekle(2);
//        3. "Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[@class='list-alert'])[1]")).click();
//        4. Popup mesajini yazdirin
        String popUpText=driver.switchTo().alert().getText();
        System.out.println(popUpText);
//        5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
//        6. "Click and hold" kutusuna basili tutun
        actions.clickAndHold(driver.findElement(By.xpath("//*[@id=\"click-box\"]")));
//        7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.xpath("//*[@id=\"click-box\"]")).getText());
//        8. "Double click me" butonunu cift tiklayin
        actions.doubleClick(driver.findElement(By.xpath("//div[@class='div-double-click']"))).perform();


    }
}
