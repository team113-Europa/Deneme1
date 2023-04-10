package A03SeleniumPratiques;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseMethod;

public class Q17_ActionsClass_MouseActions extends TestBaseMethod {
    @Test
    public void test01() throws Exception {
//        Yeni bir class olusturalim: MouseActions3
//        1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
//        2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        WebElement accoutListElement= driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        Actions action=new Actions(driver);
        action.moveToElement(accoutListElement).perform();
        Thread.sleep(3000);
//        3- “Create a list” butonuna basin
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
//        4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        WebElement acilanSayfaText=driver.findElement(By.xpath("//*[@id=\"my-lists-tab\"]/a/div"));
        String expectedText="Your Lists";
        String actualText=acilanSayfaText.getText();
        Assert.assertEquals(expectedText, actualText);
    }

}
