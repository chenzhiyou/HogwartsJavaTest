package com.hogwarts.learn.homework.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEntity {
    int[] addNumbers;
    Integer expect;
}
