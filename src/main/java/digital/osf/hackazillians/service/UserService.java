package digital.osf.hackazillians.service;

import digital.osf.hackazillians.dto.UserDto;
import digital.osf.hackazillians.entities.User;
import digital.osf.hackazillians.mapper.UserMapper;
import digital.osf.hackazillians.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper userMapper;

    public User createUser(UserDto user) {
        User entity = userMapper.toEntity(user);
        return repository.save(entity);
    }
}
