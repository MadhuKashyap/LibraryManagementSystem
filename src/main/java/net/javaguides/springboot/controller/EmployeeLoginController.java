package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.InvalidPasswordException;
import net.javaguides.springboot.exception.NoSuchUserException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.Login;
import net.javaguides.springboot.service.CheckUserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/login/user")
public class EmployeeLoginController {

    @Autowired CheckUserData cud;

    @GetMapping
    public List<Login> getAllEmployees()
    {
        return cud.findAllData();  //findAll() method returns all entities that are saved to the jpa database
    }

    @PostMapping
    public boolean createNewUser(@RequestParam long uid, @RequestParam String pwd) throws NoSuchUserException {
        int n = cud.createUser(uid, pwd);
        return n > 0;
    }
    //will be accessed using http://localhost:8080/login/user?uid=1&pwd=2
    //If the name of the query parameter in URL is the same as the name of the variable in the handler's @RequestParam annotated argument then you can simply use @RequestParam without specifying the name of a query parameter in argument to @RequestMapping

    @GetMapping("/{uid}")
    //@ResponseStatus(HttpStatus.TEMPORARY_REDIRECT)
    public void loginUser(@PathVariable long uid, @RequestParam String pwd) {
        Login data;
        try {
            data = cud.checkUserData(uid, pwd);
            if (data.getPwd()==null) {
                throw new NoSuchUserException("No user found");
            } else if (!data.getPwd().equals(pwd)) {
                throw new InvalidPasswordException("Wrong password");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //redirect to another page
    }

}
