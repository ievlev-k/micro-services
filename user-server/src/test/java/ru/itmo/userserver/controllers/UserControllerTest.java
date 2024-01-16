package ru.itmo.userserver.controllers;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import reactor.core.publisher.Mono;
import ru.itmo.userserver.UserServerApplicationTests;
//import ru.itmo.userserver.controller.UserController;
import ru.itmo.userserver.dto.request.UserRequest;
import ru.itmo.userserver.dto.response.UserResponse;
import ru.itmo.userserver.util.enums.UserStatus;

import java.util.List;

import static org.mockito.Mockito.mock;

public class UserControllerTest extends UserServerApplicationTests {

//    private final UserController userController;
//    @Autowired
//    public UserControllerTest(UserController userController) {
//        this.userController = userController;
//    }
//    @Test
//    void addUserTest() throws InterruptedException {
//        List<UserResponse> userResponseList = userController.getAllUsers().collectList().block();
//        int size = userResponseList.size();
//        UserRequest userRequest = new UserRequest();
//        userRequest.setFirstName("Name");
//        userRequest.setLastName("Ievlev");
//        userRequest.setUsername("kupuk");
//        userRequest.setEmail("1123@mail.ru");
//        userRequest.setPassword("password");
//        userRequest.setRoom(123L);
//        userRequest.setPhone("89635583634");
//        userRequest.setSocialMedia("vk.com/duc");
//        userRequest.setRoleId(2);
//        userRequest.setStatus(UserStatus.ACTIVE);
////        userRequest.setRoleId();
//        Mono<UserRequest> userRequestMono = Mono.fromSupplier(() -> userRequest);
//        userController.addUser(userRequestMono);
//        Thread.sleep(1L);
//        Assert.assertEquals(size, userController.getAllUsers().collectList().block().size());
//    }
////
//    @Test
//    void addNullUserTest(){
//        UserRequest userRequest = new UserRequest();
//        Assert.assertThrows(IllegalArgumentException.class,()-> userController.addUser(userRequest));
//
//    }
//
//
//    @Test
//    void updateUserActiveTest(){
//
//
//        UserUpdate userUpdate = new UserUpdate();
//        userUpdate.setId(4L);
//        userUpdate.setUsername("kupuk");
//
//        userUpdate.setRoleId(2);
//        userUpdate.setPassword("password");
//
//        userUpdate.setStatus(UserStatus.ACTIVE);
//        userController.updateUser(userUpdate);
//
//        userController.updateUser(userUpdate);
//
//        UserResponse userResponse = userController.getUserById(4L);
//
//        Assert.assertEquals(userResponse.getUsername(), "kupuk");
//        Assert.assertEquals(userResponse.getRole().getRole(), Role.USER);
//        Assert.assertEquals(userResponse.getUserStatus(), UserStatus.ACTIVE);
//
//    }
//
//    @Test
//    void updateUserInactiveTest(){
//
//
//        UserUpdate userUpdate = new UserUpdate();
//        userUpdate.setId(4L);
//        userUpdate.setUsername("kupuk");
//
//        userUpdate.setRoleId(1);
//        userUpdate.setPassword("password");
//
//        userUpdate.setStatus(UserStatus.INACTIVE);
//        userController.updateUser(userUpdate);
//
//        userController.updateUser(userUpdate);
//
//        UserResponse userResponse = userController.getUserById(4L);
//
//        Assert.assertEquals(userResponse.getUsername(), "kupuk");
//        Assert.assertEquals(userResponse.getRole().getRole(), Role.ADMIN);
//        Assert.assertEquals(userResponse.getUserStatus(), UserStatus.INACTIVE);
//    }
//
//    @Test
//    void getPageUserTest(){
//        Pageable sourcePageable = mock(Pageable.class);
//        when(sourcePageable.getPageNumber()).thenReturn(1);
//        when(sourcePageable.getPageSize()).thenReturn(2);
//
//
//        Page<UserResponse> usertResponsePage = userController.getAllUsers(sourcePageable);
//
//        Assert.assertTrue(usertResponsePage.getTotalPages() > 0);
//        Assert.assertFalse(usertResponsePage.isEmpty());
//    }
//
//    @Test
//    void getUserByIdTest(){
//
//        Assert.assertThrows(ObjectNotFoundException.class,()-> userController.getUserById(1000L));
//    }
//    @Test
//    void deleteUserTest(){
//
//        List<UserResponse> userResponseList = userController.getAllUsers();
//        int size = userResponseList.size();
//        userController.deleteUser(3L);
//        UserResponse userResponse = userController.getUserById(3L);
//        Assert.assertEquals(size, userController.getAllUsers().size());
//        Assert.assertEquals(userResponse.getUserStatus(), UserStatus.INACTIVE);
//
//    }
}
