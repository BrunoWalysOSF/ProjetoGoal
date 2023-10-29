package digital.osf.hackazillians.controller;

import digital.osf.hackazillians.dto.AssessmentDto;
import digital.osf.hackazillians.entities.Assessment;
import digital.osf.hackazillians.handler.UserInterceptor;
import digital.osf.hackazillians.service.AssessmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assessment")
@AllArgsConstructor
public class AssessmentController {

    @Autowired
    private final AssessmentService service;

    private final UserInterceptor user;

    @GetMapping
    public AssessmentDto getAssessment(){
        return service.findAssessmentByUserId(user.getUserId());
    }

}
