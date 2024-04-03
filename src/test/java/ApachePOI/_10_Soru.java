package ApachePOI;
/*
   Main den bir metod çağırmak suretiyle, path i ve sheetName i verilen excelden
   istenilen sütun kadar veriyi okuyup bir List e atınız.
   Bu soruda kaynak Excel için : ApacheExcel2.xlsx  in 2.sheet ini kullanabilirsiniz.
 */

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _10_Soru {
    public static void main(String[] args) throws IOException {
        String filePath = "src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";
        String sheetName = "testCitizen";
        int columnCount = 6;

        List<List<String>> data = readExcel(filePath, sheetName, columnCount);

        for (List<String> row : data) {
            for (String cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }

    }
    public static List<List<String>> readExcel(String filePath, String sheetName, int columnCount) throws IOException {
        List<List<String>> data = new ArrayList<>();


        FileInputStream inputStream = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new IOException("Belirtilen sayfa bulunamadı: " + sheetName);
        }


        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            List<String> rowData = new ArrayList<>();

            for (int i = 0; i < columnCount; i++) {
                Cell cell = row.getCell(i);
                if (cell == null) {
                    rowData.add("");
                } else {

                    rowData.add(cell.toString());
                }
            }
            data.add(rowData);
        }

        workbook.close();
        inputStream.close();

        return data;
    }
}
