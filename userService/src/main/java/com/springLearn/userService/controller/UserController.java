package com.springLearn.userService.controller;

import com.springLearn.userService.Vo.Department;
import com.springLearn.userService.Vo.ResponseTemplateVo;
import com.springLearn.userService.entity.User;
import com.springLearn.userService.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@CircuitBreaker(name = "departmentBreaker",fallbackMethod = "departmentServiceFallBackMethod")
@Slf4j
public class UserController{

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){

        return userService.saveUser(user);
    }
    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long userId){
        return userService.getUserById(userId);
    }

    @GetMapping("/getuserdepartment/{id}")
    public ResponseTemplateVo findUserWithDeparment(@PathVariable("id") Long userId){

        return userService.findUserWithDepartment(userId);
    }

    //fallback method for circuitBreaker
    public ResponseTemplateVo departmentServiceFallBackMethod(Long useriId,Exception e){

        User user=User.builder()
                .firstName("dummy")
                .lastName("jha")
                .departmentId(100L)
                .email("dummyemail@gmail.com")
                .userId(100L)
                .build();
        Department department = Department.builder()
                .departmentAddress("smshaam ghaat")
                .departmentCode("dummycode")
                .departmentId(100L)
                .departmentName("fullMauj")
                .build();
        log.info("fallback Mathod called because service down");
        ResponseTemplateVo responseTemplateVo = new ResponseTemplateVo();
        responseTemplateVo.setUser(user);
        responseTemplateVo.setDepartment(department);
        return responseTemplateVo;
    }
}
