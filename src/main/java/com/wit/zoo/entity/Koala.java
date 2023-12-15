package com.wit.zoo.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Koala{
    private int id;
    private String name;
    private String gender;
    private double weight;
    private int sleepHour;

}
