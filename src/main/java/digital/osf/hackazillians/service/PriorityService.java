package digital.osf.hackazillians.service;

import digital.osf.hackazillians.dto.PriorityDto;
import digital.osf.hackazillians.entities.Priority;
import digital.osf.hackazillians.mapper.PriorityMapper;
import digital.osf.hackazillians.repositories.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityService {

    @Autowired
    private PriorityRepository repository;

    @Autowired
    private PriorityMapper mapper;

    public List<PriorityDto> findAll(){
        return mapper.toDtoList(repository.findAll());
    }
}
