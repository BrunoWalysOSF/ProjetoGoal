package digital.osf.hackazillians.service.impl;



import digital.osf.hackazillians.dto.GoalCretedDTO;
import digital.osf.hackazillians.dto.GoalDto;
import digital.osf.hackazillians.entities.AchieveGoal;
import digital.osf.hackazillians.entities.Goal;

import digital.osf.hackazillians.handler.UserInterceptor;
import digital.osf.hackazillians.mapper.AchieveGoalMapper;
import digital.osf.hackazillians.mapper.GoalMapper;
import digital.osf.hackazillians.mapper.GoalMapprCreted;
import digital.osf.hackazillians.repositories.AchieveGoalRepository;
import digital.osf.hackazillians.repositories.GoalRepository;

import digital.osf.hackazillians.service.GoalService;
import digital.osf.hackazillians.service.StudyRecomendationService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GoalServiceImpl implements GoalService {

    private final GoalRepository goalRepository;

    private final GoalMapper goalMapper;

    private final AchieveGoalMapper achieveGoalMapper;

    private final AchieveGoalRepository achieveGoalRepository;

    private final UserInterceptor user;

    private final StudyRecomendationService studyRecomendationService;

    private final GoalMapprCreted goalMapprCreted;


    @Transactional
    public List<GoalDto> createOrUpdateGoal(List<GoalDto> goalDto) {
        List<Goal> goals = new ArrayList<>();
        for (GoalDto goal : goalDto) {
            goal.setUserId(user.getUserId());
            Goal goalEntity = goalMapper.toEntity(goal);
            goalRepository.save(goalEntity);
            goals.add(goalEntity);
            goal = goalMapper.toDto(goalEntity);
            List<AchieveGoal> achieveGoalList = achieveGoalMapper.toEntity(goal.getAchieveGoal());
            achieveGoalList.forEach(achieveGoal -> achieveGoal.setGoalId(goalEntity));
            List<AchieveGoal> achieveGoalSaved = achieveGoalList.stream().map(achieveGoalRepository::save).collect(Collectors.toList());
            goalEntity.setAchieveGoal(achieveGoalSaved);
        }
        return studyRecomendationService.saveStudyRecommendation(goalMapper.toDto(goals));
    }

    @Override
    public Goal updateGoal(GoalDto goalDto) {
        return goalRepository.save(goalMapper.toEntity(goalDto));
    }

    @Override
    public List<GoalCretedDTO> getGoalById(Integer id) {
        List<Goal> goals = goalRepository.findByUserId(id);

        goals.forEach(goal -> {
            int media = (int) goal.getAchieveGoal().stream()
                    .mapToInt(AchieveGoal::getProgress)
                    .average()
                    .orElse(0.0);

            goal.setProgress(media);
        });
        return goalMapprCreted.toDto(goals);
    }


}
