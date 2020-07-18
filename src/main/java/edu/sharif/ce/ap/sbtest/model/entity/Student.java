package edu.sharif.ce.ap.sbtest.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "st_table")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Student {
    @Id
    private int id;

    @Column(name = "si")
    private int studentId;

    private String name;
    private String bio;
}
