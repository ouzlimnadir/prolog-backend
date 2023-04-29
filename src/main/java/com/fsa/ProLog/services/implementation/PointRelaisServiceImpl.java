package com.fsa.ProLog.services.implementation;

import com.fsa.ProLog.dao.PointRelaisDao;
import com.fsa.ProLog.dto.request.PointRelaisRequestDto;
import com.fsa.ProLog.dto.response.PointRelaisResponseDto;
import com.fsa.ProLog.models.PointRelais;
import com.fsa.ProLog.services.PointRelaisService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PointRelaisServiceImpl implements PointRelaisService {

    private PointRelaisDao pointRelaisDao;
    private ModelMapper modelMapper;

    // GET methods
    @Override
    public List<PointRelaisResponseDto> findAll() {
        return pointRelaisDao.findAll()
                .stream().map(el->modelMapper.map(el, PointRelaisResponseDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public PointRelaisResponseDto findById(Integer id) {
        PointRelais pointRelais = pointRelaisDao.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        return modelMapper.map(pointRelais,PointRelaisResponseDto.class);
    }

    // POST methods
    @Override
    public PointRelaisResponseDto save(PointRelaisRequestDto pointRelaisRequestDto) {
        PointRelais pointRelais = modelMapper.map(pointRelaisRequestDto,PointRelais.class);
        PointRelais saved = pointRelaisDao.save(pointRelais);
        return modelMapper.map(saved,PointRelaisResponseDto.class);
    }

    // PUT methods
    @Override
    public PointRelaisResponseDto update(PointRelaisRequestDto pointRelaisRequestDto, Integer id) {
        Optional<PointRelais> pointRelaisOptional = pointRelaisDao.findById(id);
        if(pointRelaisOptional.isPresent()){
            PointRelais pointRelais = modelMapper.map(pointRelaisRequestDto,PointRelais.class);
            pointRelais.setId(id);
            PointRelais updated = pointRelaisDao.save(pointRelais);
            return modelMapper.map(updated,PointRelaisResponseDto.class);
        } else {
            throw new RuntimeException("ClientNotFound");
        }
    }

    // DELETE methods
    @Override
    public void deleteById(Integer id) {
        pointRelaisDao.deleteById(id);
    }
    
}
