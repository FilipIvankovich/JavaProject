package hr.tvz.ivankovic.hardwareapp.security.service;

import hr.tvz.ivankovic.hardwareapp.security.domain.User;

public interface JwtService {

    boolean authenticate(String token);

    String createJwt(User user);

}
