package net.javaguides.springboot.service;

import net.javaguides.springboot.exception.NoSuchUserException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import net.javaguides.springboot.model.Login;

import java.util.List;
import java.util.Optional;

@Service    //It is just for a better practice to annotate your class with this
@Component
public class CheckUserData {

    @Autowired
    JdbcTemplate jtm;

    @Autowired
    LoginRepository lr;
    public Login checkUserData(long uid, String pwd)
    {
        // String sql = "Select * from login where id=? and password=?";
        //return jtm.queryForObject(sql,new Object[]{uid, pwd}, new BeanPropertyRowMapper<>(Login.class));
        Optional<Login> obj = lr.findById(uid);  //Optional object denotes the possibility of a missing object, i.e. record might be not present
        Login l=new Login();
        if(obj.isPresent())
            l =  obj.get();
        return l;
    }
    public List<Login> findAllData()
    {
        return lr.findAll();
    }
    public int createUser(long uid, String pwd) throws NoSuchUserException {
        //String sql = "Insert into login values(?,?)";
        try {
            //jtm.update(sql, new Object[] {uid, pwd}, new BeanPropertyRowMapper<>(Login.class));   //It is needed inside try block because exception can occur while inserting data in table
            lr.save(new Login(uid,pwd));
        }//returns number of rows affected
        catch (Exception e)
        {
            throw new NoSuchUserException("");
            /*if (e.Number == 2627)
            {
               System.out.println("Primary key must be unique");
            }*/
        }
        return 0;
    }
}
