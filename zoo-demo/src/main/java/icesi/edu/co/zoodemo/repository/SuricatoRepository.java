package icesi.edu.co.zoodemo.repository;

import icesi.edu.co.zoodemo.model.Suricato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface SuricatoRepository extends CrudRepository<Suricato, UUID> {

}
