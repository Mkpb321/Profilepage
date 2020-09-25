package com.profile.profile.web;

import com.profile.profile.model.Profile;
import com.profile.profile.model.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RequestMapping(value = "/api/profile")
@RestController
public class ProfileRestController {

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping(value = {"/{id}"})
    public Optional<Profile> get(@PathVariable(value="id") Long id, HttpServletResponse response) throws IOException {
        if (id != 1L) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        return profileRepository.findById(id);
    }

    @PutMapping(value = "/{id}")
    public Optional<Profile> edit(@PathVariable(value="id") Long id, @RequestBody Profile newProfile, HttpServletResponse response) throws IOException {
        if (id != 1L) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
        if (newProfile.getName() != null && newProfile.getName().length() > 16) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
        newProfile.setId(id);
        Optional<Profile> profile = Optional.of(profileRepository.save(newProfile));
        return profile;
    }
}
