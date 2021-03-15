package com.gym.project.controller;

import com.gym.project.req.RegisterRequest;
import com.gym.project.req.SignUpRequest;
import com.gym.project.res.base.CommonResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/gym/user", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
@RestController
public class GymUserController {

    @RequestMapping("/signin")
    public CommonResponse signin(@RequestBody SignUpRequest signUpRequest) {

        return null;
    }

    /**
     * when customer comes, they have to register to get into the gym
     */
    @RequestMapping("/register")
    public CommonResponse registering(@RequestBody RegisterRequest registerRequest) {

        return null;
    }
}
