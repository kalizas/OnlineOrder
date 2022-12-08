package kg.itacademy.OnlineOrder.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "filial")
@Getter
@Setter
public class Filial {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @OneToOne
    @Column(name = "compamy")
    private Company company;

    @Column(name = "address")
    private String address;

}
