package co.edu.icesi.calizoo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HyenaDTO {

    private UUID id;

    private String name;

    private String sex;

    private double weight;

    private int age;

    private int height;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime arrivalDate;

    @Nullable
    private UUID fatherId;

    @Nullable
    private UUID motherId;
}
