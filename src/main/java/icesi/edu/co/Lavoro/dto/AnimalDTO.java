package icesi.edu.co.Lavoro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDTO {

    @Id
    private UUID id;

    @NotNull(message = "Name can't be empty")
    @Size(min = 1, max = 120, message = "Animal name can't be longer than 120 chars")
    @Pattern(regexp = "[a-zA-Z]+\\w*[a-zA-Z]+", message = "Name shouldn't contain any special char's")
    private String name;

    @NotNull(message = "Age can't be empty")
    private int age;

    @NotNull(message = "The arrival date cannot be null")
    @PastOrPresent(message = "The arrival date must be a past or present date")
    private LocalDateTime arrivalDate;

    private float height;

    private boolean sex;

    private float weight;

    private UUID motherID;

    private UUID fatherID;

}
