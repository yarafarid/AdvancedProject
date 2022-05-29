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

public class Operation {

    private final int LEVEL = 0;

    ArrayList<Field> roots;
    String name;
    String type;
    String url;

    public Operation() {
        roots = new ArrayList<Field>();
        name = "";
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
        System.out.println(Arrays.toString(field.getPath()));
    }

    private void addToExistingTree(Field field) {
        String rootName = field.getFieldByLevel(LEVEL);
        System.out.println("root name "+rootName);
        ObjectField root = findObjectRoot(rootName);
        root.addField(field, 1);
    }

    private ObjectField findObjectRoot(String name) {
        for (int i = 0; i < roots.size(); i++) {
            if (roots.get(i).getFieldByLevel(LEVEL).equals(name)) {
                return (ObjectField) roots.get(i);
            }
        }
        return null;
    }
}
