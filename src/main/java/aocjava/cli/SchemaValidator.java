package aocjava.cli;

import aocjava.utils.ResourceUtils;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

public class SchemaValidator {

    private final Schema schema;

    public SchemaValidator(String resourcePath) {
        JSONObject jsonSchema = ResourceUtils.getJsonFromResources(resourcePath);
        this.schema = SchemaLoader.load(jsonSchema);
    }

    public void validate(JSONObject jsonObject) {
        schema.validate(jsonObject);
    }
}