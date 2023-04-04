package com.niji.lille.nijiVerse.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    /**
     * Ce code implémente un contrôleur qui expose deux endpoints : /register et /authenticate. Les deux endpoints
     * sont définis avec l'annotation @PostMapping, indiquant que ces endpoints acceptent des demandes HTTP POST.
     * Les deux endpoints acceptent une demande HTTP POST contenant un corps de requête au format JSON.
     * Les corps de requête sont mappés sur les objets RegisterRequest et AuthenticationRequest respectivement,
     * grâce à l'annotation @RequestBody.
     */

    /**
     * Le contrôleur a une dépendance AuthenticationService injectée par l'intermédiaire du constructeur,
     * qui est utilisée pour appeler les méthodes de service register et authenticate.
     */
    private final AuthenticationService service;

    /**
     * La méthode register est appelée lorsque l'endpoint /register est atteint.
     * La méthode utilise la dépendance service pour appeler la méthode register du service avec
     * la demande RegisterRequest fournie
     * @param request la demande RegisterRequest fournie
     * @return une réponse HTTP contenant un objet AuthenticationResponse avec un code de statut HTTP 200 OK.
     */
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        System.out.println("ici ");
        return ResponseEntity.ok(service.register(request));
    }

    /**
     * La méthode authenticate est appelée lorsque l'endpoint /authenticate est atteint.
     * La méthode utilise la dépendance service pour appeler la méthode authenticate du service
     * @param request la demande AuthenticationRequest fournie
     * @return une réponse HTTP contenant un objet AuthenticationResponse avec un code de statut HTTP 200 OK.
     */
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        System.out.println("authtneitcate");
        return ResponseEntity.ok(service.authenticate(request));
    }

}
