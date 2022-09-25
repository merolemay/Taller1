package co.edu.icesi.zoo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table(name = "`tatabros`")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tatabro {

    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    private String name;

    private String sex;

    private double weight;

    private int age;

    private double height;

    private LocalDateTime arrivalDate;

    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID fatherID;

    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID motherID;

    @PrePersist
    public void generateId(){
        this.id = UUID.randomUUID();
    }
}