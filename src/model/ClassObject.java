package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClassObject {

    private String name;
    private List<FieldObject> fields;

    public ClassObject() {
    }

    public ClassObject(String name) {
        this.name = name;
        fields = new ArrayList<FieldObject>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addField(String accessor, String name, String type) {
        fields.add(new FieldObject(accessor, name, type));
    }

    public String generateAllArgsCtor() {
        String parameters = fields.stream().map(field -> field.getType() + " " + field.getName() + " ").collect(Collectors.joining());
        String attribution = fields.stream().map(field -> "this." + field.getName() + " = " + field.getName() + "\n").collect(Collectors.joining());
        return
                "    public " + name + "(" + parameters + ") {\n    " + attribution + "}";
    }

    public String generateNoArgsCtor() {
        return
                "    public " + name + "() {}";
    }

    public String buildEmptyClass() {
        return "public class " + name + " {}";
    }

    public String buildFullClass() {
        String getters = fields.stream().map(field -> field.generateGetters() + "\n").collect(Collectors.joining());
        String setters = fields.stream().map(field -> field.generateSetters() + "\n").collect(Collectors.joining());
        String attribute = fields.stream().map(field -> field.buildField() + "\n").collect(Collectors.joining());
        return "public class " + name + " {\n " + attribute + "\n" + generateNoArgsCtor() + "\n" + generateAllArgsCtor() + "\n" + getters + "\n" + setters + "\n" + "}";
    }

}
