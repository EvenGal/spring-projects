package com.evegal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.oidc.StandardClaimNames;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class MeController {

    @GetMapping("/me")
    @PreAuthorize("hasAuthority('handler')")
    public UserInfo getUserInfo(JwtAuthenticationToken token) {
        return new UserInfo(
                token.getToken().getClaimAsString(StandardClaimNames.PREFERRED_USERNAME),
                token.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList(),
                Collections.singletonList(token.getToken().getClaimAsString("scope"))
        );
    }
}
