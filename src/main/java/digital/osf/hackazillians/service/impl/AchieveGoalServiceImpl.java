package digital.osf.hackazillians.service.impl;

import digital.osf.hackazillians.dto.AchieveGoalDto;
import digital.osf.hackazillians.dto.FindGoalsAiDto;
import digital.osf.hackazillians.dto.GoalAchieveDto;
import digital.osf.hackazillians.dto.GoalDto;
import digital.osf.hackazillians.dto.chat.GoalAchieveResponseDto;

import digital.osf.hackazillians.entities.AchieveGoal;
import digital.osf.hackazillians.handler.UserInterceptor;
import digital.osf.hackazillians.mapper.AchieveGoalMapper;
import digital.osf.hackazillians.repositories.AchieveGoalRepository;
import digital.osf.hackazillians.service.AchieveGoalService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class AchieveGoalServiceImpl implements AchieveGoalService {

    private final ChatAIAchievesService aiAchieveService;
    private final UserInterceptor user;
    private final AchieveGoalRepository achieveGoalRepository;
    private final AchieveGoalMapper achieveGoalMapper;
    @Override
    @Cacheable(value = "achieve", key = "#goalAchieveDto")
    public GoalAchieveResponseDto findAchievesByGoals(GoalAchieveDto goalAchieveDto, Integer userId) {
        List<GoalDto> goals = new ArrayList<>();
        for (FindGoalsAiDto goal : goalAchieveDto.getGoals()) {
            GoalDto goalDto = new GoalDto();
            goalDto.setName(goal.getName());
            goalDto.setProgress(0);
            goalDto.setStartDate(LocalDate.now());
            goalDto.setExpiredDate(LocalDate.now().plusMonths(6));
            goalDto.setDescription(goal.getDescription());
            goalDto.setUserId(user.getUserId());
            String finalOfQuestion =  goal.getDescription() != null && !goal.getDescription().isEmpty() ? " AND " + goal.getDescription() : "";
            String question = goal.getName() + finalOfQuestion;
            List<String> listGoalsAi = aiAchieveService.askGoalToAI(question);
            List<AchieveGoalDto> achieveGoal = new ArrayList<>();
            for (String response : listGoalsAi) {
                AchieveGoalDto achieveGoalDto = new AchieveGoalDto();
                achieveGoalDto.setName(goal.getName());
                achieveGoalDto.setDescription(response);
                achieveGoalDto.setProgress(0);
                achieveGoal.add(achieveGoalDto);
            }

            goalDto.setAchieveGoal(achieveGoal.subList(0, goalAchieveDto.getSizeData()));
            goals.add(goalDto);

        }
        GoalAchieveResponseDto goalAchieveResponseDto = new GoalAchieveResponseDto();
        goalAchieveResponseDto.setGoals(goals);
        return goalAchieveResponseDto;
    }


    public AchieveGoal updateAchieveGoal(AchieveGoalDto achieveGoal) {
        AchieveGoal entity = achieveGoalMapper.toEntity(achieveGoal);
        return achieveGoalRepository.save(entity);

    }

    public AchieveGoal updateAchieveGoalProgress(Integer id, Integer progress) {
        AchieveGoal achieveGoal = achieveGoalRepository.findById(id).orElseThrow(RuntimeException::new);
        achieveGoal.setProgress(progress);
        return achieveGoalRepository.save(achieveGoal);
    }
}
