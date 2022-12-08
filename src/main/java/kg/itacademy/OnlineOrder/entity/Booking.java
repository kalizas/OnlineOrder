package kg.itacademy.OnlineOrder.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
@Getter
@Setter
public class Booking {

    @Id
    private Long id;

    @Column(name = "table_number")
    private String tableNameber;
}
