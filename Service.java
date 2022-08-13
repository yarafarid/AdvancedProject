/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excelread;

import static excelread.Excelread.Current_Excel_sheet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 * @author Eng. ZAINAB
 */
public class Service {
    private String excelFile;
    private ArrayList<Operation> allApis = new ArrayList<Operation>();
    public Service(String excelFile) {
        this.excelFile = excelFile;
    }

    public void init() throws IOException {
        Excelread reader = new Excelread(excelFile);
        XSSFSheet sheet = reader.Current_Excel_sheet("Test");

        ArrayList<Integer> indexes = reader.getApiIndexes(sheet);

        for(int i = 0 ; i < indexes.size() ; i++) {
            // for the 1st api
            ArrayList io = reader.get_IO(i+1);
            ArrayList fields = reader.get_field_name(i+1);
            ArrayList types = reader.get_Type(i+1);
            ArrayList allowedValues = reader.get_Alowed_values(i+1);
            ArrayList mandatory = reader.get_Mandatory(i+1);

            Operation operation = new Operation(reader.getApiName(i+1));
            for (int j = 0; j < io.size(); j++) {
                Field f;
                if (types.get(j).toString().equalsIgnoreCase("string")) {
                    f = new DataField(io.get(j).toString(), fields.get(j).toString(), types.get(j).toString(), allowedValues.get(j).toString(), mandatory.get(j).toString());
                } else {
                    f = new ObjectField(io.get(j).toString(), fields.get(j).toString(), types.get(j).toString(), mandatory.get(j).toString());
                }
                operation.addField(f);
            }
            allApis.add(operation);
        }
    }

    public Operation getOperation(String name){
        for(Operation o : allApis){
            if(o.getName().equalsIgnoreCase(name)){
                return o;
            }
        }
        return null;
    }
}

