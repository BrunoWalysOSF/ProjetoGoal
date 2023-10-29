package digital.osf.hackazillians.mapper;

import digital.osf.hackazillians.dto.AchieveGoalDto;
import digital.osf.hackazillians.dto.GoalDto;
import digital.osf.hackazillians.entities.AchieveGoal;
import digital.osf.hackazillians.entities.Goal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring" )
public interface GoalMapper {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "priority", source = "priority.nivel")
    @Mapping(target = "linkedReview", source = "linkedReview")
    GoalDto toDto(Goal goal);


    List<GoalDto> toDto(List<Goal> goals);

    @Mapping(target = "startDate",expression = "java(java.time.LocalDate.now())")
    @Mapping(target = "expiredDate",expression = "java(java.time.LocalDate.now().plusMonths(3))")
    @Mapping(target = "progress", source = "achieveGoal" , qualifiedByName = "CalculateProgressToEntity")
    @Mapping(target = "priority", ignore = true)
    Goal toEntity(GoalDto goalDto);

    @Named("CalculateProgressToEntity")
    default int calcularProgressEntity(List<AchieveGoalDto> achieveGoal){
        return (int) achieveGoal.stream()
                .mapToInt(AchieveGoalDto::getProgress)
                .average()
                .orElse(0);
    }

    @Named("CalculateProgressToDto")
    default int calcularProgressDto(List<AchieveGoal> achieveGoal){
        return (int) achieveGoal.stream()
                .mapToInt(AchieveGoal::getProgress)
                .average()
                .orElse(0);
    }

}