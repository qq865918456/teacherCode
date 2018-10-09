package com.qf.stu.student_demo.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Student implements Serializable{

    private Integer id;
    private String name;
    private Integer age;
    private Integer cid;
}
