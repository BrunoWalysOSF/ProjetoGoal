package digital.osf.hackazillians.service;

import digital.osf.hackazillians.constant.TypeRecomendation;
import digital.osf.hackazillians.dto.AchieveGoalDto;
import digital.osf.hackazillians.dto.GoalDto;
import digital.osf.hackazillians.dto.StudyRecomendationDto;
import digital.osf.hackazillians.entities.StudyRecomendation;
import digital.osf.hackazillians.entities.TypeStudyRecomendation;

import java.util.List;

public interface StudyRecomendationService {


    List<StudyRecomendationDto> findRecomendationByAchieve(AchieveGoalDto achieveGoalDto,
                                                           TypeRecomendation typeStudyRecomendation);


    List<GoalDto> saveStudyRecommendation(List<GoalDto> achieveGoalDto);
}
