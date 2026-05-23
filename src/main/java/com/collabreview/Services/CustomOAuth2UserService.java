package com.collabreview.Services;

import com.collabreview.Entity.User;
import com.collabreview.Repository.UserRepository;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Map;

public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    private final UserRepository userRepository;

    public CustomOAuth2UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
    }

    public OAuth2User loadUser(OAuth2UserRequest userRequest){
        OAuth2User oauthUser = super.loadUser(userRequest);

        Map<String, Object> attributes = oauthUser.getAttributes();

        String githubId = String.valueOf(attributes.get("id"));

        OAuth2AccessToken accessToken = userRequest.getAccessToken();

        User user = userRepository.findByGithubId(githubId).orElseGet(User::new);
        user.setGithubId(githubId);
        user.setUsername((String) attributes.get("name"));
        user.setAvatarUrl((String) attributes.get("avatar_url"));
        user.setEmail((String) attributes.get("email"));
        user.setAccessToken(accessToken.getTokenValue());

        userRepository.save(user);
        return oauthUser;
    }
}
