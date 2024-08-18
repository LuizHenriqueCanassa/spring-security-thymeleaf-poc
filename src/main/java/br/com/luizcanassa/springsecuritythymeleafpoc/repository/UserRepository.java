package br.com.luizcanassa.springsecuritythymeleafpoc.repository;

import br.com.luizcanassa.springsecuritythymeleafpoc.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

}
