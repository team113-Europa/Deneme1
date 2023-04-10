package A03SeleniumPratiques;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseMethod;

import java.util.Set;

public class Q13_HandleWindows extends TestBaseMethod {
    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/iframe adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");
        // elemental selenium linkini tiklayin
        // linke tikladigimizda yeni sayfa acilacagindan
        // click yapmadan once ilk sayfanin WHD'ini alip kaydedelim
        String ilkSayfaWHD = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        // click yapinca yeni tab acilir ancak driver eski tab'da kalir
        // yeni tab'a driver'i gecirmek icin yeni tab'in WHD ihtiyacimiz var
        Set<String>ikiSayfaninDegerleriSeti=driver.getWindowHandles();
        String ikinciSayfaWHD="";
        for (String eachWHD: ikiSayfaninDegerleriSeti
             ) {
            if (!eachWHD.equals(ilkSayfaWHD)){
                ikinciSayfaWHD=eachWHD;
            }
        }
        // foreach loop bittiginde ikinci sayfanin WHD'ini elde etmis olacagiz
        // bu degeri kullanarak, driver'i 2.sayfaya  gecirebiliriz
        driver.switchTo().window(ikinciSayfaWHD);
        // yeni tab'a gecip sayfadaki en buyuk yazinin "Elemental Selenium" oldugunu test edin
        String expectedYaziElementi="Elemental Selenium";
        String actualIkinciSayfaYazisi=driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedYaziElementi, actualIkinciSayfaYazisi);
        // ilk sayfaya geri donup sayfadaki yazinin
        // "An iFrame containing the TinyMCE WYSIWYG Editor" oldugunu test edin
        driver.switchTo().window(ilkSayfaWHD);
        String expectedFirstPageText="An iFrame containing the TinyMCE WYSIWYG Editor";
        String actualFirstPageText = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedFirstPageText, actualFirstPageText);


        Thread.sleep(3000);
    }
}
