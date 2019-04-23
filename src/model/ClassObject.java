package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClassObject {

    private String name;
    private List<FieldObject> fields;
    private boolean isSetters;
    private boolean isGetters;
    private boolean isAllArgsCtor;
    private boolean isNonArgsCtor;
    private boolean isSingleton;

    public ClassObject() {
        fields = new ArrayList<FieldObject>();
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
        isAllArgsCtor = true;
        String parameters = fields.stream().map(field -> field.getType() + " " + field.getName() + ", ").collect(Collectors.joining());
        String attribution = fields.stream().map(field -> "this." + field.getName() + " = " + field.getName() + "\n").collect(Collectors.joining());
        return
                "    public " + name + "(" + parameters + ") {\n    " + attribution + "}";
    }

    public String generateNoArgsCtor() {
        isNonArgsCtor = true;
        return
                "    public " + name + "() {}";
    }

    public String generateSetters() {
        isSetters = true;
        return fields.stream().map(field -> field.generateSetters() + "\n").collect(Collectors.joining());
    }

    public String generateGetters() {
        isGetters = true;
        return fields.stream().map(field -> field.generateGetters() + "\n").collect(Collectors.joining());
    }

    public String buildEmptyClass() {
        return "public class " + name + " {}";
    }

    public String buildFullClass() {
        String attribute = fields.stream().map(field -> field.buildField() + "\n").collect(Collectors.joining());
        return "public class " + name + " {\n "
                + attribute + "\n"
                + (isNonArgsCtor ? generateNoArgsCtor() : "") + "\n"
                + (isAllArgsCtor ? generateAllArgsCtor() : "") + "\n"
                + (isGetters ? generateGetters() : "") + "\n"
                + (isSetters ? generateGetters() : "") + "\n"
                + (isSingleton ? generateSingleton() : "") + "\n" +
                "}";
    }

    public String generateSingleton() {
        isSingleton = true;
        String singleton = "private static  " + name + " instance = null;\n";
        return singleton + "   public static " + name + " getInstance() {\n" +
                "      if(instance == null) {\n" +
                "         instance = new " + name + " ();\n" +
                "      }\n" +
                "      return instance;\n" +
                "   }";
    }

}
