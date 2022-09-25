package icesi.edu.co.zoodemo.mapper;
import icesi.edu.co.zoodemo.dto.SuricatoDTO;
import icesi.edu.co.zoodemo.dto.SuricatoParentsDTO;
import icesi.edu.co.zoodemo.dto.SuricatoParentsIdDTO;
import icesi.edu.co.zoodemo.model.Suricato;
import icesi.edu.co.zoodemo.service.impl.SuricatoServiceImpl;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SuricatoMapper {
    Suricato toSuricato(SuricatoDTO suricatoDTO);
    SuricatoDTO toSuricatoDTO(Suricato suricato);
    Suricato fromSuricatoParentsDTOtoSuricato(SuricatoParentsDTO suricatoParentsDTO);
    SuricatoParentsDTO fromSuricatoToSuricatoParentsDTO(Suricato suricato);
    SuricatoDTO fromSuricatoParentsDTOtoSuricatoParentsIdDTO(Suricato suricatoParentsDTO);
    SuricatoParentsIdDTO fromSuricatotoSuricatoParentsIdDTO(Suricato suricato);
   Suricato fromSuricatoParentsIdDTOTOtoSuricato(SuricatoParentsIdDTO suricatoParentsIdDTO);


}
