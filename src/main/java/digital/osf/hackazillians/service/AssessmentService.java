package digital.osf.hackazillians.service;

import digital.osf.hackazillians.dto.AssessmentDto;
import digital.osf.hackazillians.entities.Assessment;
import digital.osf.hackazillians.mapper.AssessmentMapper;
import digital.osf.hackazillians.repositories.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AssessmentService {

    @Autowired
    private AssessmentRepository repository;

    @Autowired
    private AssessmentMapper mapper;

    public AssessmentDto findAssessmentByUserId(Integer userId){
       return mapper.toDto(repository.findByUser_Id(userId));
    }


}
