package com.pravin.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pravin.domain.GitHubUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.pravin.component.ControllerHelper;
import com.pravin.services.UserService;

/**
 * @author Pravin Pachbhai
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ControllerHelper controllerHelper;

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    GitHubUserResponse getFollowers(@PathVariable("id")
                 final String userId, final HttpServletResponse response,
                 final HttpServletRequest request) {
        if (userId == null) {
            controllerHelper.handleMessage(response, HttpServletResponse.SC_BAD_REQUEST,
                    "Bad request, Please provide userId.");
            return null;
        }
        GitHubUserResponse followers = userService.getFollowers(userId);
        if (followers == null) {
            controllerHelper.handleMessage(response, HttpServletResponse.SC_NO_CONTENT, "Git hub user is not found.");
        }
        return followers;
    }

}
