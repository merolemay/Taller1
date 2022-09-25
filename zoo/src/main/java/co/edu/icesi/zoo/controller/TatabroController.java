package co.edu.icesi.zoo.controller;

import co.edu.icesi.zoo.api.TatabroAPI;
import co.edu.icesi.zoo.dto.TatabroDTO;
import co.edu.icesi.zoo.dto.TatabroParentsDTO;
import co.edu.icesi.zoo.mapper.TatabroMapper;
import co.edu.icesi.zoo.service.TatabroService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class TatabroController implements TatabroAPI {

    public final TatabroService tatabroService;
    public final TatabroMapper tatabroMapper;

    @Override
    public TatabroDTO getTatabroByID(UUID tatabroId) {
        return tatabroMapper.fromTatabro(tatabroService.getTatabroByID(tatabroId));
    }

    @Override
    public TatabroParentsDTO getTatabroByName(String tatabroName) {
        TatabroDTO child = tatabroMapper.fromTatabro(tatabroService.getTatabroByName(tatabroName));
        TatabroDTO father = tatabroMapper.fromTatabro(Optional.ofNullable(child.getFatherID()).map(tatabroService::getTatabroByID).orElse(null));
        TatabroDTO mother = tatabroMapper.fromTatabro(Optional.ofNullable(child.getMotherID()).map(tatabroService::getTatabroByID).orElse(null));
        return tatabroMapper.fromTatabroDTO(child, father, mother);
    }

    @Override
    public TatabroDTO createTatabro(@Valid TatabroDTO tatabroDTO) {
        return tatabroMapper.fromTatabro(tatabroService.createTatabro(tatabroMapper.fromDTO(tatabroDTO)));
    }

    @Override
    public List<TatabroDTO> getTatabros() {
        return tatabroService.getTatabros().stream().map(tatabroMapper::fromTatabro).collect(Collectors.toList());
    }
}