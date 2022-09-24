package co.edu.icesi.ecozoo.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@Table
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Animal {
    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    private String name;

    private boolean sex;

    private Double weight;

    private int age;

    private Double height;

    private LocalDateTime arrivalDate;

    private UUID fatherID;

    private UUID motherID;

    @PrePersist
    public void generateId() {
        this.id = UUID.randomUUID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Animal animal = (Animal) o;
        return id != null && Objects.equals(id, animal.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
