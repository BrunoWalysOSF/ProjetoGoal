package digital.osf.hackazillians.dto;

import lombok.Builder;
import lombok.Data;


@Builder(toBuilder = true)
@Data
public class UserDto {

   private int id;
   private String name;
   private String email;
   private String password;
   private String userName;

}
