package excelread;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Eng. ZAINAB
 */
public  class Excelread {
    private static ArrayList<Integer> indexArray = new ArrayList<Integer>();
    private static ArrayList<String> apiName = new ArrayList<String>();
    private static String excelPath;

    public Excelread(String excelFile) {
        excelPath = Paths.get("")
                .toAbsolutePath()
                .toString()+"\\"+excelFile;
    }

    /**
     * @param sheet_name
     * @return
     * @throws java.io.FileNotFoundException
     */
    // method that reads every cell in excel sheet and return XSSFSheet object
    public static XSSFSheet Current_Excel_sheet(String sheet_name) throws FileNotFoundException, IOException {
        // reading excel_sheet from input Excel file
        FileInputStream inputstream = new FileInputStream(excelPath);
        // get workbook
        XSSFWorkbook worl_book = new XSSFWorkbook(inputstream);
        // getsheet from workbook
        XSSFSheet sheet = worl_book.getSheet(sheet_name);
       return sheet;
    }

    //method to read specific index from excel_sheet
    public static String Current_Excel_Cell(String sheet_name, int row_index, int col_index) throws FileNotFoundException, IOException {
        // getsheet from workbook
        XSSFSheet sheet = Current_Excel_sheet(sheet_name);
        //read rows and columns
        Row row = sheet.getRow(row_index);
        Cell cell = row.getCell(col_index);
        String value = cell.getStringCellValue();
        return value;

    }

    public ArrayList<Integer> getApiIndexes(XSSFSheet sheet) throws FileNotFoundException, IOException {
        int Current_API_index;
        //read rows and columns
        // for total number of rows:
        int rows = sheet.getLastRowNum();
        //  System.out.println(rows);
        for (int r = 0; r < rows; r++) {

            XSSFRow row = sheet.getRow(r);
            if (row != null) {
                Cell cell = CellUtil.getCell(row, 0);
                // System.out.println(cell);
                if (cell == null) {
                    continue;
                } else {
                    String name = cell.getStringCellValue();

                    if (name.contains("REST Operation Mapping")) {

                        name = name.substring(name.indexOf("(") + 1);
                        name = name.substring(0, name.indexOf(")"));
                        apiName.add(name);
                        indexArray.add(Integer.valueOf(cell.getRowIndex()));
                    }
                }
            }
        }
        return indexArray;
    }


    // method to save choosen column  in array for same api
    public ArrayList array_values_ofcloumn(int index_api, XSSFSheet sheet, int column, String title)  {
        ArrayList value_array = new ArrayList<String>();

        // for total number of rows of the given api:index_array.size()-1
        int rows;
        if (index_api < 2) {
            rows = (int) indexArray.get(index_api + 1) - 1;
        } else {
            rows = sheet.getLastRowNum();
        }
        for (int r = (int) indexArray.get(index_api); r <= rows; r++) {
            XSSFRow row = sheet.getRow(r);
            if (row != null) {
                Cell cell = CellUtil.getCell(row, column);

                if (cell != null) {
                    String Cell_name = cell.getStringCellValue();
                    value_array.add(Cell_name);

                }
            }
        }

        int index_title = value_array.indexOf(title);

        value_array.subList(0, index_title + 1).clear();
        return value_array;
    }

    // method to get I/o  values of specific api in array
    public ArrayList get_IO(int api_number) throws IOException {
        XSSFSheet sheet = Current_Excel_sheet("Test");
        ArrayList my_list1 = array_values_ofcloumn((int) (api_number - 1), sheet, 0, "I/o");
        return my_list1;
    }

    // method to get fieldname  values of specific api in array
    public ArrayList get_field_name(int api_number) throws IOException {
        XSSFSheet sheet = Current_Excel_sheet("Test");
        ArrayList my_list2 = array_values_ofcloumn((int) (api_number - 1), sheet, 1, "Field Name");
        return my_list2;
    }

    public ArrayList get_Type(int api_number) throws IOException {
        XSSFSheet sheet = Current_Excel_sheet( "Test");
        ArrayList my_list3 = array_values_ofcloumn((int) (api_number - 1), sheet, 2, "Type");
        return my_list3;
    }

    public ArrayList get_Alowed_values(int api_number) throws IOException {
        XSSFSheet sheet = Current_Excel_sheet("Test");
        ArrayList my_list4 = array_values_ofcloumn((int) (api_number - 1), sheet, 3, "Allowed Values");
        return my_list4;
    }

    public ArrayList get_Mandatory(int api_number) throws IOException {
        XSSFSheet sheet = Current_Excel_sheet("Test");
        ArrayList my_list5 = array_values_ofcloumn((int) (api_number - 1), sheet, 4, "Mandatory");
        return my_list5;
    }

    public String getApiName(int index) {
        return apiName.get(index - 1);
    }
    public int getIndexFromName(String name){
        return apiName.indexOf(name);
    }

}


