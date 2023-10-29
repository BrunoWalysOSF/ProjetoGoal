package digital.osf.hackazillians.mapper;

import digital.osf.hackazillians.dto.AssessmentDto;
import digital.osf.hackazillians.entities.Assessment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AssessmentMapper {

    @Mapping(target = "nextAssessmentDate", source = "nextAssessmentDate", dateFormat = "dd/MM/yyyy")
    AssessmentDto toDto(Assessment assessment);
}
