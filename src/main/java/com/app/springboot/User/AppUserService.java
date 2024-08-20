package com.app.springboot.User;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService {

    AppUserRepository appUserRepository;

    public AppUser getUser()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return appUserRepository.findByName(auth.getName());
    }

    public AppUser getUserByGoogleID(String googleID)
    {
        return appUserRepository.findByName(googleID);
    }
    public AppUser save(AppUser user)
    {
        return appUserRepository.save(user);
    }
}
