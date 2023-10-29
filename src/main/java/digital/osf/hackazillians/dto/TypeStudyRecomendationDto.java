package digital.osf.hackazillians.dto;

import digital.osf.hackazillians.entities.TypeStudyRecomendation;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link TypeStudyRecomendation}
 */
@Builder
@Data
public class TypeStudyRecomendationDto  {

    private Integer id;
    private String type;
}