package pz.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class LoginRequestDto {

    private int user_id;
    private Date date;

}
