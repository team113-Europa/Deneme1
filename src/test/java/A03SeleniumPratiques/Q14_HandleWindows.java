package A03SeleniumPratiques;

import org.junit.Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.TestBaseMethod;

import java.util.Set;

public class Q14_HandleWindows extends TestBaseMethod {
    @Test
    public void test01() throws Exception {
// https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
// Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedText="Opening a new window";
        String actualText=driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(expectedText, actualText);
// Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle="The Internet";
        String actualTitle=driver.getTitle();
        String ilkSayfaWHD=driver.getWindowHandle();

        Assert.assertEquals(expectedTitle,actualTitle);
// Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        Thread.sleep(3000);
        /*
               Kontrolsuz acilan tab'a gecis yapmak icin
               1- ilk sayfada iken o sayfanin WHD alip kaydedin
               2- 2.sayfa acildiktan sonra getWindowhandles() kullanarak
                  acik olan tum sayfalarin WH degerlerini bir Set olarak kaydedin
               3- su anda elimizde 2 elementli bir Set var,
                  elementlerden bir tanesi 1.sayfanin WHD
                  1.sayfanin WHD'ine esit olmayan ise 2.sayfanin WHD olur
               4- bu sekilde 2.sayfanin WHD elde edildikten sonra
                  WHD'leri kullanilarak sayfalar arasinda gecis yapilabilir
         */
// Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Set<String> tumSayfalarWHD=driver.getWindowHandles();
        String ikinciSayfaWHD="";
        for (String eachWHD: tumSayfalarWHD
             ) {
            if (!eachWHD.equals(ilkSayfaWHD)){
                ikinciSayfaWHD=eachWHD;
            }
        }

// Sayfadaki textin “New Window” olduğunu doğrulayın.
        driver.switchTo().window(ikinciSayfaWHD);
        String actualnewWindowText=driver.findElement(By.tagName("h3")).getText();
        System.out.println(actualnewWindowText);
        String expectednewWindowText="New Window";
        Assert.assertEquals(actualnewWindowText, expectednewWindowText);
// Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWHD);
        expectedTitle="The Internet";
        actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        Thread.sleep(2500);
    }
}
