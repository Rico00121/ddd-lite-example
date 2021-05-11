package com.example.admin.rest;

import com.example.admin.service.UserManagementApplicationService;
import com.example.admin.usecases.GetUserDetailCase;
import com.example.admin.usecases.GetUsersCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/management/users")
public class UserManagementController {
    @Autowired
    private UserManagementApplicationService applicationService;

    @GetMapping
    public List<GetUsersCase.Response> getUsers() {
        return applicationService.getUsers();
    }

    @GetMapping("/{id}")
    public GetUserDetailCase.Response getUserDetail(@PathVariable("id") String id) {
        return applicationService.getUserDetail(id);
    }
}
