package com.wit.zoo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class KoalaResponse {
    private Koala koala;
    private String message;
    private int status;
}
