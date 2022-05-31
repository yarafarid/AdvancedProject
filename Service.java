/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excelread;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 *
 * @author Eng. ZAINAB
 */
public class Service extends Excelread {
      
     private  static ArrayList index_array = new ArrayList<Integer>(); 
     private   ArrayList value_array = new ArrayList<String>(); 
     
    // private static   ArrayList name_array = new ArrayList<String>(); 
    // private static   ArrayList type_array = new ArrayList<String>(); 
    // private static   ArrayList mandatory_array = new ArrayList<String>(); 
    // private static   ArrayList mandatory_array = new ArrayList<String>(); 
    public  ArrayList Api_Name(XSSFSheet sheet) throws FileNotFoundException, IOException{
      int Current_API_index;
        //read rows and columns
       // for total number of rows:
           int rows =sheet.getLastRowNum();
         //  System.out.println(rows);
         for(int r=0;r<rows;r++){
             
          XSSFRow row =sheet.getRow(r);
          if(row!=null){
          Cell cell = CellUtil.getCell(row, 0);
          // System.out.println(cell);
           if ( cell == null){
           } else {
               String Cell_name =cell.getStringCellValue();
              
               if (Cell_name.contains("REST Operation Mapping")){
                 
                   Current_API_index= cell.getRowIndex();
                   index_array.add(Current_API_index);
               }
          }
         }
         }return index_array;
    }
    // method to save choosen column  in array for same api 
     public  ArrayList array_values_ofcloumn(int index_api,XSSFSheet sheet, int column,String title) throws FileNotFoundException, IOException{
       String value_of_cell;
         value_array.clear();
     int except =index_array.size()-1;
             
       // for total number of rows of the given api:index_array.size()-1
       if(index_api<2){
          int rows = (int)index_array.get(index_api+1);
       
           
         for(int r = (int)index_array.get(index_api);r<rows;r++){
         XSSFRow row =sheet.getRow(r);
          if(row!=null){
          Cell cell = CellUtil.getCell(row, column);
           
           if ( cell == null){ String Cell_name ="all values are allowed";
           } else {
               String Cell_name =cell.getStringCellValue();
               value_array.add(Cell_name);
               
          }
           
           
         }
         }
       }
       else{   int rows = sheet.getLastRowNum();
        for(int r = (int)index_array.get(index_api);r<rows;r++){
         XSSFRow row =sheet.getRow(r);
          if(row!=null){
          Cell cell = CellUtil.getCell(row, column);
           
           if ( cell == null){ String Cell_name ="all values are allowed";
           } else {
               String Cell_name =cell.getStringCellValue();
               value_array.add(Cell_name);
               
          }
           
           
         }
         }
       
       
       }
       
       int index_title=value_array.indexOf(title);
           
              value_array.subList(0,index_title+1).clear();
         return value_array;
     }
     
     
     // method to get I/o  values of specific api in array
     public  ArrayList get_IO(int api_number ) throws IOException{
        value_array.clear();
        
         
         String excel_path="C:\\Users\\Eng. ZAINAB\\OneDrive\\Documents\\java\\Project\\data\\Example.xlsx";
         Service service =new Service();
         XSSFSheet sheet  =  service.Current_Excel_sheet(excel_path, "Test");
          ArrayList my_index_array =  service.Api_Name(sheet);
          ArrayList my_list1=service.array_values_ofcloumn((int) (api_number-1),sheet,0,"I/o");
         return my_list1;
     }
     // method to get fieldname  values of specific api in array
     public  ArrayList get_field_name(int api_number ) throws IOException{
        value_array.clear();
         
         String excel_path="C:\\Users\\Eng. ZAINAB\\OneDrive\\Documents\\java\\Project\\data\\Example.xlsx";
         Service service =new Service();
         XSSFSheet sheet  =  service.Current_Excel_sheet(excel_path, "Test");
          ArrayList my_index_array =  service.Api_Name(sheet);
          ArrayList my_list2=service.array_values_ofcloumn((int)(api_number-1),sheet,1,"Field Name");
         return my_list2;
     }
     public  ArrayList get_Type(int api_number ) throws IOException{
         value_array.clear();
        
         String excel_path="C:\\Users\\Eng. ZAINAB\\OneDrive\\Documents\\java\\Project\\data\\Example.xlsx";
         Service service =new Service();
         XSSFSheet sheet  =  service.Current_Excel_sheet(excel_path, "Test");
          ArrayList my_index_array =  service.Api_Name(sheet);
          ArrayList my_list3=service.array_values_ofcloumn((int)(api_number-1),sheet,2,"Type");
         return my_list3;
     }
     public  ArrayList get_Alowed_values(int api_number ) throws IOException{
        value_array.clear();
         
         String excel_path="C:\\Users\\Eng. ZAINAB\\OneDrive\\Documents\\java\\Project\\data\\Example.xlsx";
         Service service =new Service();
         XSSFSheet sheet  =  service.Current_Excel_sheet(excel_path, "Test");
          ArrayList my_index_array =  service.Api_Name(sheet);
          ArrayList my_list4=service.array_values_ofcloumn((int) (api_number-1),sheet,3,"Allowed Values");
         return my_list4;
     }
     public  ArrayList get_Mandatory(int api_number ) throws IOException{
         value_array.clear();
         
         String excel_path="C:\\Users\\Eng. ZAINAB\\OneDrive\\Documents\\java\\Project\\data\\Example.xlsx";
         Service service =new Service();
         XSSFSheet sheet  =  service.Current_Excel_sheet(excel_path, "Test");
          ArrayList my_index_array =  service.Api_Name(sheet);
          ArrayList my_list5=service.array_values_ofcloumn((int) (api_number-1),sheet,4,"Mandatory");
         return my_list5;
     }
//     public static void main(String[] args) throws FileNotFoundException, IOException {
//         String title;
//         String excel_path="C:\\Users\\Eng. ZAINAB\\OneDrive\\Documents\\java\\Project\\data\\Example.xlsx";
//         Service service =new Service();
//         XSSFSheet sheet  =  service.Current_Excel_sheet(excel_path, "Test");
//          ArrayList my_index_array =  service.Api_Name(sheet);
//          ArrayList my_2nd_api_io= service.get_IO(2);
//             System.out.println(my_2nd_api_io.toString());
//     }
//       
     //          if(col_toread==1){
//         ArrayList my_list=service.array_values_ofcloumn((int) my_index_array.get(0),sheet,0,"Field Name");}
//         
//          if(col_toread==2){
//      ArrayList my_list=service.array_values_ofcloumn((int) my_index_array.get(0),sheet,0,"Type");}
//         
//          if(col_toread==3){
//         ArrayList my_list=service.array_values_ofcloumn((int) my_index_array.get(0),sheet,0,"Allowed Values");}
//         
//          if(col_toread==4){
//         ArrayList my_list=service.array_values_ofcloumn((int) my_index_array.get(0),sheet,0,"Mandatory");
//           }
     
}

