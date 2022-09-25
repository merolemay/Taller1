package icesi.edu.co.zoodemo.controller;

import icesi.edu.co.zoodemo.api.SuricatoAPI;
import icesi.edu.co.zoodemo.dto.SuricatoDTO;
import icesi.edu.co.zoodemo.dto.SuricatoParentsDTO;
import icesi.edu.co.zoodemo.dto.SuricatoParentsIdDTO;
import icesi.edu.co.zoodemo.error.exception.SuricatoError;
import icesi.edu.co.zoodemo.error.exception.SuricatoException;
import icesi.edu.co.zoodemo.mapper.SuricatoMapper;
import icesi.edu.co.zoodemo.service.impl.SuricatoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static icesi.edu.co.zoodemo.constant.SuricatoErrorsCode.*;

@RestController
@AllArgsConstructor
public class SuricatoController implements SuricatoAPI {

    private SuricatoServiceImpl suricatoServiceImpl;
    private SuricatoMapper suricatoMapper;

    @Override
    public SuricatoDTO createSuricato(SuricatoParentsIdDTO suricatoParentsIdDTO) {
        //verificaciones de las caracteristicas fecha, y el largo y las caracteristicas del nombre
        verifyNameLengthVerify(suricatoParentsIdDTO.getName());
        nameCharactersVerify(suricatoParentsIdDTO.getName());
        dateValidate(suricatoParentsIdDTO.getArriveDate());
        return suricatoMapper.toSuricatoDTO(suricatoServiceImpl.createSuricato(suricatoMapper.fromSuricatoParentsIdDTOTOtoSuricato(suricatoParentsIdDTO)));

    }

    @Override
    public List<SuricatoDTO> getSuricatos() {
        return suricatoServiceImpl.getSuricatos().stream().map(suricatoMapper::toSuricatoDTO).collect(Collectors.toList());
    }

    @Override
    public SuricatoParentsDTO getSuricato(UUID suricatoId) {
        return suricatoServiceImpl.getSuricatosParents(suricatoId);
    }
    private void dateValidate(LocalDateTime dateArrive) {
        if(dateArrive.isAfter(LocalDateTime.now())) {
            throw new SuricatoException(HttpStatus.BAD_REQUEST,
                    new SuricatoError(CODE_06, CODE_06.getMessage()));
        }
    }
    private void nameCharactersVerify(String name) {
        if(!name.matches("^[a-zA-Z\\s]*$")) {
            throw new SuricatoException(HttpStatus.BAD_REQUEST,
                    new SuricatoError(CODE_05, CODE_05.getMessage()));
        }
    }
    private void verifyNameLengthVerify(String name) {
        if(name.length() > 120) {
            throw new SuricatoException(HttpStatus.BAD_REQUEST, new SuricatoError(CODE_01,CODE_01.getMessage()));
        }
    }

}
