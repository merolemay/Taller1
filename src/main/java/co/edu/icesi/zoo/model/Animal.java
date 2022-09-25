package co.edu.icesi.zoo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table(name = "`animal`")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Animal {

    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;
    private String name;
    private String gender;
    private float weight;
    private Integer age;
    private float height;
    private LocalDateTime arrivalDate;
    @Type(type="org.hibernate.type.UUIDCharType")
    @Nullable
    private UUID fatherId;
    @Type(type="org.hibernate.type.UUIDCharType")
    @Nullable
    private UUID motherId;

    @PrePersist
    public void generateId(){
        this.id = UUID.randomUUID();
    }

}
