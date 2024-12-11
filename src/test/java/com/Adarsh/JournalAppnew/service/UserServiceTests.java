package com.Adarsh.JournalAppnew.service;

import com.Adarsh.JournalAppnew.entity.User;
import com.Adarsh.JournalAppnew.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest //to tell system for starting applicat-n context to do main component test
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    //casual test and assert means in hindi- dawa karna
//    @Test
//    public void testAdd(){
//        assertEquals(4,3+1);
//    }

    @ParameterizedTest
    @ArgumentsSource(UserArgumentProvider.class)
    public void testSaveNewUser(User user){
        assertTrue(userService.saveNewUser(user));
    }

//    @ParameterizedTest
//    @ValueSource(strings={//for a paticular type of parameter
//            "ram",
//            "manoj",
//            "vipul"
//    })
//    public void testFindByUserName(String name){
//        assertNotNull(userRepository.findByUserName(name),"faled for "+name);
//    }

    @Disabled
    @ParameterizedTest //to perform parameterized tests
    @CsvSource({//to check for multiple parameterized value
            "1,1,3",
            "2,10,12",
            "3,9,12"
    })
    public void test(int a, int b, int expected){
        assertEquals(expected,a+b);
    }

}
