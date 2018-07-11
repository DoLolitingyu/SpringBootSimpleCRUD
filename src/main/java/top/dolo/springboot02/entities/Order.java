package top.dolo.springboot02.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "order_tbl")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cost")
    private double cost;

    @Column(name = "userid")
    private Integer userid;

    @Column(name = "orderdate")
    private Date orderdate;
}
