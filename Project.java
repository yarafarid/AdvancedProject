/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package excelread;

import com.google.gson.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 *
 * @author Yara Farid
 */
public class Project {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//
//        Operation o = new Operation();
//        ObjectField f1 = new ObjectField("a", "/object1", "", "b");
//        ObjectField f2 = new ObjectField("a", "/object1", "", "b");
//       
//       // DataField f6 = new DataField(false, "/object1/object2/object3/field6/", "", "Y,N", false);
//        
//        o.addField(f1);
//        o.addField(f2);
//        /*Gson gson = new Gson();
//System.out.println(gson.toJson(o));*/
//       
//    //    o.addField(f6);
//        Gson gson = new Gson();
//        System.out.println(gson.toJson(o));
//    }

public static void main(String[] args) throws FileNotFoundException, IOException {
       
      //adding excel file path
       String excel_path="C:\\Users\\Eng. ZAINAB\\OneDrive\\Documents\\java\\Project\\data\\Example.xlsx";
      // new service object
       Service service =new Service();
       XSSFSheet sheet  =  service.Current_Excel_sheet(excel_path, "Test");
      // System.out.println(sheet);
       ArrayList my_index_array =  service.Api_Name(sheet);
      System.out.println(my_index_array.size());
       //System.out.println(service.Current_Excel_Cell(excel_path,"Test", (int) my_index_array.get(2),0));
       // for the 1st api
       ArrayList my_1st_api_io= service.get_IO(1);
       System.out.println(my_1st_api_io.toString()); 
       ArrayList my_1st_api_fields= service.get_field_name(1);
       System.out.println(my_1st_api_fields.toString()); 
       ArrayList my_1st_api_types= service.get_Type(1);
       System.out.println(my_1st_api_types.toString()); 
       ArrayList my_1st_api_alowed_values= service.get_Alowed_values(1);
       System.out.println(my_1st_api_alowed_values.toString()); 
       ArrayList my_1st_api_mandatory= service.get_Mandatory(1);
       System.out.println(my_1st_api_mandatory.toString()); 
       
      Operation o1 = new Operation(); 
      
      for (int i=0;i<my_1st_api_io.size();i++){
      ObjectField f1 = new ObjectField(my_1st_api_io.get(i).toString(), my_1st_api_fields.get(i).toString(),my_1st_api_types.get(i).toString(), my_1st_api_mandatory.get(i).toString());
     o1.addField(f1);}
    
     Gson gson = new Gson();
       System.out.println(gson.toJson(o1));
       
       Operation o2 = new Operation(); 
         ArrayList my_2nd_api_io= service.get_IO(2);
       System.out.println(my_2nd_api_io.toString()); 
       ArrayList my_2nd_api_fields= service.get_field_name(2);
       System.out.println(my_2nd_api_fields.toString()); 
       ArrayList my_2nd_api_types= service.get_Type(2);
       System.out.println(my_2nd_api_types.toString()); 
       ArrayList my_2nd_api_alowed_values= service.get_Alowed_values(2);
       System.out.println(my_2nd_api_alowed_values.toString()); 
       ArrayList my_2nd_api_mandatory= service.get_Mandatory(2);
       System.out.println(my_2nd_api_mandatory.toString()); 
       for (int i=0;i<my_2nd_api_io.size();i++){
      ObjectField f2 = new ObjectField(my_2nd_api_io.get(i).toString(), my_2nd_api_fields.get(i).toString(),my_2nd_api_types.get(i).toString(), my_2nd_api_mandatory.get(i).toString());
     o2.addField(f2);}
      System.out.println(gson.toJson(o2));
    }
}
    

