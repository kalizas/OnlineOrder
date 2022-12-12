package kg.itacademy.OnlineOrder.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "filial_id")
    private Filial filial;
}
