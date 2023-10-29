package digital.osf.hackazillians.dto;

import digital.osf.hackazillians.entities.LasteAvaliation;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link LasteAvaliation}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LasteAvaliationDto implements Serializable {
    int id;
    String nota;
}