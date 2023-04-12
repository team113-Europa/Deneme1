package A03SeleniumPratiques;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods2;
import utilities.TestBaseMethod;

import java.util.List;

public class Q32_WebTables extends TestBaseMethod {
    @Test
    public void test01() {
        //1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");
        //2.Sayfanin en altina inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        //3.Web table tum body’sini yazdirin

        WebElement fullBody=driver.findElement(By.xpath("//table[@class='navFooterMoreOnAmazon']"));
        System.out.println(fullBody.getText());
        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement> numOfLines=driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertEquals(10, numOfLines.size());

        //5.Tum satirlari yazdirin
        int count=1;
        for (WebElement eachLines:numOfLines
             ) {
            System.out.println(count+" - "+eachLines);
            count++;

        }
        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> numOfColumns =driver.findElements(By.xpath("//tbody/tr[3]/td"));
        //Assert.assertEquals(13, numOfColumns );
        System.out.println(numOfColumns.size());
        int expectedColumns=13;
        int actualColumns=numOfColumns.size();
        Assert.assertEquals(expectedColumns,actualColumns);
        System.out.println("Expected Columns number = " +expectedColumns + " Actual Columns number = " +actualColumns);
        //7. 5.sutunu yazdirin
        List<WebElement> fifthColumn=driver.findElements(By.xpath("//tbody/tr/td[5]"));
        System.out.println("<<<<5.column>>>>");
        count=1;
        for (WebElement eachColumn2:fifthColumn
             ) {
            System.out.println(count+" - "+eachColumn2.getText());
            count++;

        }
        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
        System.out.println("<<<<<<<NEW TEST>>>>>>>");
        WebElement elementOfWanted=getElement(5,7);
        System.out.println(elementOfWanted.getText());//burda 3. satir 5. sutunu yazdiralim bakalim
        //getElement kirmizi cikip sag tiklayip metot olustur dedigimizde asagida metodu create yapar
        //8- tum cookie’leri silin ve silindigini test edin
        ReusableMethods2.bekle(4);

    }

    private WebElement getElement(int line, int column) {
        //String xpath="//tbody/tr[3]/td[5]";//burada 3 ve 5 i dinamik yapmak lazim BUNUN ICIN
        //3 ve 5 i ana metinden ayiriyoruz
        String dinamikXpath="//tbody/tr["+ line+"]/td["+ column+"]";

        WebElement elementWanted=driver.findElement(By.xpath(dinamikXpath));
        return elementWanted;

    }

}
/*
RESULT
<<<<<<<NEW TEST>>>>>>>
Goodreads
Book reviews
& recommendations
 */