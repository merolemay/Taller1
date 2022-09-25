package co.edu.icesi.ostrich_log.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@Builder
public class OstrichDTO {
	
	private UUID id;
    private String name;
    private int gender;
    private float weight;
    private int age;
    private float height;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime arrivalDate;
    @Nullable
    private UUID fatherId;
    @Nullable
    private UUID motherId;
}
