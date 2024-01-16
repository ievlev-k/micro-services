package ru.itmo.userserver.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import ru.itmo.userserver.dto.request.UserRequest;
import ru.itmo.userserver.dto.response.UserResponse;
import ru.itmo.userserver.dto.update.UserUpdate;
import ru.itmo.userserver.exeptions.ObjectNotFoundException;
import ru.itmo.userserver.mapper.UserMapper;
import ru.itmo.userserver.model.User;
import ru.itmo.userserver.repository.UserRepository;
import ru.itmo.userserver.service.UserService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder encoder;

    @Override
    public Flux<UserResponse> getAllPage(Pageable pageable) {
        return Flux.just(userRepository.findAll(pageable))
                .subscribeOn(Schedulers.boundedElastic())
                .flatMap(Flux::fromIterable)
                .map(userMapper::userToUserResponse);
    }

    @Override
    public Flux<UserResponse> getAllList() {

        return Mono.fromCallable(userRepository::findAll)
                .subscribeOn(Schedulers.boundedElastic())
                .flux()
                .flatMap(Flux::fromIterable)
                .map(userMapper::userToUserResponse);



//        return userMapper.userToUserResponseList(userRepository.findAll());
    }

    @Override
    public Mono<UserResponse> findById(Long id) {
        return Mono.fromCallable(() -> userRepository.findById(id))
                .subscribeOn(Schedulers.boundedElastic())
                .map(Optional::get)
                .map(userMapper::userToUserResponse)
                .switchIfEmpty(Mono.error(new ObjectNotFoundException("User not found")));
    }
//
//    @Override
    public Mono<Void> update(Mono<UserUpdate> userUpdate) {
        return userUpdate.flatMap(userUpdate1 ->
                Mono.fromCallable(()-> userRepository.save(userMapper.userUpdateToUser(userUpdate1))))
                .subscribeOn(Schedulers.boundedElastic())
                .then();
//        User user = userMapper.userUpdateToUser(userUpdate);
//        user.setPassword(encoder.encode(user.getPassword()));
//        userRepository.save(userMapper.userUpdateToUser(userUpdate));
    }
//
    @Override
    public Mono<Void> save(Mono<UserRequest> userRequest) {


        return userRequest.flatMap(userRequest1 ->
                Mono.fromCallable(()->userRepository.save(userMapper.userRequestToUser(userRequest1))))
                .subscribeOn(Schedulers.boundedElastic()).then();
//        User user = userMapper.userRequestToUser(userRequest);
//        user.setPassword(encoder.encode(user.getPassword()));
//        userRepository.save(user);
    }
//
    @Override
    public Mono<Void> deleteById(Long id) {

        return Mono.fromCallable(() -> userRepository.findById(id))
                .subscribeOn(Schedulers.boundedElastic())
                .switchIfEmpty(Mono.error(new ObjectNotFoundException("cannot delete user")))
                .then(Mono.fromRunnable(() -> userRepository.deleteById(id))).
                subscribeOn(Schedulers.boundedElastic()).then();

    }

//
//    @Override
//    public boolean userById(Long id){
//        try {
//            User user = userRepository.findById(id)
//                    .orElseThrow(() -> new ObjectNotFoundException("User with id " + id + " not found"));
//            if(user != null){
//                return true;
//            }
//        }catch (ObjectNotFoundException objectNotFoundException){
//            System.out.println("User with id " + id + " not found");
//            return false;
//        }
//
//        return false;
//
//    }
//    @Override
//    public User findByUsername(String username){
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new ObjectNotFoundException("User with username " + username + " not found"));
//        return user;
//    }

}
