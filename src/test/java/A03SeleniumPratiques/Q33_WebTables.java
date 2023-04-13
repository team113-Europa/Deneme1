package A03SeleniumPratiques;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.TestBaseMethod;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.remote.http.FormEncodedData.getData;

public class Q33_WebTables extends TestBaseMethod {
    @Test
    public void test01() throws InterruptedException {
        //Bir Class olusturun D19_WebtablesHomework
        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //2. Headers da bulunan basliklari yazdirin
        List<WebElement> headerElementsList = driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
        for (WebElement eachElement:headerElementsList
             ) {
            System.out.println(eachElement.getText());
        }
        //3. 3.sutunun basligini yazdirin
        System.out.println("3.Column Title : " +headerElementsList.get(2).getText());
        //4. Tablodaki tum datalari yazdirin
        System.out.println("<<<<<<<<<ALL ELEMENTS LIST>>>>>>>>>>>");
        List<WebElement>allElementsList = driver.findElements(By.xpath("//div[@class='rt-td']"));
        for (WebElement eachElement: allElementsList) {
            if (!eachElement.getText().isBlank()){
                System.out.println(eachElement.getText());
            }
        }
        //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        System.out.println("<<<<<<<<<ALL ELEMENTS LIST>>>>>>>>>>>");
        List<WebElement> tableCells = driver.findElements(By.xpath("//div[@class='rt-td']"));
        System.out.println("Tablodaki toplam cell sayisi : " + tableCells.size());
        List<String> tableDataList = new ArrayList<>();
        for (int i = 0; i < tableCells.size(); i++) {
            if (!tableCells.get(i).getText().isBlank()) {
                tableDataList.add(tableCells.get(i).getText());
            }
        }
        System.out.println("Tabloda icinde veri bulunan cell sayisi : " + tableDataList.size());
        //6. Tablodaki satir sayisini yazdirin
        System.out.println("<<<<<<<<<ALL ELEMENTS LIST>>>>>>>>>>>");
        List<WebElement>rowList=driver.findElements(By.xpath("//div[@role='row']"));
        System.out.println("The number of row in the table "+rowList.size());
        //7. Tablodaki sutun sayisini yazdirin
        System.out.println("<<<<<<<<<ALL ELEMENTS LIST>>>>>>>>>>>");
        List<WebElement>columnList=driver.findElements(By.xpath("//div[@role=\"columnheader\"]"));
        System.out.println("The number of column in the table "+columnList.size());
        //8. Tablodaki 3.kolonu yazdirin
        System.out.println("<<<<<<<<<ALL ELEMENTS LIST>>>>>>>>>>>");
        List<WebElement>thirdColumnPrint=driver.findElements(By.xpath("//div//div[@class='rt-td'][3]"));
        int columnCount=1;
        for (WebElement eachElement3:thirdColumnPrint
             ) {
            System.out.println("The third column : " + columnCount + " - " +eachElement3.getText());
            columnCount++;

        }
        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        System.out.println("<<<<<<<<<ALL ELEMENTS LIST>>>>>>>>>>>");
        for (int i = 0; i < allElementsList.size(); i++) {
            if (allElementsList.get(i).getText().equals("Kierra")) {
                System.out.println("The salary of the Kierra " + allElementsList.get(i+4).getText());
        }
            
        }
        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
        System.out.println("<<<<<<<<<ALL ELEMENTS LIST>>>>>>>>>>>");
        getData(2,3);


        }

    private void getData(int row, int column) {
        WebElement data= driver.findElement(By.xpath("(//div[@class='rt-td'][" + column + "])[" + row + "]"));
        System.out.println(column + "- column " + row + " - data of the row : " + data.getText());
    }
}

