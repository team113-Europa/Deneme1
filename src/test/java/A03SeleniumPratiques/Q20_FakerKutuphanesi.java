package A03SeleniumPratiques;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseMethod;

public class Q20_FakerKutuphanesi extends TestBaseMethod {
    @Test
    public void test01() throws Exception {
//        1.	"https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");
        driver.findElement(By.xpath("//button[@title='Allow essential and optional cookies']")).click();
//        2.	“create new account” butonuna basin
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
//        3.	“firstName” giris kutusuna bir isim yazin
        WebElement firstName=driver.findElement(By.xpath("//input[@name='firstname']"));
        //******Burada faker islemini baslatiyoruz******
        Faker faker = new Faker();
        String fakeEmail=faker.internet().emailAddress();
        String fakePassword=faker.internet().password();
        Actions actions=new Actions(driver);
        actions.click(firstName)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakePassword)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Apr")
                .sendKeys(Keys.TAB)
                .sendKeys("1")
                .sendKeys(Keys.TAB)
                .sendKeys("1986")
                .sendKeys(Keys.TAB)

                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        WebElement female = driver.findElement(By.xpath("//input[@value='1']"));
        Assert.assertFalse(female.isSelected());

        WebElement male = driver.findElement(By.xpath("//input[@value='2']"));
        Assert.assertTrue(male.isSelected());

        System.out.println("Female radio button selected: " + female.isSelected());
        System.out.println("Male radio button selected: " + male.isSelected());

//        4.	“surname” giris kutusuna bir soyisim yazin
//        5.	“email” giris kutusuna bir email yazin
//        6.	“email” onay kutusuna emaili tekrar yazin
//        7.	Bir sifre girin
//        8.	Tarih icin gun secin
//        9.	Tarih icin ay secin
//        10.	Tarih icin yil secin
//        11.	Cinsiyeti secin
//        12.	Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
//        13.	Sayfayi kapatin


    }
}
