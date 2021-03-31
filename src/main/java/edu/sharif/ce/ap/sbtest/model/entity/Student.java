package edu.sharif.ce.ap.sbtest.model.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "st_table")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Student {
    @Id
    private int id;

    @Column(name = "si")
    private int studentId;

    private String name;
    private String bio;
}
