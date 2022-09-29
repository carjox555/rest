package com.Rest.Rest.controler;

import com.Rest.Rest.models.Employee;
import com.Rest.Rest.models.UserResponse;
import com.Rest.Rest.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller            //Trabajar con Json   @Controler -> espera con q se va a responder
public class EmployeControler {

    @Autowired
    private EmployeService employeService;

    @GetMapping("/employes")
    //Responde con un Json
    public ResponseEntity<List<Employee>>getEmployes(){
        return new ResponseEntity<List<Employee>>(
                employeService.getEmploye(),
                HttpStatus.OK
        );
    }
<<<<<<< HEAD
/*
    @GetMapping("/usuario/{id}")
    public ResponseEntity<Object>getUsuario(@PathVariable String id){
=======

    @GetMapping("/employe/{id}")
    public ResponseEntity<Object>getEmployeId(@PathVariable Integer id){
>>>>>>> 29f095e7e6c5b6f922db97e08a102b6f7ccb8135

        try {
            Employee  employee = employeService.getEmploye(id);
            return new ResponseEntity<>(employee,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/employe")
    public ResponseEntity<Object>getEmploye(@RequestParam Integer id){
        try {
            Employee  employee = employeService.getEmploye(id);
            return new ResponseEntity<>(employee,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/employe")  //Objeto Response
    public ResponseEntity<UserResponse>postEmploye(@RequestBody Employee employee){  //RequestBody -> espera un Json  asociado a usuario
    return new ResponseEntity<>(
            new UserResponse("Employe creado Exitosamente",
                    employeService.saveEmployee(employee))
                    ,HttpStatus.OK);
    }

    @PutMapping("/employe")
    public ResponseEntity<UserResponse>putUEmploye(@RequestBody Employee employee){
        return  new ResponseEntity<>(
                new UserResponse("Employe Actualizado",employeService.putEmployee(employee)),HttpStatus.OK);

    }

    @PatchMapping("/employe/{id}")
    public ResponseEntity<UserResponse>patchEmploye(@RequestBody Employee employee,@PathVariable Integer id ){
        try {
            return  new ResponseEntity<>(
                    new UserResponse("Actualizacion Exitosa",employeService.patchEmploye(employee,  id)),
                    HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(
                    new UserResponse(e.getMessage(),null),
                            HttpStatus.OK);
        }

    }

    @DeleteMapping("/employe/{id}")
    public ResponseEntity<UserResponse>delete(@PathVariable Integer id){
        return  new ResponseEntity<>(

                new UserResponse(employeService.delete(id),null),
                HttpStatus.OK);

    }

 */
}
