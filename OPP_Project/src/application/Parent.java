package application;

import java.util.ArrayList;

public class Parent extends Field {
    private ArrayList<Field> fields = new ArrayList<Field>(); 

    public ArrayList<Field> getFields() {
        return fields;
    }

    public void setFields(ArrayList<Field> fields) {
        this.fields = fields;
    }    
}
