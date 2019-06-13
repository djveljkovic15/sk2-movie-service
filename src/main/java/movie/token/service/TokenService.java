package movie.token.service;


import io.jsonwebtoken.Claims;

public interface TokenService {

    Claims parseToken(String jwt);
}
