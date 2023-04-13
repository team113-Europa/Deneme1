package A03SeleniumPratiques.excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;

public class ReadExcel {
//1. apache poi dependency’i pom file’a ekleyelim
//2. Java klasoru altinda resources klasoru olusturalim
//3. Excel dosyamizi resources klasorune ekleyelim
//4. excelAutomation isminde bir package olusturalim
//5. ReadExcel isminde bir class olusturalim
//6. readExcel( ) method olusturalim
    @Test
    public void readExcel() throws Exception {
//7. Dosya yolunu bir String degiskene atayalim
        String filePath="src/test/java/resources_xlsx/ulkeler.xlsx";
//8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(filePath);
//9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fis);
//10. WorkbookFactory.create(fileInputStream)
//11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet=workbook.getSheet("Sayfa1");
//12. Row objesi olusturun sheet.getRow(index)
        Row row=sheet.getRow(3);
//13. Cell objesi olusturun row.getCell(index)
        Cell cell=row.getCell(3);
        //3.index'deki satirin 3.index'indeki datanin Cezayir oldugunu test edin
        String expectedResult="Cezayir";
        String actualResult=cell.toString();
        Assert.assertEquals(expectedResult, actualResult);
        Assert.assertEquals(expectedResult,cell.getStringCellValue());
        if (expectedResult.equals(actualResult)){
            System.out.println("Test PASSED");
        }
        else{
            System.out.println("Test FAILED");
        }

    }

}
