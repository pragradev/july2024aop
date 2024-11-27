package io.pragra.learning.july2024aop.api;

import io.pragra.learning.july2024aop.entity.UserRoles;
import io.pragra.learning.july2024aop.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("usermanagement")
@Slf4j
public class UserManagement {
    Logger logger = LoggerFactory.getLogger(UserManagement.class);

    @Autowired
    UserRoleService roleService;
    @PostMapping("/create")
    public UserRoles addUserRoles(UserRoles userRoles){
        logger.info(Instant.now() + " Class: UserManagement Method: addUserRoles started exection with parameter " + userRoles);
        //secondary logic or cross cutting concerns
        //Info 2024/11/27 6:25:001 AM UserManagement addUserRoles started execution with parameter []
        //Info 2024/11/27 6:25:002 AM UserRoleService addRoleService started execution with parameter[]
        //Info 2024/11/27 6:25:004 AM UserRoleService addRoleService finished execution with return [null]
        //Error 2024/11/27 6:25:007 AM Error: exception xnsdjkcnkvjnvjkfd

        // logging -> Splunk, data dog, dynatrace,
        //insert roles - superUser
        roleService.addRoleService(userRoles); //primary logics
        System.out.println(userRoles);
        UserRoles userRoles1 = new UserRoles();
        logger.info(Instant.now() + " Class: UserManagement Method: addUserRoles finished exection with return " + userRoles1);        //secondary logic or cross cutting concerns


        return userRoles1;
    }
}
