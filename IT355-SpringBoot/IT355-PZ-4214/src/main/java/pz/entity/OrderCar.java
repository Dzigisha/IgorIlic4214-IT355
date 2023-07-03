package pz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class OrderCar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int order_id;

    @OneToOne
    private User user;

    @OneToOne
    private Car car;

}

