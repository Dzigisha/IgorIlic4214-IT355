package pz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pz.entity.LoginUser;

@Repository
public interface LoginRepository extends JpaRepository<LoginUser, Integer> {
}
