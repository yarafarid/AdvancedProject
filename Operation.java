/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excelread;

/**
 *
 * @author Yara Farid
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Operation {

    ArrayList<Field> roots;
    String name;
    String type;
    String url;

    public Operation() {
        this("");
    }

    public Operation(String name){
        this.name= name;
        roots = new ArrayList<Field>();
        type = "";
        url = "";
    }

    public void addField(Field field) {
        if (field.isPathEmpty()) {
            return;
        } else if (field.isRoot()) {
            roots.add(field);
        } else {
            addToExistingTree(field);
        }
      System.out.println(Arrays.toString(field.getPath().toArray()));
    }

    private void addToExistingTree(Field field) {
        String rootName = field.getFieldByLevel(0);
       // System.out.println("root name "+rootName);
        ObjectField root = findObjectRoot(rootName);
        root.addField(field, 1);
    }

    private ObjectField findObjectRoot(String name) {
        for (int i = 0; i < roots.size(); i++) {
            if (roots.get(i).getFieldByLevel(0).equals(name)) {
                return (ObjectField) roots.get(i);
            }
        }
        return null;
    }

    public ArrayList<Field> getRoots() {
        return roots;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }
}
