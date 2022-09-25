package icesi.edu.co.zoodemo.service.impl;

import icesi.edu.co.zoodemo.dto.SuricatoParentsDTO;
import icesi.edu.co.zoodemo.error.exception.SuricatoError;
import icesi.edu.co.zoodemo.error.exception.SuricatoException;
import icesi.edu.co.zoodemo.mapper.SuricatoMapper;
import icesi.edu.co.zoodemo.model.Suricato;
import icesi.edu.co.zoodemo.repository.SuricatoRepository;
import icesi.edu.co.zoodemo.service.SuricatoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static icesi.edu.co.zoodemo.constant.SuricatoConstraints.*;
import static icesi.edu.co.zoodemo.constant.SuricatoErrorsCode.*;

@Service
@AllArgsConstructor
public class SuricatoServiceImpl implements SuricatoService {
    private final SuricatoRepository suricatoRepository;
    private final SuricatoMapper suricatoMapper;

    @Override
    public List<Suricato> getSuricatos() {
        return StreamSupport.stream(suricatoRepository.findAll().spliterator(),false ).collect(Collectors.toList());
    }

    @Override
    public Suricato createSuricato(Suricato suricatoDTO) {
        verifyIfNameAlreadyExist(suricatoDTO);
        //validar informacion de el padre del animal
        verifyIfSuricatoExistsByID(suricatoDTO.getFatherId()," its father identifier");
        genreVerify(suricatoDTO.getFatherId(), "M", " Its father id");
        //Validar infromacion de la madre del animal
        verifyIfSuricatoExistsByID(suricatoDTO.getMotherId(), "its mother identifier");
        genreVerify(suricatoDTO.getMotherId(), "F",  "its mother id");

        weightVerify(suricatoDTO.getWeight());
        heightVerify(suricatoDTO.getHeight());

        return suricatoRepository.save(suricatoDTO);

    }

    @Override
    public Suricato getSuricato(UUID suricatoId) {
        return suricatoRepository.findById(suricatoId).orElseThrow(
                () -> new SuricatoException(HttpStatus.BAD_REQUEST, new SuricatoError(CODE_02, CODE_02.getMessage())));
    }



    @Override
    public SuricatoParentsDTO getSuricatosParents(UUID suricatoId) {
        Suricato suricatoWithParents = getSuricato(suricatoId);
        SuricatoParentsDTO suricatoForReturn = suricatoMapper.fromSuricatoToSuricatoParentsDTO(suricatoWithParents);

        suricatoForReturn.setFather(suricatoMapper.toSuricatoDTO(Optional.ofNullable(suricatoWithParents.getFatherId()).map(this::getSuricato).orElse(null)));
        suricatoForReturn.setMother(suricatoMapper.toSuricatoDTO(Optional.ofNullable(suricatoWithParents.getMotherId()).map(this::getSuricato).orElse(null)));
        return suricatoForReturn;


    }
    //Verificar si existe el nombre del animal
    private void verifyIfNameAlreadyExist(Suricato suricatoDTO) {
        List<Suricato> suricatosCreated = getSuricatos();
        for (Suricato suricato : suricatosCreated) {
            if(suricato.getName().equalsIgnoreCase(suricatoDTO.getName())) {
                throw new SuricatoException(HttpStatus.BAD_REQUEST, new SuricatoError(CODE_03, CODE_03.getMessage()));
            }
        }
    }
    //verificar si existe el registro del animal por medio de su identificador
    private boolean verifyIfSuricatoExistsByID(UUID suricatoId, String message) {
        if(suricatoId == null || suricatoId.equals("")) {
            return false;
        }
        if(getSuricato(suricatoId) == null) {
            throw new SuricatoException(HttpStatus.BAD_REQUEST,
                    new SuricatoError(CODE_02, CODE_02.getMessage() + message));
        }
        return false;
    }
    //verificar el genero de un suricato para luego ser asignado como un padre
    private boolean genreVerify(UUID suricatoId, String genre, String message) {
        if(suricatoId == null || suricatoId.equals("")) {
            return false;
        }
        Suricato suricato = getSuricato(suricatoId);
        if(!suricato.getGender().equalsIgnoreCase(genre)) {
            throw new SuricatoException(HttpStatus.BAD_REQUEST,
                    new SuricatoError(CODE_04, CODE_04.getMessage() + message));
        }
        return false;
    }
    //verificacion del peso del suricato
    private void weightVerify(float weight) {
        if(weight > MAX_WEIGHT || weight < MIN_WEIGHT) {
            throw new SuricatoException(HttpStatus.BAD_REQUEST,
                    new SuricatoError(CODE_07, CODE_07.getMessage()));
        }
    }
    //Verificacion del tamaño del suricato
    private void heightVerify(float height) {
        if(height > MAX_HEIGHT || height < MIN_HEIGHT) {
            throw new SuricatoException(HttpStatus.BAD_REQUEST,
                    new SuricatoError(CODE_08, CODE_08.getMessage()));
        }
    }
}
