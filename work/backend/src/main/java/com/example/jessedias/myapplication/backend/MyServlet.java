/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Servlet Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloWorld
*/

package com.example.jessedias.myapplication.backend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.*;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;

import static javafx.scene.input.KeyCode.R;

public class MyServlet extends HttpServlet {
    private final String VALID_USER ="jsd_jesse@hotmail.com:123";



    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/plain");
        resp.sendError(HttpServletResponse.SC_FORBIDDEN,"nenhum acesso GET");


    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String name = req.getParameter("usuario");
        String pass = req.getParameter("senha");
        resp.setContentType("application/jason");
        if (name == null) {

            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            String jason = String.format("{\"erro\":\"%s\"}", "Nome de usuário é necessário");
            resp.getWriter().print(jason);
            return;
        }

            if ((name + ":" + pass).equals(VALID_USER)) {
                String token = createJWT("0", name, pass, 10000);
                String json = String.format("{\" token\":\"%s\"}", token);
                resp.getWriter().print(json);
            } else {
                resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                String json = String.format("{\"erro\":\"%s\"}", "Nome de usuário ou senha é inválido");
                resp.getWriter().print(json);
            }
        }


    private String createJWT (String id, String emissor, String audience, long ttlMillis) {
        Long NowMillis = System.currentTimeMillis();
        Date now = new Date(NowMillis);
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("MySecret");
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setIssuer(emissor)
                .setAudience(audience)
                .signWith(io.jsonwebtoken.SignatureAlgorithm.HS256, apiKeySecretBytes);
        if (ttlMillis>= 0) {
            Long expMillis = NowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);

        }
        return builder.compact ();
    }
}
