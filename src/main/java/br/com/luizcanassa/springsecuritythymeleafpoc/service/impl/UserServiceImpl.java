package br.com.luizcanassa.springsecuritythymeleafpoc.service.impl;

import br.com.luizcanassa.springsecuritythymeleafpoc.domain.dto.UserRegisterDTO;
import br.com.luizcanassa.springsecuritythymeleafpoc.domain.entity.UserEntity;
import br.com.luizcanassa.springsecuritythymeleafpoc.repository.RoleRepository;
import br.com.luizcanassa.springsecuritythymeleafpoc.repository.UserRepository;
import br.com.luizcanassa.springsecuritythymeleafpoc.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(final UserRepository userRepository, final RoleRepository roleRepository, final BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final var user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));

        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map((role) -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        return new User(
                username,
                user.getPassword(),
                authorities
        );
    }

    @Override
    public UserEntity createUser(final UserRegisterDTO userRegister) {
        System.out.println(userRegister);
        final var user = new UserEntity();

        user.setId(null);
        user.setUsername(userRegister.getUsername());
        user.setPassword(passwordEncoder.encode(userRegister.getPassword()));
        user.setRoles(
                Collections.singleton(roleRepository.findByName("ROLE_USER").orElse(null))
        );

        return userRepository.saveAndFlush(user);
    }
}
