package co.edu.icesi.calizoo.service.impl;

import co.edu.icesi.calizoo.error.exception.HyenaError;
import co.edu.icesi.calizoo.error.exception.HyenaException;
import co.edu.icesi.calizoo.model.Hyena;
import co.edu.icesi.calizoo.repository.HyenaRepository;
import co.edu.icesi.calizoo.service.HyenaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import static co.edu.icesi.calizoo.constant.HyenaErrorCode.CODE_08;


@Service
@AllArgsConstructor
public class HyenaServiceImpl implements HyenaService {

    public final HyenaRepository hyenaRepository;

    @Override
    public Hyena getHyena (@Nullable UUID hyenaId) { return hyenaId == null ? null : hyenaRepository.findById(hyenaId).orElse(null); }

    @Override
    public Hyena createHyena (Hyena hyenaDTO) {
        String nameFromDTO = hyenaDTO.getName();
        boolean isNameRepeated = getHyenas().stream().anyMatch(hyena -> hyena.getName().equalsIgnoreCase(nameFromDTO));

        HyenaError hyenaError = new HyenaError(CODE_08,CODE_08.getMessage());
        if (isNameRepeated) throw new HyenaException(HttpStatus.BAD_REQUEST, hyenaError);
        else return hyenaRepository.save(hyenaDTO);
    }

    @Override
    public List<Hyena> getHyenas () {
        return StreamSupport.stream(hyenaRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }
}
