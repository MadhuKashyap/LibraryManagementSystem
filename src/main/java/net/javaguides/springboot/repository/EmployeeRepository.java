package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//JPARepository permits developers to work directly with objects rather than sql statements. It contains basic API for CRUD operations
// e.g.   save(obj) : save the object in jpa
//        saveAll(Iterable<> et) : saves the given entities if they are not null
//        getById(id) : return object of id
//        findAll() : returns all entities
//        findById(id) : same as getbyId but throws no exception
//        count() : return total entities available in table
//        delete(obj) : delete the entity
//        deleteAll() : delete all entities

//we dont need to use @Repository over this class as JpaRepository already annotates it with the implemting class
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
     // now EmployeeRepository can access all crud methods of JpaRepository
    //We need to create some custom exceptions like ResourceNotFoundException in case database is not found etc


}
