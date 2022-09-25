package co.edu.icesi.spring_zoo_cusumbo.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    CODE_01("Missing attributes or invalid attribute values"),
    CODE_02("Repeated name or problem with parents");


    private String message;
}
