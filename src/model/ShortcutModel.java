package model;

import java.util.Arrays;

/**
 * Created by Drew on 2017-02-02.
 */
public class ShortcutModel {
    private static final int MAX_KEY = 3;
    private String keys[];
    private String description;
    private String name;
    private String category;

    public String[] getKeys() {
        return keys;
    }

    public void setKeys(String[] keys) {
        this.keys = keys;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ShortcutModel(String name, String[] keys, String description, String category) {
        this.keys = keys;
        this.description = description;
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return "ShortcutModel{" +
                "keys=" + Arrays.toString(keys) +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    private boolean isContainKey(String targetKey) {
        if(keys == null){
            return false;
        }

        for(String key : keys){
            if(key.equals(targetKey)){
                return true;
            }
        }

        return false;
    }

    public boolean isContainKeys(String[] targetKeys) {
        for(String targetKey : targetKeys){
            if(!isContainKey(targetKey)){
                return false;
            }
        }

        return true;
    }
}
