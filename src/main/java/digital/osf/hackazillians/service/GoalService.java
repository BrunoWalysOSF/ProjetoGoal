package digital.osf.hackazillians.service;

import digital.osf.hackazillians.dto.GoalCretedDTO;
import digital.osf.hackazillians.dto.GoalDto;

import java.util.List;

public interface GoalService {

    List<GoalCretedDTO> getGoalById(Integer id);

    List<GoalDto> createOrUpdateGoal(List<GoalDto> goalDto);

    Object updateGoal(GoalDto goalDto);
}
