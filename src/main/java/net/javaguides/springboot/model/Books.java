package net.javaguides.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // annotation is to configure the way of increment of the specified column(field).For example when using Mysql , you may specify auto_increment in the definition of table to make it self-incremental, and then use @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="BookName")
    private String b_name;

    @Column(name="price")
    private long price;
}
