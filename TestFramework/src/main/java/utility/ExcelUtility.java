package utility;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtility {
    /**To retrive data from an Excel File
     *
     * @param filePath - Absolute file Path
     * @param sheetName - Sheet Name as in the Workbook
     * @return Table Data as String[][] or null
     */
    public static String[][] readExcelToArray(String filePath, String sheetName){
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("File does not exist");
                return null;
            }

            FileInputStream fileInputStream = new FileInputStream(file);
            Workbook workbook = WorkbookFactory.create(fileInputStream);

            Sheet details = workbook.getSheet(sheetName);
            DataFormatter formatter=new DataFormatter();
            int lastRowNum = details.getLastRowNum();
            int lastCellNum = details.getRow(0).getLastCellNum();
            String[][] table=new String[lastRowNum+1][lastCellNum];
            for (int i = 0; i <= lastRowNum; i++) {
                Row row = details.getRow(i);
                for (int j = 0; j < lastCellNum; j++) {
                    Cell cell = row.getCell(j);
                    String cellValue = formatter.formatCellValue(cell).trim();
                    table[i][j]=cellValue;
                    System.out.print(cellValue+"\t");
                }
                System.out.println("\n==================================");
            }
            return table;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
