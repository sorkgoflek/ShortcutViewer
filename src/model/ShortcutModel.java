package model;

/**
 * Created by Drew on 2017-02-02.
 */
public class ShortcutModel {
    private static final int MAX_KEY = 3;
    private String key[];
    private String description;
    private String name;
    private String label;

    public String[] getKey() {
        return key;
    }

    public void setKey(String[] key) {
        this.key = key;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ShortcutModel(String[] key, String description, String name, String label) {
        this.key = key;
        this.description = description;
        this.name = name;
        this.label = label;
    }
}
