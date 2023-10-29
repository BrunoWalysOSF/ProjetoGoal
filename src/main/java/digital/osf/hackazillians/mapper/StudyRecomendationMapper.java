package digital.osf.hackazillians.mapper;

import digital.osf.hackazillians.dto.AchieveGoalDto;
import digital.osf.hackazillians.dto.StudyRecomendationDto;
import digital.osf.hackazillians.entities.AchieveGoal;
import digital.osf.hackazillians.entities.StudyRecomendation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudyRecomendationMapper {

    @Mapping(target = "achieveId", source = "achieveId")
    @Mapping(target = "typeId.id", source = "typeId.id")
    @Mapping(target = "typeId.type", source = "typeId.type")
    StudyRecomendation toEntity(StudyRecomendationDto studyRecomendationDto);


    List<StudyRecomendationDto> toDto(List<StudyRecomendation> studyRecomendations);


}
