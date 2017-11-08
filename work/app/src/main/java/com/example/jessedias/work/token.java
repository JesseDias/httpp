package com.example.jessedias.work;

/**
 * Created by jessedias on 08/11/2017.
 */
import android.util.Log;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.security.Key;
import java.util.Date;

public class token {

    Key key = MacProvider.generateKey();

    Date dateNow = new Date();
    Date expires = new Date(dateNow.getTime() + 86400000);

    String email = "jsd_jesse@hotmail.com";

    String gerarToken = Jwts.builder().setSubject(email).signWith(SignatureAlgorithm.HS256, key).setExpiration(expires).compact();

}
