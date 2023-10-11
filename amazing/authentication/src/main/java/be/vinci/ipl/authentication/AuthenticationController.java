package be.vinci.ipl.authentication;

import be.vinci.ipl.authentication.model.SafeCredentials;
import be.vinci.ipl.authentication.model.UnsafeCredentials;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService service;

    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @PostMapping("/authentication")
    public ResponseEntity<Void> createUser(@RequestBody UnsafeCredentials unsafeCredentials) {
        boolean created = service.createOne(unsafeCredentials);

        if (!created) return new ResponseEntity<>(HttpStatus.CONFLICT);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}