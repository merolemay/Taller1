package co.icesi.edu.animals.service.impl;

import co.icesi.edu.animals.constant.CaripiareErrorCode;
import co.icesi.edu.animals.dto.CaripiareAndParentsDTO;
import co.icesi.edu.animals.error.exception.CaripiareError;
import co.icesi.edu.animals.error.exception.CaripiareException;
import co.icesi.edu.animals.mapper.CaripiareMapper;
import co.icesi.edu.animals.model.Caripiare;
import co.icesi.edu.animals.repository.CaripiareRepository;
import co.icesi.edu.animals.service.CaripiareService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CaripiareServiceImpl implements CaripiareService {

    private final CaripiareRepository caripiareRepository;
    private final CaripiareMapper caripiareMapper;

    @Override
    public Caripiare createCaripiare(Caripiare caripiare) {
        return caripiareRepository.save(caripiare);
    }

    @Override
    public Caripiare getCaripiare(UUID caripiareId) {
        Optional<Caripiare> optionalCaripiare = caripiareRepository.findById(caripiareId);
        if(optionalCaripiare.isPresent())
            return optionalCaripiare.get();
        throw new CaripiareException(HttpStatus.NOT_FOUND, new CaripiareError(CaripiareErrorCode.CODE_01, CaripiareErrorCode.CODE_01.getMessage()));
    }

    @Override
    public CaripiareAndParentsDTO getCaripiareAndParents(String name) {
        Optional<Caripiare> optionalCaripiare = searchByUniqueName(name);
        if (optionalCaripiare.isEmpty()) return null;
        Caripiare father = Optional.ofNullable(optionalCaripiare.get().getFatherId()).map(this::getCaripiare).orElse(null);
        Caripiare mother = Optional.ofNullable(optionalCaripiare.get().getMotherId()).map(this::getCaripiare).orElse(null);
        return caripiareMapper.fromCaripiareDTOtoCaripiareAndParentsDTO(optionalCaripiare.get(), father, mother);
    }

    private Optional<Caripiare> searchByUniqueName(String name){
        for(Caripiare caripiare:getCaripiares()){
            if(caripiare.getName().equals(name))
                return Optional.of(caripiare);
        }
        return Optional.empty();
    }

    @Override
    public List<Caripiare> getCaripiares() {
        return StreamSupport.stream(caripiareRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public Caripiare updateCaripiare(Caripiare caripiare) {
        Optional<Caripiare> optionalCaripiare = caripiareRepository.findById(caripiare.getId());
        if(optionalCaripiare.isPresent())
            return caripiareRepository.save(caripiare);
        throw new CaripiareException(HttpStatus.NOT_FOUND, new CaripiareError(CaripiareErrorCode.CODE_01, CaripiareErrorCode.CODE_01.getMessage()));
    }
}
