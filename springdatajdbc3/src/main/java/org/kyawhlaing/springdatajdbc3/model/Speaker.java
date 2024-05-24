package org.kyawhlaing.springdatajdbc3.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Speaker {
    private int id;
    private String name;
    private String skill;
}
