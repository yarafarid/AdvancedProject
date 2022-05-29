/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author Yara Farid
 */
import java.util.*;

public class ObjectField extends Field {

    ArrayList<Field> children;

    public ObjectField(boolean isInput, String name, String type, boolean isMandatory) {
        super(isInput, name, type, isMandatory);
        children = new ArrayList<Field>();
    }

    public void addField(Field field, int level) {
        if (level == field.getPath().length - 1) {
            children.add(field);
            return;
        }
        String fieldName = field.getFieldByLevel(level);
        ObjectField objField = findObjectRoot(fieldName, level);
        objField.addField(field, level + 1);
    }

    private ObjectField findObjectRoot(String name, int level) {
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).getFieldByLevel(level).equals(name)) {
                return (ObjectField) children.get(i);
            }
        }
        return null;
    }
}
