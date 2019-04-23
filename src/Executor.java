import model.ClassObject;

public class Executor {

    private final static String CREATE_CLASS = "-c=";
    private final static String CREATE_FILED = "-f=";
    private final static String SETTERS = "-s";
    private final static String GETTERS = "-g";
    private final static String NO_ARGS_CTOR = "-na";
    private final static String ALL_ARGS_CTOR = "-a";
    private final static String SINGLETON = "-i";

    public void execute(String command) {
        String[] params = command.split(" ");
        checkArgs(params);
    }

    public void checkArgs(String[] args) {
        ClassObject classObject = new ClassObject();
        for (String arg : args) {
            String argValue = "";

            if (arg.startsWith(CREATE_CLASS)) {
                try {
                    argValue = arg.replaceFirst(CREATE_CLASS, "").trim();
                    classObject.setName(argValue);
                } catch (Exception ignoreException) {
                }
            } else if (arg.startsWith(CREATE_FILED)) {
                try {
                    argValue = arg.replaceFirst(CREATE_FILED, "").trim();
                    String[] variable = argValue.split(":");
                    String accessor = variable[0];
                    String type = variable[1];
                    String name = variable[2];
                    classObject.addField(accessor, name, type);
                } catch (Exception e) {
                    classObject.addField("private", "default", "String");
                }
            } else if (arg.startsWith(SETTERS)) {
                try {
                    classObject.generateSetters();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (arg.startsWith(GETTERS)) {
                try {
                    classObject.generateGetters();
                } catch (Exception e) {
                    return;
                }
            } else if (arg.startsWith(NO_ARGS_CTOR)) {
                try {
                    classObject.generateNoArgsCtor();
                } catch (Exception e) {
                }
            } else if (arg.startsWith(ALL_ARGS_CTOR)) {
                try {
                    classObject.generateAllArgsCtor();
                } catch (Exception e) {
                }
            } else if (arg.startsWith(SINGLETON)) {
                try {
                    classObject.generateSingleton();
                } catch (Exception e) {
                }
            }
        }
        System.out.println(classObject.buildFullClass());
    }
}
