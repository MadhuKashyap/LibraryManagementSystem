package net.javaguides.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter    //these annotations are used at field or class levels to generate getters and setters for private fields
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity  //The @Entity annotation specifies that the class is an entity and is mapped to a database table
@Table(name="employees")  // you can also provide schema architecture alongwith name

public class Employee {
    @Id         //make this attribute primary key
    //@Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // annotation is to configure the way of increment of the specified column(field).For example when using Mysql , you may specify auto_increment in the definition of table to make it self-incremental, and then use @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="FirstName")
    private String fName;

    @Column(name="LastName")
    private String lName;

    @Column(name="email")
    private String email;
}
