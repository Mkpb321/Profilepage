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
        initialProfile.setName("Mike Burkhard");
        initialProfile.setImage("https://moonvillageassociation.org/wp-content/uploads/2018/06/default-profile-picture1.jpg");
        initialProfile.setDescription("Ich arbeite zurzeit als Software Ingenieur im firmenübergreifenden Trainee-Programm der M&F Engineering AG (mehr Details unter m-f.ch/software-trainee-programm). Das Ziel dieses Programms ist es, junge motivierte Software Ingenieure wie mich und innovative Technologie-Firmen wie Sie zusammen zu bringen. Als Trainee habe ich die Möglichkeit, in 3 Jahren drei bis fünf Einsätze bei verschiedenen Partnerfirmen zu absolvieren und jeweils 6-12 Monate bei einer Partnerfirma im Software-Team vor Ort mitzuarbeiten.");
        initialProfile.setLink("https://www.m-f.ch/software-trainee-programm");
        repository.save(initialProfile);
    }
}
