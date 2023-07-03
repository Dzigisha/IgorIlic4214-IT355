package pz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pz.entity.LoginUser;
import pz.repository.LoginRepository;

@Service()
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    public LoginUser insertUser(LoginUser por) {
        return loginRepository.save(por);
    }

}
