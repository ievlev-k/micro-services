package ru.itmo.userserver.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itmo.userserver.dto.request.UserRequest;
import ru.itmo.userserver.dto.response.UserResponse;
import ru.itmo.userserver.dto.update.UserUpdate;
import ru.itmo.userserver.exeptions.ObjectNotFoundException;
import ru.itmo.userserver.mapper.UserMapper;
import ru.itmo.userserver.model.User;
import ru.itmo.userserver.repository.UserRepository;
import ru.itmo.userserver.service.UserService;
import ru.itmo.userserver.util.enums.UserStatus;


import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder encoder;

    @Override
    public Page<UserResponse> getAllPage(Pageable pageable) {
        return userMapper.userToUserResponsePage(userRepository.findAll(pageable));
    }

    @Override
    public List<UserResponse> getAllList() {
        return userMapper.userToUserResponseList(userRepository.findAll());
    }

    @Override
    public UserResponse findById(Long id) {
        return userMapper.userToUserResponse(userRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User with id " + id + " not found")));
    }

    @Override
    public void update(UserUpdate userUpdate) {
        User user = userMapper.userUpdateToUser(userUpdate);
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(userMapper.userUpdateToUser(userUpdate));
    }

    @Override
    public void save(UserRequest userRequest) {
        User user = userMapper.userRequestToUser(userRequest);
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User with id " + id + " not found"));
        user.setStatus(UserStatus.INACTIVE);
        userRepository.save(user);
    }


    @Override
    public boolean userById(Long id){
        try {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new ObjectNotFoundException("User with id " + id + " not found"));
            if(user != null){
                return true;
            }
        }catch (ObjectNotFoundException objectNotFoundException){
            System.out.println("User with id " + id + " not found");
            return false;
        }

        return false;

    }
    @Override
    public User findByUsername(String username){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ObjectNotFoundException("User with username " + username + " not found"));
        return user;
    }

}
