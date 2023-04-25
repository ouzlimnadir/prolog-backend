package com.fsa.ProLog.services.implementation;

import com.fsa.ProLog.dao.FactureColisDao;
import com.fsa.ProLog.dto.request.FactureColisRequestDto;
import com.fsa.ProLog.dto.response.FactureColisResponseDto;
import com.fsa.ProLog.models.FactureColis;
import com.fsa.ProLog.services.FactureColisService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FactureColisServiceImpl implements FactureColisService {
    private FactureColisDao factureColisDao;
//    private UserDao userDao;
    private ModelMapper modelMapper;

    // GET methods
    @Override
    public List<FactureColisResponseDto> findAll() {
        return factureColisDao.findAll()
                .stream().map(el->modelMapper.map(el,FactureColisResponseDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public FactureColisResponseDto findById(Integer id) {
        FactureColis factureColis = factureColisDao.findById(id).orElseThrow(()-> new RuntimeException("FactureColis not found"));
        return modelMapper.map(factureColis,FactureColisResponseDto.class);
    }
    @Override
    public List<FactureColisResponseDto> findByClientId(Integer id){
        return factureColisDao.findByClientId(id)
                .stream().map(el->modelMapper.map(el,FactureColisResponseDto.class))
                .collect(Collectors.toList());
    }

    // POST methods
    @Override
    public FactureColisResponseDto save(FactureColisRequestDto factureColisRequestDto) {
        FactureColis factureColis = modelMapper.map(factureColisRequestDto,FactureColis.class);
//        Integer idClient = factureColis.getClient().getId();
//        User client = userDao.findById(idClient).orElseThrow(()-> new RuntimeException("User not found"));
//        factureColis.setClient(client);
        FactureColis saved = factureColisDao.save(factureColis);
        return modelMapper.map(saved,FactureColisResponseDto.class);
    }

    // PUT methods
    @Override
    public FactureColisResponseDto update(FactureColisRequestDto factureColisRequestDto, Integer id) {
        Optional<FactureColis> factureColisOptional = factureColisDao.findById(id);
        if(factureColisOptional.isPresent()){
            FactureColis factureColis = modelMapper.map(factureColisRequestDto,FactureColis.class);
            factureColis.setId(id);
            FactureColis updated = factureColisDao.save(factureColis);
            return modelMapper.map(updated,FactureColisResponseDto.class);
        } else {
            throw new RuntimeException("FactureColisNotFound");
        }
    }

    // DELETE methods
    @Override
    public void deleteById(Integer id) {
        factureColisDao.deleteById(id);
    }
}
