package com.Rest.Rest.repository;

import com.Rest.Rest.models.Profile;
import com.Rest.Rest.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  //Crea objeto con la interface
public interface ProfileRepository extends JpaRepository <Profile, Integer> {
}
