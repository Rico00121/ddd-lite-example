package com.example.frontend.rest;

import com.example.frontend.service.AuthorizeApplicationService;
import com.example.frontend.usecase.GetUserProfileCase;
import com.example.frontend.usecase.LoginCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/authorizes")
public class AuthorizeController {
    @Autowired
    private AuthorizeApplicationService authorizeApplicationService;

    @PostMapping
    @ResponseStatus(CREATED)
    public LoginCase.Response login(@RequestBody LoginCase.Request request) {
        return authorizeApplicationService.login(request);
    }

    @DeleteMapping
    public void logout() {
        authorizeApplicationService.logout();
    }

    @GetMapping("/me")
    public GetUserProfileCase.Response getMyProfile() {
        return authorizeApplicationService.getProfile();
    }
}
