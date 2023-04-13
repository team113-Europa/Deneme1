package A03SeleniumPratiques;

import junit.framework.TestCase;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods2;
import utilities.TestBaseMethod;

import java.io.File;
import java.io.IOException;

public class Q37_GetScreenShot extends TestBaseMethod {
    @Test
    public void test01() throws IOException {
       //Yeni bir class olusturun : amazonNutellaSearch
       //1- amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin

        Assert.assertTrue(driver.getTitle().contains("Amazon.com"));
        //Takescreenshot objesi olustur
        TakesScreenshot tss=(TakesScreenshot) driver;
        //kayit dosyasi olustur
        File tumSayfaScreenShot=new File("target/ekranResimleri/tumEkranSS.jpeg");
        //takescreenShot objesi kullanip gecici dosyaya kayit
        File geciciDosya=tss.getScreenshotAs(OutputType.FILE);
        //gecici dosyayi ana dosyaya kayit
        FileUtils.copyFile(geciciDosya, tumSayfaScreenShot);
        ReusableMethods2.bekle(3);
       //3- Nutella icin arama yapin
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella", Keys.ENTER);
       //4- sonucun Nutella icerdigini test edin ve ilk urunun goruntusunu alin
        WebElement result= driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']"));
        Assert.assertTrue(result.getText().contains("Nutella"));

        WebElement firstElement=driver.findElement(By.xpath("//*[@data-image-index='1']"));
        File firstProductImage=new File("target/nutella/element.jpeg");
        File firstProductImageTemp=firstElement.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(firstProductImageTemp,firstProductImage);
        ReusableMethods2.bekle(3);




    }
    @Test
    public void test02() throws IOException {
        //5- Support Ecran icin arama yapin ve aranan urunun "POUT Eyes" basligi tasidigini  test edin
        driver.get("https://www.amazon.com");
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Support Ecran", Keys.ENTER);
        driver.findElement(By.xpath("//*[@data-image-index='6']")).click();

        WebElement produit2=driver.findElement(By.xpath("(//*[@id='productTitle'])[1]"));
        String expectedTitle="POUT Eyes";
        String actualTitle=produit2.getText();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //6- ilk urunun goruntusunu alin
        WebElement produit2Image=driver.findElement(By.xpath("//*[@id=\"landingImage\"]"));
        File image=new File("target/supportEcran/element2.jpeg");
        File imageTemp=produit2Image.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(imageTemp,image);
        ReusableMethods2.bekle(3);

    }

}
