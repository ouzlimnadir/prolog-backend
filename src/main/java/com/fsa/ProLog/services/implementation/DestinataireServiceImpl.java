package com.fsa.ProLog.services.implementation;

import com.fsa.ProLog.dao.DestinataireDao;
import com.fsa.ProLog.dto.request.DestinataireRequestDto;
import com.fsa.ProLog.dto.response.DestinataireResponseDto;
import com.fsa.ProLog.models.Destinataire;
import com.fsa.ProLog.services.DestinataireService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DestinataireServiceImpl implements DestinataireService {
    private DestinataireDao destinataireDao;
    private ModelMapper modelMapper;

    // GET methods
    @Override
    public List<DestinataireResponseDto> findAll() {
        return destinataireDao.findAll()
                .stream().map(el->modelMapper.map(el,DestinataireResponseDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public DestinataireResponseDto findById(Integer id) {
        Destinataire destinataire = destinataireDao.findById(id).orElseThrow(()-> new RuntimeException("Destinataire not found"));
        return modelMapper.map(destinataire,DestinataireResponseDto.class);
    }

    // POST methods
    @Override
    public DestinataireResponseDto save(DestinataireRequestDto destinataireRequestDto) {
        Destinataire destinataire = modelMapper.map(destinataireRequestDto,Destinataire.class);
        Destinataire saved = destinataireDao.save(destinataire);
        return modelMapper.map(saved,DestinataireResponseDto.class);
    }

    // PUT methods
    @Override
    public DestinataireResponseDto update(DestinataireRequestDto destinataireRequestDto, Integer id) {
        Optional<Destinataire> destinataireOptional = destinataireDao.findById(id);
        if(destinataireOptional.isPresent()){
            Destinataire destinataire = modelMapper.map(destinataireRequestDto,Destinataire.class);
            destinataire.setId(id);
            Destinataire updated = destinataireDao.save(destinataire);
            return modelMapper.map(updated,DestinataireResponseDto.class);
        } else {
            throw new RuntimeException("DestinataireNotFound");
        }
    }

    // DELETE methods
    @Override
    public void deleteById(Integer id) {
        destinataireDao.deleteById(id);
    }
}
