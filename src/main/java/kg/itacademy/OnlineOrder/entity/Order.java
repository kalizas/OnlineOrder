package kg.itacademy.OnlineOrder.entity;


import kg.itacademy.OnlineOrder.model.OrderModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "book")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "schedule_time")
    private LocalDateTime scheduleTime;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    private Menu menu;

    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private String order;

    public OrderModel toModel(){
        return OrderModel.builder()
                .id(id)
                .scheduleTime(scheduleTime)
                .build();
    }
}
