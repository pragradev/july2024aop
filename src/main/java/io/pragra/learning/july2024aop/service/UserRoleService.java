package io.pragra.learning.july2024aop.service;

import io.pragra.learning.july2024aop.api.UserManagement;
import io.pragra.learning.july2024aop.entity.UserRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UserRoleService {
    Logger logger = LoggerFactory.getLogger(UserRoleService.class);

    public UserRoles addRoleService(UserRoles userRoles) {
        logger.info(Instant.now() + " Class: UserRoleService Method: addRoleService started exection with parameter " + userRoles);
        //
        // inserting roles
        logger.info(Instant.now() + " Class: UserRoleService Method: addRoleService finished exection with parameter null");

        return null;
    }
}
