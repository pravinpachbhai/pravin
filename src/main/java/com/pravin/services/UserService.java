package com.pravin.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.pravin.component.GitHubClient;
import com.pravin.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Pravin Pachbhai
 */

@Service
public class UserService {

    @Autowired
    private GitHubClient gitHubClient;


    public GitHubUserResponse getFollowers(String userId) {
        return gitHubClient.getHubUserFollowers(userId);
    }
}
