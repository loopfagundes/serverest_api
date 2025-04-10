package dev.serverest.helpers;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidatorHelper {
    private static final String PATH_SCHEMAS = "schemas/";

    public static JsonSchemaValidator validateJson(String pathToSchema) {
        return JsonSchemaValidator.matchesJsonSchemaInClasspath(PATH_SCHEMAS + pathToSchema + ".json");
    }
}