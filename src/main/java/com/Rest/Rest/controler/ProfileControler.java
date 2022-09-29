package com.Rest.Rest.controler;

import com.Rest.Rest.models.UserResponse;
import com.Rest.Rest.models.Profile;
import com.Rest.Rest.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller            //Trabajar con Json   @Controler -> espera con q se va a responder
public class ProfileControler {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/profiles")
    //Responde con un Json
    public ResponseEntity<List<Profile>>getProfile(){
        return new ResponseEntity<List<Profile>>(
                profileService.getProfile(),
                HttpStatus.OK
        );
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<Object>getProfile(@PathVariable Integer id){

        try {
            Profile  profile = profileService.getProfile(id);
            return new ResponseEntity<>(profile,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/profile")
    public ResponseEntity<Object>getProfiles(@RequestParam Integer id){
        try {
            Profile  profile = profileService.getProfile(id);
            return new ResponseEntity<>(profile,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/profile")  //Objeto Response
    public ResponseEntity<UserResponse>postProfile(@RequestBody Profile profile){  //RequestBody -> espera un Json  asociado a Profile
    return new ResponseEntity<>(
            new UserResponse("Profile creado Exitosamente",
                    profileService.saveProfile(profile))
                    ,HttpStatus.OK);
    }

    @PutMapping("/profile")
    public ResponseEntity<UserResponse>putProfile(@RequestBody Profile profile){
        return  new ResponseEntity<>(
                new UserResponse("Profile Actualizado",profileService.putProfile(profile)),HttpStatus.OK);

    }

    @PatchMapping("/profile/{id}")
    public ResponseEntity<UserResponse>patchProfile(@RequestBody Profile profile,@PathVariable Integer id ){
        try {
            return  new ResponseEntity<>(
                    new UserResponse("Actualizacion Exitosa",profileService.patchProfile(profile,  id)),
                    HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(
                    new UserResponse(e.getMessage(),null),
                            HttpStatus.OK);
        }

    }

    @DeleteMapping("/profile/{id}")
    public ResponseEntity<UserResponse>delete(@PathVariable Integer id){
        return  new ResponseEntity<>(

                new UserResponse(profileService.delete(id),null),
                HttpStatus.OK);

    }
}
