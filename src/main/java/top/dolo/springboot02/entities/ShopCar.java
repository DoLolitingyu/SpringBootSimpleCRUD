package top.dolo.springboot02.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ShopCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "userid")
    private Integer userid;

    @Column(name = "bookid")
    private Integer bookid;

    @Column(name = "num")
    private Integer num;

    @Column(name = "price")
    private double price;

    @Column(name = "bookname")
    private String bookName;

}
