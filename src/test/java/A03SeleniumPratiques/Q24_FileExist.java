package A03SeleniumPratiques;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseMethod;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Q24_FileExist extends TestBaseMethod {
//      1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
//      2. https://the-internet.herokuapp.com/download adresine gidelim.
    @Test
    public void test01() throws Exception {
        driver.get("https://the-internet.herokuapp.com/download");
//      3. captura.png dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='captura.png']")).click();
//      4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String filePath=System.getProperty("user.home")+"/Downloads/captura.png";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));

    }

}
