/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package excelread;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Eng. ZAINAB
 */
public class Excelread {

    /**
     * @param excel_path
     * @param sheet_name
     * @return
     * @throws java.io.FileNotFoundException
     */
    // method that reads every cell in excel sheet and return XSSFSheet object
    public XSSFSheet Current_Excel_sheet(String excel_path, String sheet_name) throws FileNotFoundException, IOException {

// reading excel_sheet from input Excel file
        FileInputStream inputstream = new FileInputStream(excel_path);
        // get workbook
        XSSFWorkbook worl_book = new XSSFWorkbook(inputstream);
        // getsheet from workbook
        XSSFSheet sheet = worl_book.getSheet(sheet_name);
        //read rows and columns
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            XSSFRow row = (XSSFRow) iterator.next();
            Iterator<Cell> cell_itreator = row.cellIterator();
            while (cell_itreator.hasNext()) {
                XSSFCell cell = (XSSFCell) cell_itreator.next();
                if (cell != null) {
                    switch (cell.getCellType()) {
//                        case STRING ->
//                            System.out.print(cell.getStringCellValue());
//                        case NUMERIC ->
//                            System.out.print(cell.getNumericCellValue());
//                        case BOOLEAN ->
//                            System.out.print(cell.getBooleanCellValue());

                    }

                }

            }
            //System.out.println(); 
        }
        return sheet;
    }

    //method to read specific index from excel_sheet
    public String Current_Excel_Cell(String excel_path, String sheet_name, int row_index, int col_index) throws FileNotFoundException, IOException {
        // reading excel_sheet from input Excel file
        FileInputStream inputstream = new FileInputStream(excel_path);
        // get workbook
        XSSFWorkbook worl_book = new XSSFWorkbook(inputstream);
        // getsheet from workbook
        XSSFSheet sheet = worl_book.getSheet(sheet_name);
        //read rows and columns
        Row row = sheet.getRow(row_index);
        Cell cell = row.getCell(col_index);
        String value = cell.getStringCellValue();
        return value;

    }

}
