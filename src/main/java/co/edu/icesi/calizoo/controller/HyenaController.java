package co.edu.icesi.calizoo.controller;

import co.edu.icesi.calizoo.constant.HyenaErrorCode;
import co.edu.icesi.calizoo.constant.SexConstants;
import co.edu.icesi.calizoo.dto.HyenaDTO;
import co.edu.icesi.calizoo.api.HyenaAPI;
import co.edu.icesi.calizoo.error.exception.HyenaError;
import co.edu.icesi.calizoo.error.exception.HyenaException;
import co.edu.icesi.calizoo.mapper.HyenaMapper;
import co.edu.icesi.calizoo.model.Hyena;
import co.edu.icesi.calizoo.service.HyenaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static co.edu.icesi.calizoo.constant.HyenaErrorCode.*;

@RestController
@RequiredArgsConstructor
public class HyenaController implements HyenaAPI {

    public final HyenaService hyenaService;
    public final HyenaMapper hyenaMapper;

    @Override
    public HyenaDTO getHyena(UUID hyenaId) {
        return hyenaMapper.fromHyena(hyenaService.getHyena(hyenaId));
    }

    @Override
    public HyenaDTO createHyena (HyenaDTO hyenaDTO) {
        String name = hyenaDTO.getName();
        LocalDateTime arrivalDate = hyenaDTO.getArrivalDate();
        UUID fatherId = hyenaDTO.getFatherId();
        UUID motherId = hyenaDTO.getMotherId();
        int age = hyenaDTO.getAge();
        int height = hyenaDTO.getHeight();
        double weight = hyenaDTO.getWeight();

        isNameCorrect(name);
        isArrivalDateCorrect(arrivalDate);
        isFatherCorrect(fatherId);
        isMotherCorrect(motherId);
        isAgeCorrect(age);
        isHeightCorrect(height);
        isWeightCorrect(weight);
        return hyenaMapper.fromHyena(hyenaService.createHyena(hyenaMapper.fromDTO(hyenaDTO)));

    }

    @Override
    public List<HyenaDTO> getHyenas () {
        return hyenaService.getHyenas().stream().map(hyenaMapper::fromHyena).collect(Collectors.toList());
    }

    private void isNameCorrect (String name) {
        boolean isCorrect = name.matches("^([a-zA-Z]\\s?){1,120}$");
        if (!isCorrect) throwError(CODE_01);
    }

    private void isArrivalDateCorrect (LocalDateTime arrivalDateTime) {
        boolean isCorrect = arrivalDateTime.isBefore(LocalDateTime.now());
        if (!isCorrect) throwError(CODE_02);
    }

    private void isFatherCorrect (UUID fatherId) {
        Hyena father = hyenaService.getHyena(fatherId);
        String MALE = SexConstants.male;
        boolean isCorrect = father == null || father.getSex().equals(MALE);
        if (!isCorrect) throwError(CODE_06);
    }

    private void isMotherCorrect (UUID motherId) {
        Hyena mother = hyenaService.getHyena(motherId);
        String FEMALE = SexConstants.female;
        boolean isCorrect = mother == null || mother.getSex().equals(FEMALE);
        if (!isCorrect) throwError(CODE_07);
    }

    private void isAgeCorrect (int age) {
        boolean isCorrect = age > 0 && age < 25;
        if (!isCorrect) throwError(CODE_03);
    }

    private void isWeightCorrect (double weight) {
        boolean isCorrect = weight > 0 && weight < 64;
        if (!isCorrect) throwError(CODE_04);
    }

    private void isHeightCorrect (int height) {
        boolean isCorrect = height > 0 && height < 92;
        if (!isCorrect) throwError(CODE_05);
    }

    private void throwError (HyenaErrorCode hyenaErrorCode) {
        HyenaError hyenaError = new HyenaError(hyenaErrorCode,hyenaErrorCode.getMessage());
        throw new HyenaException(HttpStatus.BAD_REQUEST, hyenaError);
    }
}
