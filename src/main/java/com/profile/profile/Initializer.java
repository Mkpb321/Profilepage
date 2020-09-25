package com.profile.profile;

import com.profile.profile.model.Profile;
import com.profile.profile.model.ProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class Initializer implements CommandLineRunner {

    private final ProfileRepository repository;

    public Initializer(ProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        Profile initialProfile = new Profile();
        initialProfile.setId(1L);
        initialProfile.setName("Max");
        initialProfile.setImage("https://moonvillageassociation.org/wp-content/uploads/2018/06/default-profile-picture1.jpg");
        initialProfile.setDescription("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.");
        initialProfile.setLink("https://www.google.ch/");
        repository.save(initialProfile);
        repository.findAll().forEach(System.out::println);
    }
}
