package com.module2.layersMVC.Controller;


import com.module2.layersMVC.dto.EmployeeDto;
import com.module2.layersMVC.entity.EmployeeEntity;
//import com.module2.layersMVC.repository.EmployeeRepo;
import com.module2.layersMVC.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping (path = "/employees")
public class EmployeeController {
//    @GetMapping(path = "/getSecretMessage")
//    public String getMySuperSecretMessage(){
//
//        return "Secret message: asdfal@#DASDJNJ";
//    }

  public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path= "/{employeeId}")
    public EmployeeDto getEmployeeById(@PathVariable(name ="employeeId" ) Long id){
        return employeeService.getEmployeeById(id);
        // return new EmployeeDto(id,"Monu","monu@gmail.com",20,LocalDate.of(2023,8,21 ),true);
    }

    @GetMapping
 //   public String
   public List<EmployeeDto> getAllEmployeed(@RequestParam (required = false)Integer age,
                                               @RequestParam (required = false)String name){
        return employeeService.getAlltheEmploye();
    }

    @PostMapping

//    public String postmap(){
//
//        return "hii from post  ";
//
//    }

    public EmployeeDto createNewEmployee(@RequestBody EmployeeDto inputEmployee){
        return employeeService.createNewEmployee(inputEmployee);
    }

    @PutMapping
    public String updateEmployeeId(){

        return "employee id update successful by put ";

    }

    @DeleteMapping
    public String deleteEmployee(){

        return "employee deleted successful by delete  ";

    }

    @PatchMapping
    public String patchEmployee(){

        return "message by patch ";

    }

//@RequestBody
}
