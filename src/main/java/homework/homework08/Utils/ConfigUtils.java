package homework.homework08.Utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigUtils {
    public static String getGenericElement(String configFIle, String propertyName, String defaultValue) {
        String results = defaultValue;
        try {
            Properties appProp = new Properties();
            appProp.load(Files.newInputStream(Paths.get(configFIle)));
            results = appProp.getProperty(propertyName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return results;
    }
    public static String getGenericElement(String configFIle, String propertyName) {
        return getGenericElement(configFIle, propertyName, "");
    }

}
