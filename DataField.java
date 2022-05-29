/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author Yara Farid
 */
//import java.util.*;
public class DataField extends Field {

    private String[] allowedValues;

    public DataField(boolean isInput, String name, String type, String allowedValues, boolean isMandatory) {
        super(isInput, name, type, isMandatory);
        if (allowedValues != null && (!allowedValues.isEmpty())) {
            this.allowedValues = allowedValues.split(",");
        }
    }

    public String[] getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(String[] allowedValues) {
        this.allowedValues = allowedValues;
    }

}
