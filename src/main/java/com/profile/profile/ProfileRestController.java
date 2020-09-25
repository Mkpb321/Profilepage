package com.profile.profile;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RequestMapping(value = "/api/profile")
@RestController
public class ProfileRestController {

    public String name = "Max";
    public String image = "https://moonvillageassociation.org/wp-content/uploads/2018/06/default-profile-picture1.jpg";
    public String description = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet";
    public String link = "https://www.google.ch/";

    private Profile profile = new Profile(name, image, description, link);

    @GetMapping(value = {"", "/edit"})
    public Profile get() {
        return profile;
    }

    @PutMapping(value = "")
    public Profile add(@RequestBody Profile newProfile, HttpServletResponse response) {
        if (newProfile.name == null || newProfile.name.length() <= 16) {
            profile = newProfile;
        }
        else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return profile;
    }
}
