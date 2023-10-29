package digital.osf.hackazillians.dto;

import digital.osf.hackazillians.constant.TypeQuestion;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
@Getter
@Setter
public class ChatAIDto {


    private TypeQuestion typeQuestion;
    private String question;
    private Integer idUser;
}
