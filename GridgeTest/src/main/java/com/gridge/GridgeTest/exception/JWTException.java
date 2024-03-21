package com.gridge.GridgeTest.exception;

import io.jsonwebtoken.JwtException;

public class JWTException extends JwtException {
    public JWTException(String message) {
        super(message);
    }
}
