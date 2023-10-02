package workcompass.backend.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import workcompass.backend.user.User;
import workcompass.backend.user.UserRepository;
import org.springframework.security.core.AuthenticationException;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtEncoder jwtEncoder;

    public String generateToken(Authentication authentication) {
        var claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plus(90, ChronoUnit.MINUTES))
                .subject(authentication.getName())
                .build();

        return this.jwtEncoder
                .encode(JwtEncoderParameters.from(claims))
                .getTokenValue();
    }

    public String generateToken(String userName) {
        var claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plus(90, ChronoUnit.MINUTES))
                .subject(userName)
                .build();

        return this.jwtEncoder
                .encode(JwtEncoderParameters.from(claims))
                .getTokenValue();
    }

    public AuthenticationResponse authenticateUserCredentials
            (AuthenticationRequest authRequest)
    {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUserName(),
                        authRequest.getPassword()
                );
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(authenticationToken);
            String token = generateToken(authentication);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            return new AuthenticationResponse(token, "Successful.");

        }
        catch (AuthenticationException e){
            return null;
        }
    }

    public AuthenticationResponse registerNewUser(RegisterRequest registerRequest){
        User existingUser = userRepository.findByUserName(registerRequest.getUserName());
        if(existingUser!=null)
            return new AuthenticationResponse("Username already exists");
        User newUser =
                new User(
                        registerRequest.getUserName(),
                        registerRequest.getEmailId(),
                        passwordEncoder.encode(registerRequest.getPassword())
                );
        userRepository.save(newUser);
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        registerRequest.getUserName(),
                        ""
                );
        String token = generateToken(newUser.getUserName());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        return new AuthenticationResponse(token, "Successful.");
    }
}
