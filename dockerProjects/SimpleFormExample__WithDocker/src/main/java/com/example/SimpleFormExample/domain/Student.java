package com.example.SimpleFormExample.domain;

import lombok.*;

//import javax.persistence.Entity;
//import javax.persistence.Table;

//@Entity
//@Table(name = "tbl_student")
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String stname;
    private String course;
    private String fee;
}
