package com.wit.zoo.entity;

import com.wit.zoo.entity.Kangaroo;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class KangarooResponse {
    private Kangaroo kangaroo;
    private String message;
    private int status;

}
