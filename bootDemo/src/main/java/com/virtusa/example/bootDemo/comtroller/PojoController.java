package com.virtusa.example.bootDemo.comtroller;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.virtusa.example.bootDemo.model.PojoModel;
import com.virtusa.example.bootDemo.service.Pojoservice;
@RestController
@RequestMapping("/employees")
public class PojoController
{
    @Autowired
   Pojoservice service;
 
    @GetMapping
    public ResponseEntity<List<PojoModel>> getAllEmployees() {
        List<PojoModel> list = service.getAllEmployees();
 
        return new ResponseEntity<List<PojoModel>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<PojoModel> getEmployeeById(@PathVariable("id") Long id) 
                                                   {
    	PojoModel entity = service.getEmployeeById(id);
 
        return new ResponseEntity<PojoModel>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<PojoModel> createOrUpdateEmployee(PojoModel employee)
                                                    {
    	PojoModel updated = service.createOrUpdateEmployee(employee);
        return new ResponseEntity<PojoModel>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) 
                                                     {
        service.deleteEmployeeById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}