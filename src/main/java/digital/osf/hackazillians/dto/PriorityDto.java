package digital.osf.hackazillians.dto;

import digital.osf.hackazillians.entities.Priority;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link Priority}
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriorityDto implements Serializable {
    int id;
    String nivel;
}