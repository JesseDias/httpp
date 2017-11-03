package com.example.jessedias.work;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by jessedias on 03/11/2017.
 */


public class geradorToken extends HttpURLConnection{
        protected geradorToken(URL u) {
        super(u);
    }

    @Override
    public void disconnect() {

    }

    @Override
    public boolean usingProxy() {
        return false;
    }

    @Override
    public void connect()
            throws IOException {

    }
}
