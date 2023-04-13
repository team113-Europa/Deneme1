package A03SeleniumPratiques.excelAutomation;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class WriteExcel {
    @Test
    public void writeExcelTest() throws Exception {
        //1) Yeni bir Class olusturalim WriteExcel
        //2) Yeni bir test method olusturalim writeExcelTest()
        //3) Adimlari takip ederek 1.satira kadar gidelim
        String FilePath="src/test/java/resources_xlsx/ulkeler.xlsx";
        FileInputStream fis =new FileInputStream(FilePath);
        Workbook workbook= WorkbookFactory.create(fis);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");
        //4) 4.hucreye yeni bir cell olusturalim
        workbook
                .getSheet("Sayfa1")
                .getRow(0)
                .createCell(4)
        //5) Olusturdugumuz hucreye “Nufus” yazdiralim
                .setCellValue("Nufus");
        //6) 2.satir nufus kolonuna 1500000 yazdiralim
        workbook
                .getSheet("sayfa1")
                .getRow(1)
                .createCell(4)
                .setCellValue("150000");
        //7) 10.satir nufus kolonuna 250000 yazdiralim
        workbook
                .getSheet("sayfa1")
                .getRow(9)
                .createCell(4)
                .setCellValue("250000");
        //8) 15.satir nufus kolonuna 54000 yazdiralim
        workbook
                .getSheet("sayfa1")
                .getRow(14)
                .createCell(4)
                .setCellValue("54000");
        //9) Dosyayi kaydedelim
        FileOutputStream fos=new FileOutputStream(FilePath);
        workbook.write(fos);

        //10)Dosyayi kapatalim
        workbook.close();
        fis.close();
        fos.close();

    }
}
