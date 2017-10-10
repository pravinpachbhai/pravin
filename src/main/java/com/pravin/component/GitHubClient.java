package com.pravin.component;

import com.pravin.domain.GitHubUser;
import com.pravin.domain.GitHubUserFollower;
import com.pravin.domain.GitHubUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by pravin on 10/9/17.
 */
@Component
public class GitHubClient {

    private static final int UP_TO_5_FOLLOWERS = 5;
    @Autowired
    private RestTemplate restTemplate;

    public GitHubUserResponse getHubUserFollowers(String gitHubId ){

        GitHubUserResponse response = new GitHubUserResponse();
        response.setLogin(gitHubId);

        List<GitHubUser> tempList = getFollowers( gitHubId);
        response.setFollowers(buildGitHubUserFollower(tempList));

        response.getFollowers().stream().filter(person -> person.getFollowers().size() < 5).forEach(p->
                addFollowers(getFollowers(p.getLogin()), p)

        );
        return response;
    }

    public  void addFollowers(List<GitHubUser> user, GitHubUserFollower follower){
        follower.setFollowers(buildGitHubUserFollower(user));
    }

    public  List<GitHubUser> getFollowers(String gitHubId){
        String gitHubUrl = "https://api.github.com/users/"+gitHubId+"/followers";
        GitHubUser[] response = restTemplate.getForObject(gitHubUrl, GitHubUser[].class);
        return Stream.of(response).limit(UP_TO_5_FOLLOWERS).collect(Collectors.toList());
    }

    public  List<GitHubUserFollower> buildGitHubUserFollower(List<GitHubUser> tempList){
        List<GitHubUserFollower> followers = new ArrayList<GitHubUserFollower>();
        for ( GitHubUser gitHubUser: tempList){
            GitHubUserFollower f =new GitHubUserFollower();
            f.setLogin(gitHubUser.getLogin());
            followers.add(f);
        }
        return followers;
    }
}
