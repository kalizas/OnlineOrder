package kg.itacademy.OnlineOrder.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "company")
@Getter
@Setter
public class Company {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;
}
