package com.fsa.ProLog.services.implementation;

import com.fsa.ProLog.dao.VehiculeDao;
import com.fsa.ProLog.dto.request.VehiculeRequestDto;
import com.fsa.ProLog.dto.response.VehiculeResponseDto;
import com.fsa.ProLog.models.Vehicule;
import com.fsa.ProLog.services.VehiculeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehiculeServiceImpl implements VehiculeService {
    private VehiculeDao vehiculeDao;
    private ModelMapper modelMapper;

    // GET methods
    @Override
    public List<VehiculeResponseDto> findAll() {
        return vehiculeDao.findAll()
                .stream().map(el->modelMapper.map(el,VehiculeResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public VehiculeResponseDto findById(Integer id) {
        Vehicule vehicule = vehiculeDao.findById(id).orElseThrow(()-> new RuntimeException("Vehicule not found"));
        return modelMapper.map(vehicule,VehiculeResponseDto.class);
    }

    /* TODO :
        liste de 'type' de vehicules
        findByType
     */

    // POST methods
    @Override
    public VehiculeResponseDto save(VehiculeRequestDto vehiculeRequestDto) {
        Vehicule vehicule = modelMapper.map(vehiculeRequestDto,Vehicule.class);
        Vehicule saved = vehiculeDao.save(vehicule);
        return modelMapper.map(saved,VehiculeResponseDto.class);
    }

    // PUT methods
    @Override
    public VehiculeResponseDto update(VehiculeRequestDto vehiculeRequestDto, Integer id) {
        Optional<Vehicule> vehiculeOptional = vehiculeDao.findById(id);
        if(vehiculeOptional.isPresent()){
            Vehicule vehicule = modelMapper.map(vehiculeRequestDto,Vehicule.class);
            vehicule.setId(id);
            Vehicule updated = vehiculeDao.save(vehicule);
            return modelMapper.map(updated, VehiculeResponseDto.class);
        } else {
            throw new RuntimeException("VehiculeNotFound");
        }
    }

    // DELETE methods
    @Override
    public void deleteById(Integer id) {
        vehiculeDao.deleteById(id);
    }
}
