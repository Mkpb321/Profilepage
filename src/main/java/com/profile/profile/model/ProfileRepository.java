package com.profile.profile.model;

import com.profile.profile.model.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
    Profile findById(long id);
}
