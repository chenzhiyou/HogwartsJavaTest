package com.hogwarts.learn.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AverageEntity {
    int[] averageNums;
    Double expect;
}
