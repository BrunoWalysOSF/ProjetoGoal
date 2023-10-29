package digital.osf.hackazillians.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class LoginDto {

    @NonNull
    private String username;
    @NonNull
    private String password;
}
