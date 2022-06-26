package com.hogwarts.junit5Basics.ceshiren;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.hogwarts.ceshiren.Calculator;
import com.hogwarts.ceshiren.CalculatorYamlEntity;
import com.hogwarts.ceshiren.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorYamlEntityTest {
    Calculator calculator = new Calculator("yaml");
    @ParameterizedTest
    @MethodSource("com.hogwarts.junit5Basics.source.SumYamlSource#sumYamlTest")
    void sumYamlTest(CalculatorYamlEntity calculatorYamlEntity){
        if (calculatorYamlEntity.getMessage().startsWith("有效")){
            int sum = calculator.sum(calculatorYamlEntity.getA(), calculatorYamlEntity.getB());
            assertAll(
                    ()-> assertEquals(calculatorYamlEntity.getResult(), sum, calculatorYamlEntity.getMessage())
            );
        }else if (calculatorYamlEntity.getMessage().startsWith("无效")){
            Exception exception = assertThrows(NumberFormatException.class, ()->calculator.sum(calculatorYamlEntity.getA(), calculatorYamlEntity.getB()));
            String message = exception.getMessage().toString();
            assertThat(calculatorYamlEntity.getMessage(),message, is(containsString("请输入范围内的整数！")));
        }


    }


}
