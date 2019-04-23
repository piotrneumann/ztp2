package model;

public class FieldObject {

    private String accessor;
    private String name;
    private String type;

    public FieldObject(String accessor, String name, String type) {
        this.accessor = accessor;
        this.name = name;
        this.type = type;
    }

    public String generateGetters() {
        return
                "    public String get" + type + "(){\n" +
                        "        return " + name + ";\n" +
                        "    }";
    }

    public String generateSetters() {
        return
                "    public void setName(String name) {\n" +
                        "        this.name = name;\n" +
                        "    }";
    }

    public String buildField() {
        return accessor + " " + type + " " + name + ";";
    }

    public String getAccessor() {
        return accessor;
    }

    public void setAccessor(String accessor) {
        this.accessor = accessor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
