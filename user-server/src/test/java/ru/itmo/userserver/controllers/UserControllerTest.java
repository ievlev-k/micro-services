package ru.itmo.userserver.controllers;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import ru.itmo.userserver.UserServerApplicationTests;
import ru.itmo.userserver.contriller.UserController;
import ru.itmo.userserver.dto.request.UserRequest;
import ru.itmo.userserver.dto.response.UserResponse;
import ru.itmo.userserver.dto.update.UserUpdate;
import ru.itmo.userserver.exeptions.ObjectNotFoundException;
import ru.itmo.userserver.util.enums.Role;
import ru.itmo.userserver.util.enums.UserStatus;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserControllerTest extends UserServerApplicationTests {
    private final UserController userController;

    @Autowired
    public UserControllerTest(UserController userController) {
        this.userController = userController;
    }

    @Test
    void addUserTest(){
        List<UserResponse> userResponseList = userController.getAllUsers();
        int size = userResponseList.size();
        UserRequest userRequest = new UserRequest();
        userRequest.setFirstName("Name");
        userRequest.setLastName("Ievlev");
        userRequest.setUsername("kupuk");
        userRequest.setEmail("1123@mail.ru");
        userRequest.setPassword("password");
        userRequest.setRoom(123L);
        userRequest.setPhone("89635583634");
        userRequest.setSocialMedia("vk.com/duc");
        userRequest.setRoleId(2);
        userRequest.setStatus(UserStatus.ACTIVE);
//        userRequest.setRoleId();

        userController.addUser(userRequest);

        Assert.assertEquals(size + 1, userController.getAllUsers().size());
    }

    @Test
    void addNullUserTest(){
        UserRequest userRequest = new UserRequest();
        Assert.assertThrows(IllegalArgumentException.class,()-> userController.addUser(userRequest));

    }

    @Test
    void getListUserTest(){
        List<UserResponse> userResponseList = userController.getAllUsers();
//        Assert.assertEquals(userResponseList.size(), 31);
        Assert.assertTrue(userResponseList.size() ==  0);
    }


    @Test
    void updateUserActiveTest(){


        UserUpdate userUpdate = new UserUpdate();
        userUpdate.setId(4L);
        userUpdate.setUsername("kupuk");

        userUpdate.setRoleId(2);
        userUpdate.setPassword("password");

        userUpdate.setStatus(UserStatus.ACTIVE);
        userController.updateUser(userUpdate);

        userController.updateUser(userUpdate);

        UserResponse userResponse = userController.getUserById(4L);

        Assert.assertEquals(userResponse.getUsername(), "kupuk");
        Assert.assertEquals(userResponse.getRole().getRole(), Role.USER);
        Assert.assertEquals(userResponse.getUserStatus(), UserStatus.ACTIVE);

    }

    @Test
    void updateUserInactiveTest(){


        UserUpdate userUpdate = new UserUpdate();
        userUpdate.setId(4L);
        userUpdate.setUsername("kupuk");

        userUpdate.setRoleId(1);
        userUpdate.setPassword("password");

        userUpdate.setStatus(UserStatus.INACTIVE);
        userController.updateUser(userUpdate);

        userController.updateUser(userUpdate);

        UserResponse userResponse = userController.getUserById(4L);

        Assert.assertEquals(userResponse.getUsername(), "kupuk");
        Assert.assertEquals(userResponse.getRole().getRole(), Role.ADMIN);
        Assert.assertEquals(userResponse.getUserStatus(), UserStatus.INACTIVE);
    }

    @Test
    void getPageUserTest(){
        Pageable sourcePageable = mock(Pageable.class);
        when(sourcePageable.getPageNumber()).thenReturn(1);
        when(sourcePageable.getPageSize()).thenReturn(2);


        Page<UserResponse> usertResponsePage = userController.getAllUsers(sourcePageable);

        Assert.assertTrue(usertResponsePage.getTotalPages() > 0);
        Assert.assertFalse(usertResponsePage.isEmpty());
    }

    @Test
    void getUserByIdTest(){

        Assert.assertThrows(ObjectNotFoundException.class,()-> userController.getUserById(1000L));
    }
    @Test
    void deleteUserTest(){

        List<UserResponse> userResponseList = userController.getAllUsers();
        int size = userResponseList.size();
        userController.deleteUser(3L);
        UserResponse userResponse = userController.getUserById(3L);
        Assert.assertEquals(size, userController.getAllUsers().size());
        Assert.assertEquals(userResponse.getUserStatus(), UserStatus.INACTIVE);

    }
}
