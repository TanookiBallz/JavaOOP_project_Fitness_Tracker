package com.example.fitnesstracker;

import com.example.fitnesstracker.model.ModelUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ModelTest {
    @Test
    void testBMI(){
        double bmi= ModelUtil.calculateBMI(70,1.75);
        Assertions.assertEquals(22.86,Math.round(bmi*100.0)/100.0);
    }
}