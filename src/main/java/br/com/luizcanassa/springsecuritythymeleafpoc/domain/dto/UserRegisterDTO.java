package br.com.luizcanassa.springsecuritythymeleafpoc.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDTO {

    private String username;

    private String password;
}
