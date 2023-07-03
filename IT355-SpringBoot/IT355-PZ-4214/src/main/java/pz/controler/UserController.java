package pz.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pz.dto.LoginRequestDto;
import pz.entity.LoginUser;
import pz.entity.User;
import pz.service.LoginService;
import pz.service.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    LoginService loginService;

    @PostMapping(path = "/register")
    public ResponseEntity insertUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.insertUser(user));
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/user")
    public ResponseEntity getUsers() {
        return ResponseEntity.ok(userService.fetchAll());
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/single_user/{id}")
    public ResponseEntity getUser(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(userService.getUser(id));
    }




    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody LoginRequestDto por) {

        User user = userService.findUser(por.getUser_id());

        System.out.println("User id " + por.getUser_id());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();

        LoginUser pore = new LoginUser();

        pore.setDate(now);
        pore.setUser_login(user);

        System.out.println(now);

        if (pore == null) {
            return (ResponseEntity) ResponseEntity.badRequest();
        }

        return ResponseEntity.ok(loginService.insertUser(pore));
    }
}
