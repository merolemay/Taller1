package co.icesi.edu.animals.controller;

import co.icesi.edu.animals.api.CaripiareAPI;
import co.icesi.edu.animals.constant.CaripiareErrorCode;
import co.icesi.edu.animals.dto.CaripiareAndParentsDTO;
import co.icesi.edu.animals.dto.CaripiareDTO;
import co.icesi.edu.animals.error.exception.CaripiareError;
import co.icesi.edu.animals.error.exception.CaripiareException;
import co.icesi.edu.animals.mapper.CaripiareMapper;
import co.icesi.edu.animals.service.CaripiareService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class CaripiareController implements CaripiareAPI {

    public static final int MAX_NAME_LENGTH = 120;
    public static final String NAME_REGEX = "[ A-Za-z]+";
    public static final char MALE = 'M';
    public static final char FEMALE = 'F';

    //Kilograms
    public static final double MIN_WEIGHT = 1.0;
    public static final double MAX_WEIGHT = 5.0;

    //Years
    public static final int MIN_AGE = 0;
    public static final int MAX_AGE = 20;

    //Meters
    public static final double MIN_HEIGHT = 0.1;
    public static final double MAX_HEIGHT = 0.2;

    public final static String UUID_REGEX = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";

    private final CaripiareService caripiareService;
    private final CaripiareMapper caripiareMapper;

    @Override
    public CaripiareDTO createCaripiare(CaripiareDTO caripiareDTO) {
        validateNotNull(caripiareDTO);
        validateName(caripiareDTO);
        validateGender(caripiareDTO);
        validateWeight(caripiareDTO);
        validateAge(caripiareDTO);
        validateHeight(caripiareDTO);
        validateArrivalDate(caripiareDTO);
        validateParentID(caripiareDTO.getFatherId().toString());
        validateParentID(caripiareDTO.getMotherId().toString());
        try{
            return caripiareMapper.fromCaripiare(caripiareService.createCaripiare(caripiareMapper.fromCaripiareDTO(caripiareDTO)));
        }catch (DataIntegrityViolationException e){
            throw new CaripiareException(HttpStatus.BAD_REQUEST, new CaripiareError(CaripiareErrorCode.CODE_08, CaripiareErrorCode.CODE_08.getMessage()));
        }
    }

    private boolean validateNotNull(CaripiareDTO caripiareDTO){
        if(caripiareDTO != null)
            return true;
        throw new CaripiareException(HttpStatus.BAD_REQUEST, new CaripiareError(CaripiareErrorCode.CODE_01, CaripiareErrorCode.CODE_01.getMessage()));
    }

    private boolean validateName(CaripiareDTO caripiareDTO) {
        String name = caripiareDTO.getName();
        if(name != null && !name.isBlank() && name.length() <= MAX_NAME_LENGTH && name.matches(NAME_REGEX))
            return true;
        throw new CaripiareException(HttpStatus.BAD_REQUEST, new CaripiareError(CaripiareErrorCode.CODE_02, CaripiareErrorCode.CODE_02.getMessage()));
    }

    private boolean validateGender(CaripiareDTO caripiareDTO){
        char gender = caripiareDTO.getGender();
        if(gender != 0 && (gender==MALE || gender==FEMALE))
            return true;
        throw new CaripiareException(HttpStatus.BAD_REQUEST, new CaripiareError(CaripiareErrorCode.CODE_03, CaripiareErrorCode.CODE_03.getMessage()));
    }

    private boolean validateWeight(CaripiareDTO caripiareDTO){
        double weight = caripiareDTO.getWeight();
        if(weight != 0 && weight > MIN_WEIGHT && weight < MAX_WEIGHT)
            return true;
        throw new CaripiareException(HttpStatus.BAD_REQUEST, new CaripiareError(CaripiareErrorCode.CODE_04, CaripiareErrorCode.CODE_04.getMessage()));
    }

    private boolean validateAge(CaripiareDTO caripiareDTO){
        double age = caripiareDTO.getAge();
        if(age != 0 && age > MIN_AGE && age < MAX_AGE)
            return true;
        throw new CaripiareException(HttpStatus.BAD_REQUEST, new CaripiareError(CaripiareErrorCode.CODE_05, CaripiareErrorCode.CODE_05.getMessage()));
    }

    private boolean validateHeight(CaripiareDTO caripiareDTO){
        double height = caripiareDTO.getHeight();
        if(height != 0 && height > MIN_HEIGHT && height < MAX_HEIGHT)
            return true;
        throw new CaripiareException(HttpStatus.BAD_REQUEST, new CaripiareError(CaripiareErrorCode.CODE_06, CaripiareErrorCode.CODE_06.getMessage()));
    }

    private boolean validateArrivalDate(CaripiareDTO caripiareDTO){
        LocalDate arrivalDate = caripiareDTO.getArrivalDate();
        LocalDate localDateNow = LocalDate.now();
        if(arrivalDate != null && arrivalDate.isBefore(localDateNow))
            return true;
        throw new CaripiareException(HttpStatus.BAD_REQUEST, new CaripiareError(CaripiareErrorCode.CODE_07, CaripiareErrorCode.CODE_07.getMessage()));
    }

    private boolean validateParentID(String parentId) {
        if (parentId != null && parentId.matches(UUID_REGEX))
            return true;
        throw new CaripiareException(HttpStatus.BAD_REQUEST, new CaripiareError(CaripiareErrorCode.CODE_09, CaripiareErrorCode.CODE_09 .getMessage()));
    }

    @Override
    public CaripiareDTO getCaripiare(UUID caripiareId) {
        return caripiareMapper.fromCaripiare(caripiareService.getCaripiare(caripiareId));
    }

    @Override
    public List<CaripiareDTO> getCaripiares() {
        return caripiareService.getCaripiares().stream().map(caripiareMapper::fromCaripiare).collect(Collectors.toList());
    }

    @Override
    public CaripiareDTO updateCaripiare(UUID caripiareId, CaripiareDTO caripiareDTO) {
        return caripiareMapper.fromCaripiare(caripiareService.updateCaripiare(caripiareMapper.fromCaripiareDTO(caripiareId, caripiareDTO)));
    }

    @Override
    public CaripiareAndParentsDTO getCaripiareAndParents(String name) {
        return caripiareService.getCaripiareAndParents(name);
    }
}
