 
package com.virtusa.example.bootDemo.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.example.bootDemo.repository.PojoModelRepository;
import com.virtusa.example.bootDemo.model.PojoModel;
 
@Service
public class Pojoservice {
     
    @Autowired
    PojoModelRepository repository;
     
    public List<PojoModel> getAllEmployees()
    {
        List<PojoModel> employeeList = repository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<PojoModel>();
        }
    }
     
    public PojoModel getEmployeeById(Long id)  
    {
        Optional<PojoModel> employee = repository.findById(id);
            return employee.get();
    }
     
    public PojoModel createOrUpdateEmployee(PojoModel entity) 
    {
        Optional<PojoModel> employee = repository.findById(entity.getId());
         
        if(employee.isPresent()) 
        {
        	PojoModel newEntity = employee.get();
            newEntity.setEmail(entity.getEmail());
            newEntity.setId(entity.getId());
            newEntity.setName(entity.getName());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    } 
     
    public void deleteEmployeeById(Long id) 
    {
        Optional<PojoModel> employee = repository.findById(id);
       repository.deleteById(id);
       
    } 
}