package com.icesi.edu.zoo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AnimalErrorCode {

    CODE_01("La petición no puede estar vacía"),
    CODE_02("El nombre no es válido. Verifica que el tamaño es menor o igual a 120 caracteres y que solo contiene letras o espacios"),
    CODE_03("El sexo no es válido. Verifica que no está vacío y que es M (macho) o H (hembra)"),
    CODE_04("La fecha no es válida. Verifica que no está vacía y que es anterior o igual a la fecha actual");

    private String message;

}
