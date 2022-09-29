package com.Rest.Rest.services;

import com.Rest.Rest.models.Profile;
import com.Rest.Rest.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service              //Objeto para registrar en el beans
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> getProfile(){
        return profileRepository.findAll();
    }
    public Profile getProfile(Integer id) throws Exception {
        Optional<Profile> profileOptional =profileRepository.findById(id);
        if(profileOptional.isPresent()){
            return profileOptional.get();
        }else{
            throw new Exception("Perfil no Existe");
        }
    }
    public Profile saveProfile(Profile profile_param){
        return profileRepository.save(profile_param);
    }

    public Profile putProfile(Profile profile_param){
        return  profileRepository.save(profile_param);
    }

    public Profile patchProfile(Profile profile_param, Integer id ) throws Exception{
        try {
            Profile profileBd =getProfile(id);
            //Valida si existe el Profile que traiga los atributos y actualiza
            if(profile_param.getNombre()!=null){
                profileBd.setNombre(profile_param.getNombre());
            } if(profile_param.getPhone()!=null){
                profileBd.setPhone(profile_param.getPhone());
            }
            return saveProfile(profileBd);

        } catch (Exception e) {
            throw new Exception("Profile no se actualizo porq no existe");
        }
    }

    public String delete(Integer id){
        profileRepository.deleteById(id);
        return "Profile Eliminado";
    }
}

