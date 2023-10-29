package digital.osf.hackazillians.mapper;

import digital.osf.hackazillians.dto.AchieveGoalDto;
import digital.osf.hackazillians.dto.GoalDto;
import digital.osf.hackazillians.dto.chat.GoalAchieveResponseDto;
import digital.osf.hackazillians.entities.AchieveGoal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AchieveGoalMapper {

    AchieveGoal toEntity(AchieveGoalDto achieveGoal);

    @Mapping(target = "goalId.id", source = "goal.id")
    @Mapping(target = "goalId.user.id", source = "goalId.userId")
    List<AchieveGoal> toEntity(List<AchieveGoalDto> achieveGoalDtos);

    AchieveGoalDto toDto(AchieveGoal achieveGoal);

    List<AchieveGoalDto> toDtoList(List<AchieveGoal> achieveGoals);





}
