package com.fsa.ProLog.services.implementation;

import com.fsa.ProLog.dao.FactureVehiculeDao;
import com.fsa.ProLog.dto.request.FactureVehiculeRequestDto;
import com.fsa.ProLog.dto.response.FactureVehiculeResponseDto;
import com.fsa.ProLog.models.FactureVehicule;
import com.fsa.ProLog.services.FactureVehiculeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FactureVehiculeServiceImpl implements FactureVehiculeService {
    private FactureVehiculeDao factureVehiculeDao;
    private ModelMapper modelMapper;

    // GET methods
    @Override
    public List<FactureVehiculeResponseDto> findAll() {
        return factureVehiculeDao.findAll()
                .stream().map(el->modelMapper.map(el,FactureVehiculeResponseDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public FactureVehiculeResponseDto findById(Integer id) {
        FactureVehicule factureVehicule = factureVehiculeDao.findById(id).orElseThrow(()-> new RuntimeException("FactureVehicule not found"));
        return modelMapper.map(factureVehicule,FactureVehiculeResponseDto.class);
    }

    // POST methods
    @Override
    public FactureVehiculeResponseDto save(FactureVehiculeRequestDto factureVehiculeRequestDto) {
        FactureVehicule factureVehicule = modelMapper.map(factureVehiculeRequestDto,FactureVehicule.class);
        FactureVehicule saved = factureVehiculeDao.save(factureVehicule);
        return modelMapper.map(saved,FactureVehiculeResponseDto.class);
    }

    // PUT methods
    @Override
    public FactureVehiculeResponseDto update(FactureVehiculeRequestDto factureVehiculeRequestDto, Integer id) {
        Optional<FactureVehicule> factureVehiculeOptional = factureVehiculeDao.findById(id);
        if(factureVehiculeOptional.isPresent()){
            FactureVehicule factureVehicule = modelMapper.map(factureVehiculeRequestDto,FactureVehicule.class);
            factureVehicule.setId(id);
            FactureVehicule updated = factureVehiculeDao.save(factureVehicule);
            return modelMapper.map(updated,FactureVehiculeResponseDto.class);
        } else {
            throw new RuntimeException("FactureVehiculeNotFound");
        }
    }

    // DELETE methods
    @Override
    public void deleteById(Integer id) {
        factureVehiculeDao.deleteById(id);
    }
}
