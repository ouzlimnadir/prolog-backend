package com.fsa.ProLog.services.implementation;

import com.fsa.ProLog.dao.ColisDao;
import com.fsa.ProLog.dao.ConteneurDao;
import com.fsa.ProLog.dto.request.ConteneurRequestDto;
import com.fsa.ProLog.dto.response.ConteneurResponseDto;
import com.fsa.ProLog.models.Colis;
import com.fsa.ProLog.models.Conteneur;
import com.fsa.ProLog.services.ConteneurService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ConteneurServiceImpl implements ConteneurService {
    private ConteneurDao conteneurDao;
    private ColisDao colisDao;
    private ModelMapper modelMapper;

    // GET methods
    @Override
    public List<ConteneurResponseDto> findAll() {
        return conteneurDao.findAll()
                .stream().map(el->modelMapper.map(el, ConteneurResponseDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public ConteneurResponseDto findById(Integer id) {
        Conteneur conteneur = conteneurDao.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        return modelMapper.map(conteneur,ConteneurResponseDto.class);
    }
    @Override
    public ConteneurResponseDto findByRef(String ref) {
        Conteneur conteneur = conteneurDao.findByRef(ref).orElseThrow(()-> new RuntimeException("User not found"));
        return modelMapper.map(conteneur,ConteneurResponseDto.class);
    }

    // POST methods
    @Override
    public ConteneurResponseDto save(ConteneurRequestDto conteneurRequestDto) {
        Conteneur conteneur = modelMapper.map(conteneurRequestDto,Conteneur.class);
        Conteneur saved = conteneurDao.save(conteneur);
        return modelMapper.map(saved,ConteneurResponseDto.class);
    }

    // PUT methods
//    @Override
//    public ConteneurResponseDto update(ConteneurRequestDto conteneurRequestDto, Integer id) {
//        Optional<Conteneur> conteneurOptional = conteneurDao.findById(id);
//        if(conteneurOptional.isPresent()){
//            Conteneur conteneur = modelMapper.map(conteneurRequestDto,Conteneur.class);
//            conteneur.setId(id);
//            Conteneur updated = conteneurDao.save(conteneur);
//            return modelMapper.map(updated,ConteneurResponseDto.class);
//        } else {
//            throw new RuntimeException("ClientNotFound");
//        }
//    }
    @Override
    public ConteneurResponseDto update(ConteneurRequestDto conteneurRequestDto, Integer id) {
        Optional<Conteneur> conteneurOptional = conteneurDao.findById(id);
        if(conteneurOptional.isPresent()){
            Conteneur conteneur = conteneurOptional.get();

            // Ajout des elements
            if(conteneurRequestDto.getRef()!=null)
                conteneur.setRef(conteneurRequestDto.getRef());
            if(conteneurRequestDto.getVilleDepart()!=null)
                conteneur.setVilleDepart(conteneurRequestDto.getVilleDepart());
            if(conteneurRequestDto.getVilleArrivee()!=null)
                conteneur.setVilleArrivee(conteneurRequestDto.getVilleArrivee());
            if(conteneurRequestDto.getDriver()!=null)
                conteneur.setDriver(conteneurRequestDto.getDriver());
            if(conteneurRequestDto.getColis().size()>0){
                List<Colis> colisList = new ArrayList<>();
                for(int i=0; i<conteneurRequestDto.getColis().size(); i++){
                    Optional<Colis> colisOptional = colisDao.findById(conteneurRequestDto.getColis().get(i).getId());
                    colisOptional.orElseThrow(() -> new RuntimeException("Colis not found"));
                    colisOptional.ifPresent(colis -> {
                        if(colis.getInContainer())
                            throw new RuntimeException("Colis with ID " + colis.getId() + " is already in a container.");
                        colis.setInContainer(true);
                        colis.setConteneur(conteneur);
                        colisList.add(colis);
                    });
                }
                conteneur.getColis().addAll(colisList);
            }

            Conteneur updated = conteneurDao.save(conteneur);
            return modelMapper.map(updated, ConteneurResponseDto.class);
        } else {
            throw new RuntimeException("ClientNotFound");
        }
    }

    // DELETE methods
    @Override
    public void deleteById(Integer id) {
        conteneurDao.deleteById(id);
    }
}
