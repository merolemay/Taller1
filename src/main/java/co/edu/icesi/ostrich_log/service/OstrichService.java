package co.edu.icesi.ostrich_log.service;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import co.edu.icesi.ostrich_log.model.Ostrich;

public interface OstrichService {
	
	Ostrich getOstrich(@PathVariable UUID ostrichId);

    Ostrich createOstrich(@RequestBody Ostrich ostrich);

    List<Ostrich> getOstrichs();
    
    Ostrich updateOstrich(Ostrich ostrich);
}
