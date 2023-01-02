package at.edu.c02.calculator.logic;

import at.edu.c02.calculator.StorageException;

import java.util.HashMap;

public class Storage {
    private HashMap<String, Double> values;
    public Storage() {
        values = new HashMap<>();
    }
    public void store(double value, String name){
        try{
            values.put(name,value);
        }
        catch (Exception ex){
            System.out.println("No value with this key found.");
        }
    }
    public void store(double value){values.put("_first_",value);}

    public double load(){return values.get("_first_");}

    public double load(String name) throws StorageException{
        double value = 0;
        try{
            value = values.get(name);
        }
        catch (Exception ex){
            throw new StorageException("No value with this key found.");
        }
        return value;
    }
}
