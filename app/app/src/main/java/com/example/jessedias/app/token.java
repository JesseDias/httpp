package com.example.jessedias.app;

import java.io.IOException;
import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

/**
 * Created by jessedias on 13/11/2017.
 */

public class token {




    Key key = MacProvider.generateKey();

    Date dateNow = new Date();
    Date expires = new Date(dateNow.getTime() + 86400000);



    donwloadDados meusDados = new donwloadDados();
    String usuario= String.valueOf(meusDados.execute());

    String VALID_USER =usuario;

    String gerarToken = Jwts.builder().setSubject(VALID_USER).signWith(SignatureAlgorithm.HS256, key).setExpiration(expires).compact();
    String email = Jwts.parser().setSigningKey(key).parseClaimsJws(gerarToken).getBody().getSubject();

    public token() throws IOException {
    }
}
