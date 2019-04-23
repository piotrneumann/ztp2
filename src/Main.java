import model.ClassObject;

public class Main {

    public static void main(String[] args) {

        ClassObject classObject = new ClassObject("Dom");
        classObject.addField("private", "pies", "dog");
        classObject.addField("private", "pies", "dog");

        System.out.println(classObject.buildFullClass());
    }
}
