package hr.tvz.ivankovic.hardwareapp.security.service;

import hr.tvz.ivankovic.hardwareapp.security.command.LoginCommand;
import hr.tvz.ivankovic.hardwareapp.security.dto.LoginDTO;

import java.util.Optional;

public interface AuthenticationService {

    Optional<LoginDTO> login(LoginCommand command);

}
