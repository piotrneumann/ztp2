import model.ClassObject;

import javax.imageio.ImageIO;
import java.io.File;

public class Executor {

    private final static String CREATE_CLASS = "-c=";
    private final static String CREATE_FILED = "-f=";
    private final static String SETTERS = "-s";
    private final static String GETTERS = "-g";
    private final static String NO_ARGS_CTOR = "-na";
    private final static String ALL_ARGS_CTOR = "-a";

    public void execute(String command) {
        String[] params = command.split(" ");

    }

    public void checkArgs(String[] args) {
        ClassObject classObject = new ClassObject();
        for (String arg : args) {
            String argValue = "";

            if (arg.startsWith(CREATE_CLASS)) {
                try {
                    argValue = arg.replaceFirst(CREATE_CLASS, "").trim();
                    classObject.setName(argValue);
                } catch (Exception e) {
                    printMessageAndExit(ARG_ERROR_PREFIX + ARG_IMG_TO_FIND.replace("=", ""));
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
                    printMessageAndExit(ARG_ERROR_PREFIX + ARG_TIMEOUT.replace("=", ""));
                }
            } else if (arg.startsWith(SETTERS)) {
                try {
                    argValue = arg.replaceFirst(SETTERS, "").trim();
                    classObject.
                } catch (Exception e) {
                    printMessageAndExit(ARG_ERROR_PREFIX + ARG_THRESHOLD.replace("=", ""));
                }
            } else if (arg.startsWith(GETTERS)) {
                try {
                    argValue = arg.replaceFirst(GETTERS, "").trim();
                    classObject.
                } catch (Exception e) {
                    printMessageAndExit(ARG_ERROR_PREFIX + ARG_SCREESHOT_DELAY.replace("=", ""));
                }
            } else if (arg.startsWith(NO_ARGS_CTOR)) {
                try {
                    argValue = arg.replaceFirst(NO_ARGS_CTOR, "").trim();
                    classObject.
                } catch (Exception e) {
                    printMessageAndExit(ARG_ERROR_PREFIX + ARG_IGNORE_COLOR.replace("=", ""));
                }
            } else if (arg.startsWith(ALL_ARGS_CTOR)) {
                try {
                    argValue = arg.replaceFirst(ALL_ARGS_CTOR, "").trim();
                    classObject.
                } catch (Exception e) {
                    printMessageAndExit(ARG_ERROR_PREFIX + ARG_IGNORE_COLOR.replace("=", ""));
                }
            }
        }
    }
}
