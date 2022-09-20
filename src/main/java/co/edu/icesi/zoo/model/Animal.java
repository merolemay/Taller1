package co.edu.icesi.zoo.model;

import co.edu.icesi.zoo.constant.AnimalGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Data
@Table
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

    @Id
    @Column(columnDefinition = "UUID")
    private UUID id;

    @Column(columnDefinition = "varchar(120)", nullable = false)
    private String name;

    @Column(columnDefinition = "ENUM('F', 'M')", nullable = false)
    @Enumerated(EnumType.STRING)
    private AnimalGender sex;

    @Column(columnDefinition = "int", nullable = false)
    private int age;

    @Column(columnDefinition = "double", nullable = false)
    private double height;

    @Column(columnDefinition = "double", nullable = false)
    private double weight;

    @Column(columnDefinition = "date", nullable = false)
    private Date arrivalDate;

    @Column(columnDefinition = "UUID")
    private UUID father_id;

    @Column(columnDefinition = "UUID")
    private UUID mother_id;

    @PrePersist
    public void generateId() {
        this.id = UUID.randomUUID();
    }
}
