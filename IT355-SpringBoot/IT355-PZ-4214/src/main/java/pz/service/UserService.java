package pz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pz.entity.User;
import pz.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service("userDetailsService")
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public User findUser(int id) {

        Optional<User> car = userRepo.findById(id);
        if (car.isPresent()) {
            return car.get();
        }
        return null;
    }

    public User insertUser(User user) {
        return userRepo.save(user);
    }

    public User getUser(int id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    public List<User> fetchAll() {
        return userRepo.findAll();
    }



}
