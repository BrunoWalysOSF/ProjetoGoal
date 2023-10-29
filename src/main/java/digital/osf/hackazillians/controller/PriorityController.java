package digital.osf.hackazillians.controller;

import digital.osf.hackazillians.dto.PriorityDto;
import digital.osf.hackazillians.entities.Priority;
import digital.osf.hackazillians.service.PriorityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/priority")
@RestController
@AllArgsConstructor
public class PriorityController {

    private final PriorityService service;

    @GetMapping
    public List<PriorityDto> getPriority(){
        return service.findAll();
    }
}
