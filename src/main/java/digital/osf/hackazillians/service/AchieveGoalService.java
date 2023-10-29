package digital.osf.hackazillians.service;

import digital.osf.hackazillians.dto.AchieveGoalDto;
import digital.osf.hackazillians.dto.GoalAchieveDto;
import digital.osf.hackazillians.dto.chat.GoalAchieveResponseDto;
import digital.osf.hackazillians.entities.AchieveGoal;

public interface AchieveGoalService {

    GoalAchieveResponseDto findAchievesByGoals(GoalAchieveDto goalAchieveDto, Integer userId);

     AchieveGoal updateAchieveGoal(AchieveGoalDto achieveGoal);
     AchieveGoal updateAchieveGoalProgress(Integer id, Integer progress);



}
