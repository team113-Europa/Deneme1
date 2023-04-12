package A03SeleniumPratiques;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBaseMethod;

import java.util.Set;

import static org.junit.Assert.*;

public class Q31_Cookies extends TestBaseMethod {
    @Test
    public void test01() {
        //Yeni bir class olusturun : cookiesAutomation
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        int count=1;
        Set<Cookie> cookiesSet=driver.manage().getCookies();
        for (Cookie eachCookie:cookiesSet
             ) {
            System.out.println(count + " " + eachCookie.toString());
            count++;
        }

        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int allCookiesCount=cookiesSet.size();
        if (allCookiesCount>5) {
            System.out.println("<<<<Test PASSED>>>>");
        }
        else {
            System.out.println("!!!!Test FAILED!!!!");
        }
        System.out.println("allCookiesCount = "+allCookiesCount);
        assertTrue(cookiesSet.size()>5);
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String expectedCookieValue="USD";
        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        if (expectedCookieValue.equals(actualCookieValue)){
            System.out.println("<<<<Test PASSED>>>>");
        }
        else {
            System.out.println("!!!!Test FAILED!!!!");
        }
        assertEquals(expectedCookieValue, actualCookieValue);
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        //olusturun ve sayfaya ekleyin
        Cookie newCookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(newCookie);
        System.out.println(driver.manage().getCookies().size());
        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        String newCookieValues=driver.manage().getCookieNamed("en sevdigim cookie").getValue();
        assertEquals("cikolatali",newCookieValues);
        System.out.println("9. cookie = "+ newCookie.getName()+" , "+newCookie.getValue());
        int compte=1;
        Set<Cookie> cookiesSet2=driver.manage().getCookies();
        for (Cookie eachCookie:cookiesSet2
        ) {
            System.out.println(compte + " " + eachCookie.toString());
            compte++;
        }

        //7- ismi skin olan cookie’yi silin ve silindigini test edin
      driver.manage().deleteCookieNamed("skin");
      assertNull(driver.manage().getCookieNamed("skin"));
      System.out.println(driver.manage().getCookies().size());
      int sayac=1;
      Set<Cookie> cookiesSet3=driver.manage().getCookies();
      for (Cookie eachCookie:cookiesSet3
      ) {
          System.out.println(sayac + " " + eachCookie.toString());
          sayac++;
      }
        //8- tum cookie'leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        assertEquals(0, driver.manage().getCookies().size());
        System.out.println("<<<<<<<<>>>>>>>>>>");
        System.out.println("At the end of the test there is 0 cookie: "+ driver.manage().getCookies().size());


    }
}
