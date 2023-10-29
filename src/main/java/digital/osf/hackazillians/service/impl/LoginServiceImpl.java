package digital.osf.hackazillians.service.impl;

import digital.osf.hackazillians.dto.LoginDto;
import digital.osf.hackazillians.dto.UserDto;
import digital.osf.hackazillians.entities.User;
import digital.osf.hackazillians.mapper.UserMapper;
import digital.osf.hackazillians.repositories.UserRepository;
import digital.osf.hackazillians.service.LoginService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {


    private final UserRepository userRepository;

    private final UserMapper userMapper;
    @Override
    public UserDto login(LoginDto loginDto) {
        User user = userRepository.findByUserNameAndPassword(loginDto.getUsername(), loginDto.getPassword());
        if (user == null) {
            throw new RuntimeException("Invalid username or password");
        }
        return userMapper.toDto(user);
    }

}
