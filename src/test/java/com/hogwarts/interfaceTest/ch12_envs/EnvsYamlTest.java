package com.hogwarts.interfaceTest.ch12_envs;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class EnvsYamlTest {

    @Test
    public void envsYamlTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File yamlFile = new File(classLoader.getResource("envs.yaml").getFile());
        TypeReference<HashMap<String, String>> typeReference = new TypeReference<HashMap<String, String>>(){};

        HashMap<String, String> envs = objectMapper.readValue(yamlFile, typeReference);
        RestAssured.baseURI= envs.get(envs.get("default"));

        given()
                .when()
                .get("/get")
                .then()
                .log().all()
                .statusCode(200);
    }
}
