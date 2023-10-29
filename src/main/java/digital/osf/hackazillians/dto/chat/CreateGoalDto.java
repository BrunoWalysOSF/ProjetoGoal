package digital.osf.hackazillians.dto.chat;

import digital.osf.hackazillians.dto.GoalDto;
import lombok.Data;

import java.util.List;

@Data
public class CreateGoalDto {

    List<GoalDto> goals;
}
