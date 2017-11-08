package com.example.jessedias.work;

/**
 * Created by jessedias on 08/11/2017.
 */
import android.util.Log;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Key;
import java.util.Date;

import static com.example.jessedias.work.R.id.senha;
import static com.example.jessedias.work.R.id.usuario;

public class token {




    Key key = MacProvider.generateKey();

    Date dateNow = new Date();
    Date expires = new Date(dateNow.getTime() + 86400000);



    downloadDados meusDados = new downloadDados();
    String usuario= String.valueOf(meusDados.execute());

    String VALID_USER =usuario;

    String gerarToken = Jwts.builder().setSubject(VALID_USER).signWith(SignatureAlgorithm.HS256, key).setExpiration(expires).compact();
    String email = Jwts.parser().setSigningKey(key).parseClaimsJws(gerarToken).getBody().getSubject();

    public token() throws IOException {
    }
}
