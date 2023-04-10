package A03SeleniumPratiques;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseMethod;

public class Q16_ActionsClass_MouseActions extends TestBaseMethod {
//    Yeni bir class olusturalim: MouseActions2

    @Test
    public void test01() throws Exception {
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions action=new Actions(driver);

        WebElement dragMeKutusu=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHereKutusu=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        action.dragAndDrop(dragMeKutusu,dropHereKutusu).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//div[@id='droppable']"));
        String expectedYazi="Dropped!";
        String actualYazi=sonucYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);
    }


}
