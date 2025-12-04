package com.module2.layersMVC.service;


import com.module2.layersMVC.dto.EmployeeDto;
import com.module2.layersMVC.entity.EmployeeEntity;
import com.module2.layersMVC.repository.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

      private final ModelMapper modelMapper;
    private final EmployeeRepo employeeRepo;

    public EmployeeService(ModelMapper modelMapper, EmployeeRepo employeeRepo) {
        this.modelMapper = modelMapper;
        this.employeeRepo = employeeRepo;
    }

    public EmployeeDto getEmployeeById(Long id) {
 EmployeeEntity employeeEntity= employeeRepo.findById(id).orElse(null);

        return modelMapper.map(employeeEntity,EmployeeDto.class);
    }

    public List<EmployeeDto> getAlltheEmploye() {
        List<EmployeeEntity> employeeEntities= employeeRepo.findAll();

       return employeeEntities
               .stream()
               .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDto.class))
               .collect(Collectors.toList());

    }

    public EmployeeDto createNewEmployee(EmployeeDto inputEmployee) {
       EmployeeEntity toSaveEntity = modelMapper.map(inputEmployee,EmployeeEntity.class);
       EmployeeEntity savedEmployeeEntity=employeeRepo.save(toSaveEntity);
       return modelMapper.map(savedEmployeeEntity,EmployeeDto.class);
    }
}

