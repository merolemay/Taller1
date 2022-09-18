package co.edu.icesi.zoo.model;

import co.edu.icesi.zoo.constant.AnimalGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Data
@Table(name = "`animal`")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    @Column(unique = true)
    private String name;
    private AnimalGender sex;
    private int age;
    private double height;
    private double weight;
    private Date arrivalDate;

    @PrePersist
    public void generateId() {
        this.id = UUID.randomUUID();
    }
}
