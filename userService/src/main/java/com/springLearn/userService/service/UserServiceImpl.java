package com.springLearn.userService.service;

import com.springLearn.userService.Vo.Department;
import com.springLearn.userService.Vo.ResponseTemplateVo;
import com.springLearn.userService.entity.User;
import com.springLearn.userService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public ResponseTemplateVo findUserWithDepartment(Long userid) {

        ResponseTemplateVo vo=new ResponseTemplateVo();
        User user = userRepository.findById(userid).get();

        Department department = restTemplate.getForObject("http://DEPARTMENTSERVICE/department/" + user.getDepartmentId(),Department.class);

        vo.setDepartment(department);
        vo.setUser(user);
        return vo;
    }
}
