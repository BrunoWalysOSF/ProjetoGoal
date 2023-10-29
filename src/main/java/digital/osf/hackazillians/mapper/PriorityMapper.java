package digital.osf.hackazillians.mapper;

import digital.osf.hackazillians.dto.PriorityDto;
import digital.osf.hackazillians.entities.Priority;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriorityMapper {

    PriorityDto toDto(Priority priority);

    List<PriorityDto> toDtoList(List<Priority> priority);
}
