package digital.osf.hackazillians.controller;

import digital.osf.hackazillians.dto.AchieveGoalDto;
import digital.osf.hackazillians.entities.AchieveGoal;
import digital.osf.hackazillians.service.AchieveGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/achieve-goals")
public class AchieveGoalController {

    @Autowired
    private AchieveGoalService achieveGoalService;

    @PutMapping
    public AchieveGoal updateAchieveGoal(@RequestBody AchieveGoalDto achieveGoal){
        return achieveGoalService.updateAchieveGoal(achieveGoal);
    }

    @PutMapping("/progress")
    public AchieveGoal updateAchieveGoalProgress(@RequestParam("id") Integer id, @RequestParam("progress") Integer progress){
        return achieveGoalService.updateAchieveGoalProgress(id, progress);
    }

}
