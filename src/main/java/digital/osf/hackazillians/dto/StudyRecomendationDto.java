package digital.osf.hackazillians.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import digital.osf.hackazillians.entities.StudyRecomendation;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link StudyRecomendation}
 */
@Builder
@Data
public class StudyRecomendationDto implements Serializable {

    private Integer id;
    private TypeStudyRecomendationDto typeId;
    private String description;
    @JsonIgnore
    private AchieveGoalDto achieveId;

}