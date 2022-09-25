package co.edu.icesi.zoocanyonriver.mapper;

import co.edu.icesi.zoocanyonriver.dto.TigerDTO;
import co.edu.icesi.zoocanyonriver.dto.TigerResponseDTO;
import co.edu.icesi.zoocanyonriver.model.Tiger;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-24T19:18:41-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.16 (Amazon.com Inc.)"
)
@Component
public class TigerMapperImpl implements TigerMapper {

    @Override
    public Tiger fromDTO(TigerDTO tigerDTO) {
        if ( tigerDTO == null ) {
            return null;
        }

        Tiger.TigerBuilder tiger = Tiger.builder();

        tiger.id( tigerDTO.getId() );
        tiger.mother( tigerDTO.getMother() );
        tiger.father( tigerDTO.getFather() );
        tiger.name( tigerDTO.getName() );
        tiger.gender( tigerDTO.getGender() );
        tiger.weight( tigerDTO.getWeight() );
        tiger.age( tigerDTO.getAge() );
        tiger.height( tigerDTO.getHeight() );
        tiger.arriveDate( tigerDTO.getArriveDate() );

        return tiger.build();
    }

    @Override
    public TigerDTO fromTiger(Tiger tiger) {
        if ( tiger == null ) {
            return null;
        }

        TigerDTO tigerDTO = new TigerDTO();

        tigerDTO.setId( tiger.getId() );
        tigerDTO.setMother( tiger.getMother() );
        tigerDTO.setFather( tiger.getFather() );
        tigerDTO.setName( tiger.getName() );
        tigerDTO.setGender( tiger.getGender() );
        tigerDTO.setWeight( tiger.getWeight() );
        tigerDTO.setAge( tiger.getAge() );
        tigerDTO.setHeight( tiger.getHeight() );
        tigerDTO.setArriveDate( tiger.getArriveDate() );

        return tigerDTO;
    }

    @Override
    public TigerResponseDTO fromTigerToTigerResponseDTO(Tiger tiger, Tiger mother, Tiger father) {
        if ( tiger == null && mother == null && father == null ) {
            return null;
        }

        TigerResponseDTO tigerResponseDTO = new TigerResponseDTO();

        if ( tiger != null ) {
            tigerResponseDTO.setId( tiger.getId() );
            tigerResponseDTO.setName( tiger.getName() );
            tigerResponseDTO.setGender( tiger.getGender() );
            tigerResponseDTO.setWeight( tiger.getWeight() );
            tigerResponseDTO.setAge( tiger.getAge() );
            tigerResponseDTO.setHeight( tiger.getHeight() );
            tigerResponseDTO.setArriveDate( tiger.getArriveDate() );
        }
        tigerResponseDTO.setMother( fromTiger( mother ) );
        tigerResponseDTO.setFather( fromTiger( father ) );

        return tigerResponseDTO;
    }
}
