package excelread;

import java.util.ArrayList;
import java.util.HashMap;

public final class ObjectsRepository {

    public static HashMap<String, ArrayList<String>> all = new HashMap<String, ArrayList<String>>();


    private ObjectsRepository() {
    }

    public static void add(Operation o) {
        for (Field f : o.getRoots()) {
            if (f instanceof ObjectField) {

                traverse((ObjectField) f);
            }
        }
    }


    private static void traverse(ObjectField obj) {
        String name = obj.getFieldOnlyName();
        ArrayList<Field> children = obj.getChildren();
        all.put(name, new ArrayList<String>());
        for (Field c : children) {

            all.get(name).add(c.getFieldOnlyName());
            if (c instanceof ObjectField) {

                traverse((ObjectField) c);
            }
        }

    }

    public static void reset(){
        all.clear();
    }
}
