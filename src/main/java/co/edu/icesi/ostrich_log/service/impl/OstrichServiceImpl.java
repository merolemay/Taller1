package co.edu.icesi.ostrich_log.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import co.edu.icesi.ostrich_log.model.Ostrich;
import co.edu.icesi.ostrich_log.repository.OstrichRepository;
import co.edu.icesi.ostrich_log.service.OstrichService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class OstrichServiceImpl implements OstrichService {

    private final OstrichRepository ostrichRepository;

    @Override
    public Ostrich createOstrich(Ostrich ostrich) {
        return ostrichRepository.save(ostrich);
    }

    @Override
    public Ostrich getOstrich(UUID ostrichId) {
        Optional<Ostrich> ostrich = ostrichRepository.findById(ostrichId);
        if(ostrich.isPresent()){
            return ostrich.get();
        }
        return null;
        //throw new DocumentException(HttpStatus.NOT_FOUND, new DocumentError(DocumentErrorCode.CODE_01.name(), DocumentErrorCode.CODE_01.getMessage()));
    }

    @Override
    public List<Ostrich> getOstrichs() {
        return StreamSupport.stream(ostrichRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public Ostrich updateOstrich(Ostrich ostrich) {
        return ostrichRepository.save(ostrich);
    }
}
