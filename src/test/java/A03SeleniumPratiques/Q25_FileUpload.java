package A03SeleniumPratiques;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods2;
import utilities.TestBaseMethod;

public class Q25_FileUpload extends TestBaseMethod {
    @Test
    public void test01() throws Exception {
//      1. Tests packagenin altina bir class oluşturun : C05_UploadFile
//      2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
//      3. chooseFile butonuna basalim
        /*
        Bu gorevi yapabilmek icin chooseFile butonuna basildiginda acilan
        bilgisayarimizdaki file dosyalarini clik edebilmemeiz gerekir.
        Ancak selenium WebDriver oldugundan PC uzerinde click islemi
        yapamaz.
        Bunun yerine:
        1. chooseFile butonunu locate ederiz
        2. upload edilecek dosyanin dosya yolunu olusturun
        3. chooseFile butonuna sendKeys ile dosya younu gonderin
         */
        //4. Yuklemek istediginiz dosyayi secelim.
        WebElement chooseFileButton= driver.findElement(By.xpath("//*[@id='file-upload']"));
        String filePath=System.getProperty("user.home")+"\\OneDrive\\Bureau\\MerhabaJava.txt";
        chooseFileButton.sendKeys(filePath);

//

//      5. Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();
//      6. “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploaded=driver.findElement(By.xpath("//*[text()='File Uploaded!']"));
        Assert.assertTrue(fileUploaded.isDisplayed());
        ReusableMethods2.bekle(2);
}
}
