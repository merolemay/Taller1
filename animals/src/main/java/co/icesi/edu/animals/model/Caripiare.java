package co.icesi.edu.animals.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Table(name = "`caripiare`")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Caripiare {

    @Type(type = "org.hibernate.type.UUIDCharType")
    @Id
    private UUID id;

    @Column(unique = true)
    private String name;

    private char gender;

    private double weight;

    private int age;

    private double height;

    private LocalDate arrivalDate;

    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID fatherId;

    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID motherId;

    @PrePersist
    public void generateId(){
        this.id = UUID.randomUUID();
    }
}
