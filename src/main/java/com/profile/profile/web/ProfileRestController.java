package com.profile.profile.web;

import com.profile.profile.model.Profile;
import com.profile.profile.model.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RequestMapping(value = "/api/profile")
@RestController
public class ProfileRestController {

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping(value = {"/{id}"})
    public Optional<Profile> get(@PathVariable(value = "id") Long id, HttpServletResponse response) throws IOException {
        Optional<Profile> profile = profileRepository.findById(id);
        if (profile.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found");
        }
        return profile;
    }

    @PutMapping(value = "/{id}")
    public Optional<Profile> edit(@PathVariable(value = "id") Long id, @RequestBody Profile newProfile, HttpServletResponse response) {
        Optional<Profile> oldProfile = profileRepository.findById(id);
        if (oldProfile.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Profile not found");
        }
        if (newProfile.getName() != null && newProfile.getName().length() > 16) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name can have a maximum of 16 characters");
        }
        newProfile.setId(id);
        Optional<Profile> profile = Optional.of(profileRepository.save(newProfile));
        return profile;
    }
}
