/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project;

import com.google.gson.*;

/**
 *
 * @author Yara Farid
 */
public class Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Operation o = new Operation();
        ObjectField f1 = new ObjectField(false, "/object1", "", false);
        ObjectField f2 = new ObjectField(false, "/object1/object2", "", false);
        DataField f3 = new DataField(false, "/object1/object2/field1", "","Y,N", false);
        DataField f4 = new DataField(false, "/field2", "", "1,2,3",false);

        o.addField(f1);
        /*Gson gson = new Gson();
System.out.println(gson.toJson(o));*/
        o.addField(f2);
        o.addField(f3);
        o.addField(f4);
        Gson gson = new Gson();
        System.out.println(gson.toJson(o));
    }

}
