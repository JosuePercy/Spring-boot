package com.fundamentos.springboot.fundamentos.caseuse;

import com.fundamentos.springboot.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DeletUser {

    private final UserService userService;
    public DeletUser(UserService userService) {
        this.userService = userService;
    }
    public void remove(Long id) {
        userService.delete(id);
    }
}
