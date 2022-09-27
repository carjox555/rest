package com.Rest.Rest.services;

import com.Rest.Rest.models.Employee;
import com.Rest.Rest.models.Usuario;
import com.Rest.Rest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service              //Objeto para registrar en el beans
public class UserEmploye {

    @Autowired
    private EmployeeRepository EmployeRepository;

    public List<Employee> getEmploye(){
        return EmployeRepository.findAll();
    }
    public Employee getEmploye(Integer id) throws Exception {
        Optional<Employee> employeOptional =EmployeRepository.findById(id);
        if(employeOptional.isPresent()){
            return employeOptional.get();
        }else{
            throw new Exception("Employee no Existe");
        }
    }
    public Employee saveEmployee(Employee employee_param){
        return EmployeRepository.save(employee_param);
    }

    public Employee putEmployee(Employee employee_param){
        return  EmployeRepository.save(employee_param);
    }

    public Employee patchUsuario(Employee employee_param, Integer id ) throws Exception{
        try {
            Employee employeeBd =getEmploye(id);
            //Valida si existe el empleado que traiga los atributos y actualiza
            if(employee_param.getNombre()!=null){
                employeeBd.setNombre(employee_param.getNombre());
            } if(employee_param.getNombre()!=null){
                employeeBd.setNombre(employee_param.getCorreo());
            }
            return saveEmployee(employeeBd);

        } catch (Exception e) {
            throw new Exception("Empleado no se actualizo porq no existe");
        }
    }

    public String delete(Integer id){
        EmployeRepository.deleteById(id);
        return "Empleado Eliminado";
    }
}

