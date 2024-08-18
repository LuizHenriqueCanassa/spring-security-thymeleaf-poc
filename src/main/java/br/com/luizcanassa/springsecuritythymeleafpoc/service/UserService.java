package br.com.luizcanassa.springsecuritythymeleafpoc.service;

import br.com.luizcanassa.springsecuritythymeleafpoc.domain.dto.UserRegisterDTO;
import br.com.luizcanassa.springsecuritythymeleafpoc.domain.entity.UserEntity;

public interface UserService {

    UserEntity createUser(final UserRegisterDTO user);
}
