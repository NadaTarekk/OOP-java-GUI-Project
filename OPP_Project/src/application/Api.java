package application;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Api {
    private ArrayList<Field> objects = new ArrayList<>();

    public void setObjects(ArrayList<Field> objects) {
        this.objects = objects;
    }

    public ArrayList<Field> getObjects() {
        return objects;
    }   
}
