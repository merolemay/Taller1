package co.edu.icesi.spring_zoo_cusumbo.service.impl;

import co.edu.icesi.spring_zoo_cusumbo.error.exception.CusumboError;
import co.edu.icesi.spring_zoo_cusumbo.error.exception.CusumboException;
import co.edu.icesi.spring_zoo_cusumbo.model.Cusumbo;
import co.edu.icesi.spring_zoo_cusumbo.repository.CusumboRepository;
import co.edu.icesi.spring_zoo_cusumbo.service.CusumboService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static co.edu.icesi.spring_zoo_cusumbo.error.ErrorCode.CODE_02;

@Service
@AllArgsConstructor
public class CusumboServiceImpl implements CusumboService {

    public final CusumboRepository cusumboRepository;

    @Override
    public List<Cusumbo> getCusumboFamily(String cusumboName) {
        List<Cusumbo> cusumbosFamily = new ArrayList<>();

        Cusumbo cusumbo = getCusumboByName(cusumboName);
        cusumbosFamily.add(0,cusumbo);

        UUID fatherId = cusumbo.getFatherId();
        if(fatherId !=null) cusumbosFamily.add(1,getCusumboById(fatherId));

        UUID motherId = cusumbo.getMotherId();
        if(motherId !=null) cusumbosFamily.add(2,getCusumboById(motherId));

        return cusumbosFamily;
    }

    private Cusumbo getCusumboByName(String cusumboName) { return cusumboRepository.findByName(cusumboName).orElse(null);}

    private Cusumbo getCusumboById(UUID cusumboId) {
        return cusumboRepository.findById(cusumboId).orElse(null);
    }

    @Override
    @SneakyThrows
    public Cusumbo createCusumbo(Cusumbo cusumbo) {

        if (validateUniqueName(cusumbo.getName()) && validateParents(cusumbo.getFatherId(),cusumbo.getMotherId())){
            return cusumboRepository.save(cusumbo);
        }
        else{
            throw new CusumboException(HttpStatus.BAD_REQUEST, new CusumboError(CODE_02.getMessage(),CODE_02));
        }
    }
    //Unique name and parents validation was done on the service because checks on the repository are needed
    private boolean validateParents(UUID fatherId, UUID motherId){

        if(fatherId != null && motherId != null){
            return validateParentExistance(fatherId)
                    && validateParentExistance(motherId)
                    && validateParentsSex(fatherId,motherId);
        }

        if(fatherId != null) return validateParentExistance(fatherId);
        if(motherId != null) return validateParentExistance(motherId);

        return true;
    }

    //Returns true when name is not taken (Is unique)
    private boolean validateUniqueName(String name){
        return !cusumboRepository.findByName(name).isPresent();//For some reason isEmpty() doesn't work
    }

    //Returns true if parent exists
    private boolean validateParentExistance(UUID parentId){
        return cusumboRepository.findById(parentId).isPresent();
    }

    private boolean validateParentsSex(UUID fatherId, UUID motherId){
        return getCusumboById(fatherId).getSex() != getCusumboById(motherId).getSex();
    }

    @Override
    public List<Cusumbo> getCusumbos() {
        return StreamSupport.stream(cusumboRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }
}
