package io.pragra.learning.july2024aop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoles { //authorization
    private Long roleId;
    private String role;
    private String roleDesc;

}
