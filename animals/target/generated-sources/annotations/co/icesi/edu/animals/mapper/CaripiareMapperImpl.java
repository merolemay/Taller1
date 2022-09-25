package co.icesi.edu.animals.mapper;

import co.icesi.edu.animals.dto.CaripiareAndParentsDTO;
import co.icesi.edu.animals.dto.CaripiareDTO;
import co.icesi.edu.animals.model.Caripiare;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-24T23:24:14-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class CaripiareMapperImpl implements CaripiareMapper {

    @Override
    public Caripiare fromCaripiareDTO(CaripiareDTO caripiareDTO) {
        if ( caripiareDTO == null ) {
            return null;
        }

        Caripiare.CaripiareBuilder caripiare = Caripiare.builder();

        caripiare.id( caripiareDTO.getId() );
        caripiare.name( caripiareDTO.getName() );
        caripiare.gender( caripiareDTO.getGender() );
        caripiare.weight( caripiareDTO.getWeight() );
        caripiare.age( caripiareDTO.getAge() );
        caripiare.height( caripiareDTO.getHeight() );
        caripiare.arrivalDate( caripiareDTO.getArrivalDate() );
        caripiare.fatherId( caripiareDTO.getFatherId() );
        caripiare.motherId( caripiareDTO.getMotherId() );

        return caripiare.build();
    }

    @Override
    public Caripiare fromCaripiareDTO(UUID caripiareId, CaripiareDTO caripiareDTO) {
        if ( caripiareId == null && caripiareDTO == null ) {
            return null;
        }

        Caripiare.CaripiareBuilder caripiare = Caripiare.builder();

        if ( caripiareDTO != null ) {
            caripiare.id( caripiareDTO.getId() );
            caripiare.name( caripiareDTO.getName() );
            caripiare.gender( caripiareDTO.getGender() );
            caripiare.weight( caripiareDTO.getWeight() );
            caripiare.age( caripiareDTO.getAge() );
            caripiare.height( caripiareDTO.getHeight() );
            caripiare.arrivalDate( caripiareDTO.getArrivalDate() );
            caripiare.fatherId( caripiareDTO.getFatherId() );
            caripiare.motherId( caripiareDTO.getMotherId() );
        }

        return caripiare.build();
    }

    @Override
    public CaripiareDTO fromCaripiare(Caripiare caripiare) {
        if ( caripiare == null ) {
            return null;
        }

        CaripiareDTO.CaripiareDTOBuilder caripiareDTO = CaripiareDTO.builder();

        caripiareDTO.id( caripiare.getId() );
        caripiareDTO.name( caripiare.getName() );
        caripiareDTO.fatherId( caripiare.getFatherId() );
        caripiareDTO.motherId( caripiare.getMotherId() );
        caripiareDTO.gender( caripiare.getGender() );
        caripiareDTO.weight( caripiare.getWeight() );
        caripiareDTO.age( caripiare.getAge() );
        caripiareDTO.height( caripiare.getHeight() );
        caripiareDTO.arrivalDate( caripiare.getArrivalDate() );

        return caripiareDTO.build();
    }

    @Override
    public CaripiareAndParentsDTO fromCaripiareDTOtoCaripiareAndParentsDTO(Caripiare caripiare, Caripiare father, Caripiare mother) {
        if ( caripiare == null && father == null && mother == null ) {
            return null;
        }

        CaripiareAndParentsDTO.CaripiareAndParentsDTOBuilder caripiareAndParentsDTO = CaripiareAndParentsDTO.builder();

        if ( caripiare != null ) {
            caripiareAndParentsDTO.id( caripiare.getId() );
            caripiareAndParentsDTO.name( caripiare.getName() );
            caripiareAndParentsDTO.gender( caripiare.getGender() );
            caripiareAndParentsDTO.weight( caripiare.getWeight() );
            caripiareAndParentsDTO.age( caripiare.getAge() );
            caripiareAndParentsDTO.height( caripiare.getHeight() );
            caripiareAndParentsDTO.arrivalDate( caripiare.getArrivalDate() );
        }
        caripiareAndParentsDTO.mother( father );
        caripiareAndParentsDTO.father( mother );

        return caripiareAndParentsDTO.build();
    }
}
