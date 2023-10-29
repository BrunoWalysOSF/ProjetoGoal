package digital.osf.hackazillians.controller;

import digital.osf.hackazillians.dto.GoalAchieveDto;
import digital.osf.hackazillians.dto.GoalCretedDTO;
import digital.osf.hackazillians.dto.GoalDto;
import digital.osf.hackazillians.dto.chat.CreateGoalDto;
import digital.osf.hackazillians.entities.Goal;
import digital.osf.hackazillians.handler.UserInterceptor;
import digital.osf.hackazillians.service.AchieveGoalService;
import digital.osf.hackazillians.service.GoalService;
import lombok.AllArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/goals")
@AllArgsConstructor
public class GoalController {

    private final GoalService goalService;
    private final AchieveGoalService achieveService;
    private final UserInterceptor user;


    @GetMapping
    public List<GoalCretedDTO> getGoals(){
        return this.goalService.getGoalById(user.getUserId());
    }

    @PostMapping("/achieve")
    public ResponseEntity<?> findAchievesByGoals(@RequestBody GoalAchieveDto goalAchieveDto) {
         return ResponseEntity.ok(achieveService.findAchievesByGoals(goalAchieveDto, user.getUserId()));
    }

    @PostMapping
    public ResponseEntity<?> createGoal(@RequestBody CreateGoalDto goalDto){
        return ResponseEntity.ok(goalService.createOrUpdateGoal(goalDto.getGoals()));

    }

    @PutMapping
    public ResponseEntity<?> updateGoal(@RequestBody GoalDto goalDto){
        return ResponseEntity.ok(goalService.updateGoal(goalDto));
    }

}
