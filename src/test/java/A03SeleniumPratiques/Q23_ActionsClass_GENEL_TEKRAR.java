package A03SeleniumPratiques;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods2;
import utilities.TestBaseMethod;

import java.util.List;

public class Q23_ActionsClass_GENEL_TEKRAR extends TestBaseMethod {
    @Test
    public void test01() {
//    Test01 :
//            1- amazon gidin
        driver.navigate().to("https://www.amazon.com");
//2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        /*
        Eger bir sitede birden fazla linki iceren bir dropDownMenu varsa
        bu menuleri listeleyip yazdirmak icin List metodu kullanilir.
        List metodunda yapilan atrribute islemi foreach loop ile dondurulur
        ve foreach loop altinda print islemi yapilir.
         */
        List<WebElement> list = select.getOptions();
        for (WebElement each : list
        ) {
            System.out.println("DropdownMenu = " + each.getText());
        }
//3- dropdown menude 40 eleman olduğunu doğrulayın

        int numerOfElement = list.size();
        System.out.println("Size of the element = " + numerOfElement);
        Assert.assertEquals(28, numerOfElement);

    }

        @Test
        public void test02(){
//            Test02
            driver.get("https://www.amazon.com");
//1- dropdown menuden elektronik bölümü seçin
            WebElement dropdownMenu=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
            dropdownMenu.sendKeys("Electronics");
//2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
            String aramaSonucu = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText();
            System.out.println("iphone arama sonucu -> " + aramaSonucu);
//3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
            Assert.assertTrue(aramaSonucu.contains("iphone"));
//4- ikinci ürüne relative locater kullanarak tıklayin
            WebElement firstProduct=driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
            WebElement secondProduct=driver.findElement(RelativeLocator.with(By.xpath("//img[@data-image-index='2']")).toRightOf(firstProduct));
            secondProduct.click();
//5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
            String prixSecondProduct=driver.findElement(By.xpath("//*[@id=\"corePrice_desktop\"]/div/table/tbody/tr/td[2]")).getText();
            System.out.println(prixSecondProduct);
            String titleSecondProduct=driver.findElement(By.xpath("//span[@class='a-size-large product-title-word-break']")).getText();
            System.out.println(titleSecondProduct);
        }
        @Test
        public void test03(){
//    Test03
//1- yeni bir sekme açarak amazon anasayfaya gidin
            driver.get("https://www.amazon.com");
//2-dropdown’dan bebek bölümüne secin
            WebElement dropdownMenu=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
            dropdownMenu.sendKeys("Baby");
//3-bebek puset aratıp bulundan sonuç sayısını yazdırın
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bebek puset", Keys.ENTER);
            String aramaSonucu = driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']")).getText();
            System.out.println("bebek puset -> " + aramaSonucu);
//4-sonuç yazsının puset içerdiğini test edin
            Assert.assertTrue(aramaSonucu.contains("bebek puset"));
//5-üçüncü ürüne relative locater kullanarak tıklayin
            driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[3]")).click();
//6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
              String title2=driver.findElement(By.xpath("//*[@id='titleSection']")).getText();
//            String fiyat=driver.findElement(By.xpath("//*[@class='a-section a-spacing-none aok-align-center']")).getText();
//            System.out.println("puset fiyati= = " + fiyat);
//            System.out.println("title = " + title2);
//            ReusableMethods2.bekle(2);
//            driver.findElement(By.xpath("//*[@id='submit.add-to-cart']")).click();
//    Test 04
//  1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
        }






}
