package dev.serverest.utils;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidatorHelper  {
    private static final String SCHEMAS = "schemas/";

    public static void json(String path) {
        JsonSchemaValidator.matchesJsonSchemaInClasspath(SCHEMAS + path);
    }
}