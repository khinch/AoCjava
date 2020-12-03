package aocjava.utils;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class ResourceUtils {

    private ResourceUtils(){}

    public static JSONObject getJsonFromResources(String resourcePath) {
        InputStream inputStream = ResourceUtils.class.getClassLoader().getResourceAsStream(resourcePath);
        JSONTokener jsonTokener = new JSONTokener(inputStream);
        return new JSONObject(jsonTokener);
    }
}
