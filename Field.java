/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author Yara Farid
 */
public class Field {
    
    private boolean input;
    private String name;
    private String type;
    private boolean mandatory;
    private String[] path;
    
    public Field(boolean input, String name, String type, boolean mandatory) {
        this.input = input;
        this.name = name;
        this.type = type;
        this.mandatory = mandatory;
        if (name.startsWith("/")) {
            this.path = name.substring(1).split("/");
        } else {
            this.path = name.split("/");
        }
    }
    
    public boolean isInput() {
        return input;
    }
    
    public String getName() {
        return name;
    }
    
    public String getType() {
        return type;
    }
    
    public String getFieldByLevel(int level) {
        return path[level];
    }
    
    public String[] getPath() {
        return path;
    }
    
    public boolean isMandatory() {
        return mandatory;
    }
    
    public boolean isRoot() {
        return path.length == 1;
    }
    
    public boolean isPathEmpty() {
        return path.length == 0;
    }
    
    public void setInput(boolean input) {
        this.input = input;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }
    
}
