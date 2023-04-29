package com.fsa.ProLog.services.implementation;

import com.fsa.ProLog.dao.TrackingDao;
import com.fsa.ProLog.dto.request.TrackingRequestDto;
import com.fsa.ProLog.dto.response.TrackingResponseDto;
import com.fsa.ProLog.models.Tracking;
import com.fsa.ProLog.services.TrackingService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TrackingServiceImpl implements TrackingService {

    private TrackingDao trackingDao;
    private ModelMapper modelMapper;

    // GET methods
    @Override
    public List<TrackingResponseDto> findAll() {
        return trackingDao.findAll()
                .stream().map(el->modelMapper.map(el, TrackingResponseDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public TrackingResponseDto findById(String id) {
        Tracking tracking = trackingDao.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        return modelMapper.map(tracking,TrackingResponseDto.class);
    }

    // POST methods
    @Override
    public TrackingResponseDto save(TrackingRequestDto trackingRequestDto) {
        Tracking tracking = modelMapper.map(trackingRequestDto,Tracking.class);
        Tracking saved = trackingDao.save(tracking);
        return modelMapper.map(saved,TrackingResponseDto.class);
    }

    // PUT methods
    @Override
    public TrackingResponseDto update(TrackingRequestDto trackingRequestDto, String id) {
        Optional<Tracking> trackingOptional = trackingDao.findById(id);
        if(trackingOptional.isPresent()){
            Tracking tracking = trackingOptional
                    .orElseThrow(() -> new RuntimeException("Tracking not found"));

            // Ajouter les nouveaux elements de la liste
            if (trackingRequestDto.getDateChemin() != null) {
                tracking.getDateChemin().addAll(trackingRequestDto.getDateChemin());
            }
            if (trackingRequestDto.getPointsDeRelais() != null) {
                tracking.getPointsDeRelais().addAll(trackingRequestDto.getPointsDeRelais());
            }

            Tracking updated = trackingDao.save(tracking);
            return modelMapper.map(updated,TrackingResponseDto.class);
        } else {
            throw new RuntimeException("ClientNotFound");
        }
    }

    // DELETE methods
    @Override
    public void deleteById(String id) {
        trackingDao.deleteById(id);
    }
    
}
