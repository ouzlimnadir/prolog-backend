package com.fsa.ProLog.services.implementation;

import com.fsa.ProLog.dao.ColisDao;
import com.fsa.ProLog.dto.request.ColisRequestDto;
import com.fsa.ProLog.dto.response.ColisResponseDto;
import com.fsa.ProLog.dto.response.UserResponseDto;
import com.fsa.ProLog.models.Colis;
import com.fsa.ProLog.models.User;
import com.fsa.ProLog.services.ColisService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ColisServiceImpl implements ColisService {
    private ColisDao colisDao;
    private ModelMapper modelMapper;

    // GET methods
    @Override
    public List<ColisResponseDto> findAll() {
        return colisDao.findAll()
                .stream().map(el->modelMapper.map(el, ColisResponseDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public ColisResponseDto findById(Integer id) {
        Colis colis = colisDao.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        return modelMapper.map(colis,ColisResponseDto.class);
    }
    @Override
    public ColisResponseDto findByTrackingNumber(Integer trackingNumber) {
        Colis colis = colisDao.findByTrackingNumber(trackingNumber);
        return modelMapper.map(colis, ColisResponseDto.class);
    }

    // POST methods
    @Override
    public ColisResponseDto save(ColisRequestDto colisRequestDto) {
        Colis colis = modelMapper.map(colisRequestDto,Colis.class);
        Colis saved = colisDao.save(colis);
        return modelMapper.map(saved,ColisResponseDto.class);
    }

    // PUT methods
    @Override
    public ColisResponseDto update(ColisRequestDto colisRequestDto, Integer id) {
        Optional<Colis> colisOptional = colisDao.findById(id);
        if(colisOptional.isPresent()){
            Colis colis = modelMapper.map(colisRequestDto,Colis.class);
            colis.setId(id);
            Colis updated = colisDao.save(colis);
            return modelMapper.map(updated,ColisResponseDto.class);
        } else {
            throw new RuntimeException("ClientNotFound");
        }
    }

    // DELETE methods
    @Override
    public void deleteById(Integer id) {
        colisDao.deleteById(id);
    }
}
