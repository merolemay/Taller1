package co.edu.icesi.calizoo.service;

import co.edu.icesi.calizoo.model.Hyena;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface HyenaService {

    public Hyena getHyena(@PathVariable UUID hyenaId);

    public Hyena createHyena (@RequestBody Hyena hyenaDTO);

    public List<Hyena> getHyenas ();

}
