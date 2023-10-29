package digital.osf.hackazillians.dto;

import digital.osf.hackazillians.entities.Assessment;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Assessment}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssessmentDto implements Serializable {
    int id;
    LasteAvaliationDto lastAvaliation;
    LocalDate nextAssessmentDate;
    UserDto user;
}