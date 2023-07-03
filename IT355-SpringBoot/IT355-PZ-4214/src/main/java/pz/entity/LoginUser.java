package pz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int login_id;

    @OneToOne
    private User user_login;

    private Date date;

}

