package com.Adarsh.JournalAppnew.service;

import com.Adarsh.JournalAppnew.entity.User;
import com.Adarsh.JournalAppnew.repository.UserRepository;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@SpringBootTest
public class UserDetailsServiceImplTests  {
    @Autowired   //inject mock or dependency on below service and also create its instance
    private UserDetailsServiceImpl userDetailsService;

    @MockitoBean
    private UserRepository userRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Disabled
    @Test
    void loadUserByUsernameTest(){
        // when the method loadUserByUsername run the actual repository is not called
        // mock will be called and we got the userdetails object
        when(userRepository
                .findByUserName(ArgumentMatchers.anyString()))
                .thenReturn(User.builder().userName(("manoj")).password("fgyuwrfy").roles(new ArrayList<>()).build());

        UserDetails user =  userDetailsService.loadUserByUsername("manoj");
        assertNotNull(user);
    }
}

