package co.edu.icesi.spring_zoo_cusumbo.controller;

import co.edu.icesi.spring_zoo_cusumbo.api.CusumboApi;
import co.edu.icesi.spring_zoo_cusumbo.dto.CusumboDTO;
import co.edu.icesi.spring_zoo_cusumbo.error.exception.CusumboError;
import co.edu.icesi.spring_zoo_cusumbo.error.exception.CusumboException;
import co.edu.icesi.spring_zoo_cusumbo.mapper.CusumboMapper;
import co.edu.icesi.spring_zoo_cusumbo.service.CusumboService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static co.edu.icesi.spring_zoo_cusumbo.error.ErrorCode.CODE_01;

@RestController
@AllArgsConstructor
public class CusumboController implements CusumboApi {

    //Height measured in centimeters, for cusumbo it represents the body length
    public static final float MIN_HEIGHT = 30.0f;
    public static final float MAX_HEIGHT = 42.0f;

    //Weight measured in kilograms
    public static final float MIN_WEIGHT = 5.0f;
    public static final float MAX_WEIGHT = 10.0f;

    //Age measured in years
    public static final int MAX_AGE = 15;

    public final CusumboService cusumboService;

    public final CusumboMapper cusumboMapper;

    @Override
    public List<CusumboDTO> getCusumboFamily(String cusumboName) {
        return cusumboService.getCusumboFamily(cusumboName).stream().map(cusumboMapper::fromCusumbo).collect(Collectors.toList());
    }

    @Override
    @SneakyThrows
    public CusumboDTO createCusumbo(CusumboDTO cusumboDTO) {

        if(validateAttributes(cusumboDTO)){
            return cusumboMapper.fromCusumbo(cusumboService.createCusumbo(cusumboMapper.fromDTO(cusumboDTO)));
        }
        else{
            throw new CusumboException(HttpStatus.BAD_REQUEST, new CusumboError(CODE_01.getMessage(),CODE_01));
        }
    }


    private boolean validateAttributes(CusumboDTO cusumboDTO){
        return     validateNameLengthAndCharacters(cusumboDTO.getName())
                && validateArrivalDate(cusumboDTO.getArrivalDate())
                && validateAge(cusumboDTO.getAge())
                && validateHeight(cusumboDTO.getHeight())
                && validateWeight(cusumboDTO.getWeight())
                && validateSex(cusumboDTO.getSex());
    }

    private boolean validateSex(char sex){return sex == 'F' || sex == 'M';}

    private boolean validateNameLengthAndCharacters(String name){
        return name.length() <= 120 && name.length() > 0 && name.replaceAll(" ","").matches("^[a-zA-Z]*$") ;
    }

    private boolean validateArrivalDate(LocalDateTime arrivalDate){
        return arrivalDate.isBefore(LocalDateTime.now());
    }

    private boolean validateAge(int age){
        return age >= 0 && age <= MAX_AGE ;
    }

    private boolean validateHeight(float height){
        return height >= MIN_HEIGHT && height <= MAX_HEIGHT;
    }

    private boolean validateWeight(float weight){
        return weight >= MIN_WEIGHT && weight <= MAX_WEIGHT;
    }

    @Override
    public List<CusumboDTO> getCusumbos() {
        return cusumboService.getCusumbos().stream().map(cusumboMapper::fromCusumbo).collect(Collectors.toList());
    }
}
