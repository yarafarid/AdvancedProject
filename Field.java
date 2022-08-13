/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excelread;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Yara Farid
 */
public class Field {

    private String input;
    private String name;
    private String type;
    private String mandatory;
    private ArrayList<String> path;


    public Field(String input, String name, String type, String mandatory) {
        this.input = input;
        this.name = name;
        this.type = type;
        this.mandatory = mandatory;


        this.path = new ArrayList<>(Arrays.asList(name.split("/")));

        if ((path.size() > 0) && (path.get(0).length() == 0)) {
            path.remove(0);
        }
        if ((path.size() > 0) && (path.get(path.size() - 1).length() == 0)) {
            path.remove(path.size() - 1);
        }

    }


    public String isInput() {
        return input;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getFieldByLevel(int level) {
        return path.get(level);
    }

    public ArrayList<String> getPath() {
        return path;
    }

    public String getFieldOnlyName() {
        return path.get(path.size() - 1);
    }

    public String isMandatory() {
        return mandatory;
    }

    public boolean isRoot() {
        return path.size() == 1;
    }

    public boolean isPathEmpty() {
        return path.size() == 0;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }


}
