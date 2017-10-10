package com.pravin.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pravin
 */

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }



}
