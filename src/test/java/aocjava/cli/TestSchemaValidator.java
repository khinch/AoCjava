package aocjava.cli;

import aocjava.utils.ResourceUtils;
import org.everit.json.schema.ValidationException;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.Assert;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;


public class TestSchemaValidator {

    SchemaValidator schemaValidator = new SchemaValidator("schema.json");

    @Test
    void validInputFile() {
        JSONObject jsonObject = ResourceUtils.getJsonFromResources("TestFile_Valid.json");
        schemaValidator.validate(jsonObject);
    }

    @Test
    void invalidInputFile() {
        JSONObject jsonObject = ResourceUtils.getJsonFromResources("TestFile_Invalid.json");
        try {
            schemaValidator.validate(jsonObject);
            Assert.fail("Schema validator failed to throw exception for invalid JSON file");
        } catch (Exception e) {
            assertTrue(e instanceof ValidationException);
            assertEquals(e.getMessage(), "#/years/0: 5 schema violations found");
        }
    }
}