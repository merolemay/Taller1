package icesi.edu.co.zoodemo.service;

import icesi.edu.co.zoodemo.dto.SuricatoParentsDTO;
import icesi.edu.co.zoodemo.model.Suricato;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface SuricatoService {
    public List<Suricato> getSuricatos();

    public Suricato createSuricato(@RequestBody Suricato suricatoDTO);

    public Suricato getSuricato(UUID suricatoId);

    public SuricatoParentsDTO getSuricatosParents(UUID suricatoId);
}
