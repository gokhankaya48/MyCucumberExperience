package ApachePOI;

import org.apache.poi.ss.usermodel.*;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _06_WriteInTheExcel {
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/resource/LoginData.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        Workbook workBook = WorkbookFactory.create(inputStream);
        Sheet sheet = workBook.getSheetAt(0);
        int enSonSatirMiktari=sheet.getPhysicalNumberOfRows();
        Row yeniSatir=sheet.createRow(enSonSatirMiktari);//yeni satır oluşturdum
        Cell yeniHucre=yeniSatir.createCell(0);// yenisatırda yeni hücre oluşturdum
        yeniHucre.setCellValue("Merhaba Dünya");// yeni hücreye değer verdim
        //yazma işlemim bittim
        inputStream.close();// aynı anda okuma ve kaydetme yapılamıyor, okuma modu kapatıldı
        // dosyayı KAYDETME modunda aç
        FileOutputStream outputStream=new FileOutputStream(path);// kaydetme modunda açıldı
        workBook.write(outputStream);// workbook kaydedildi
        workBook.close();// hafıza boşaltıldı
        outputStream.close(); // yazma modu kapatıldı.

        System.out.println("Kayıt yapıldı");

    }

}
