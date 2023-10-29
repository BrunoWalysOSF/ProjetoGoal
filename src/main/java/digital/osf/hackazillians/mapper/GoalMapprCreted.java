package digital.osf.hackazillians.mapper;

import digital.osf.hackazillians.dto.GoalCretedDTO;
import digital.osf.hackazillians.entities.Goal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring" )
public interface GoalMapprCreted {
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "priority", source = "priority.nivel")
    @Mapping(target = "linkedReview", source = "linkedReview")
    @Mapping(target = "achieveGoal", ignore = true)
    GoalCretedDTO toDto(Goal goal);

    List<GoalCretedDTO> toDto(List<Goal> goals);
}
