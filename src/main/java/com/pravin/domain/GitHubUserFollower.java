package com.pravin.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by pravin
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubUserFollower implements Serializable {
    private static final long serialVersionUID = 1L;

    private String login;

    private List<GitHubUserFollower> followers = new ArrayList<GitHubUserFollower>();


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public List<GitHubUserFollower> getFollowers() {
        return followers;
    }

    public void setFollowers(List<GitHubUserFollower> followers) {
        this.followers = followers;
    }

    public void addFollower(GitHubUserFollower follower){
        this.getFollowers().add(follower);

    }
}
