package A03SeleniumPratiques.excelAutomation;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ReadExcel02 {
    @Test
    public void testReadExcel02() throws IOException {
        //Yeni bir test method olusturalim readExcel2( )
        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        //Once dosya yolunu bulalim
        String filePath = "src/test/java/resources_xlsx/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sayfa1").getRow(1).getCell(2));
        //- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String row1Cell2 = String.valueOf(workbook
                .getSheet("Sayfa1")
                .getRow(1)
                .getCell(2));
        System.out.println(row1Cell2);
        //- 1.satir 3.cell’in afganistan’in baskenti oldugunu test edelim
        System.out.println("<<<<KABIL>>>>");
        String expectedResult = "Kabil";
        String actualResult = String.valueOf(workbook
                .getSheet("Sayfa1")
                .getRow(1)
                .getCell(3));
        Assert.assertEquals(expectedResult, actualResult);
        if (expectedResult.equals(actualResult)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }
        //- Satir sayisini bulalim
        // getLastRowNum() bu metot ile son satirin indexini alabiliriz
        // Ancak en sona +1 koymaliyiz, indexler 0 dan basliyordu
        System.out.println("<<<<ROW NUMBER>>>>");
        System.out.println("Total row Number = " + (workbook.getSheet("Sayfa1").getLastRowNum() + 1));
        //- Fiziki olarak kullanilan satir sayisini bulun
        System.out.println("<<<<ROW PHYSICAL>>>>");
        System.out.println("Total row Number = " + (workbook.getSheet("Sayfa1").getPhysicalNumberOfRows() + 1));
        //- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        // "Sayfa1" adlı bir Excel sayfasındaki her bir satırdaki ülke ve
        // başkent bilgilerini okuyarak bir Map veri yapısına kaydediyoruz.
        System.out.println("<<<<MAP SAVE>>>>");
        Map<String, String> ulkelerMap = new TreeMap<>();
        // Excel sayfasındaki son satırın indeksini alıyoruz.
        int sonSatirIndexi = workbook.getSheet("Sayfa1").getLastRowNum();
        // Döngü kullanarak, her satırdaki ülke ve başkent bilgilerini okuyarak TreeMap veri yapısına ekliyoruz.
        for (int i = 1; i <= sonSatirIndexi; i++) { //eger basligi gormek istemiyorsaniz 1 den yoksa 0 dan baslatin
            String ulke = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String baskent = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            ulkelerMap.put(ulke, baskent);
        }
        System.out.println("<<<<MAP PRINT LAST ETAPE>>>>");
        // TreeMap veri yapısını ekrana yazdırıyoruz.
        System.out.println(ulkelerMap);
        // Set nesnesine dönüştürüyoruz ve her bir Map.Entry nesnesini döngü kullanarak ekrana yazdırıyoruz.
        Set<Map.Entry<String, String>> ulkelerEntrySet = ulkelerMap.entrySet();
        for (Map.Entry<String, String> eachEntry : ulkelerEntrySet) {
            System.out.println(eachEntry);
        }
    }
}

