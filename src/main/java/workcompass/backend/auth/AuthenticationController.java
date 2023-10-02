package workcompass.backend.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import workcompass.backend.user.UserRepository;

@Controller
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value = "/register")
    public ResponseEntity<AuthenticationResponse> registerUser(
            @RequestBody RegisterRequest registerRequest){
        AuthenticationResponse response =
                authenticationService.registerNewUser(registerRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> authenticate(
            @RequestBody AuthenticationRequest request){
        AuthenticationResponse response =
                authenticationService.authenticateUserCredentials(request);
        if(response==null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        return ResponseEntity.ok(response);
    }
}
