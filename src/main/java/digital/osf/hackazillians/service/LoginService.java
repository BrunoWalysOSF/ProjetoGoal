package digital.osf.hackazillians.service;

import digital.osf.hackazillians.dto.LoginDto;
import digital.osf.hackazillians.dto.UserDto;

public interface LoginService {

    UserDto login(LoginDto loginDto);
}
