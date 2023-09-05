package com.rgbmovie.security;

import java.util.Date;

import io.jsonwebtoken.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.rgbmovie.model.LoginModel;
import com.rgbmovie.model.UserModel;
import com.rgbmovie.repository.UserRepository;

@Component
public class JwtTokenUtil {

	
	@Value("${app.jwt.secret}")
    private String JWT_SECRET;
	@Autowired
	UserRepository userRepository;
	
	
	
	public String generateToken(LoginModel loginModel) {
		final long JWT_EXPIRATION = 864000000L;
		Date now = new Date();
		Date expiryDate = new Date(now.getTime()+JWT_EXPIRATION);
		UserModel userDetails = userRepository.findUserModelByUsernameOrEmail(loginModel.getUsername());

		String token = Jwts.builder().
				setSubject(String.format("%s", userDetails.getUsername()))
	            .setIssuer("Group_4")
	            .claim("roles", userDetails.getRoles().toString())
	            .setIssuedAt(new Date())
	            .setExpiration(expiryDate)
	            .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
				.compact();
		return token;
	}
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);
    
    public boolean validateAccessToken(String token) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException ex) {
            LOGGER.error("JWT expired", ex.getMessage());
        } catch (IllegalArgumentException ex) {
            LOGGER.error("Token is null, empty or only whitespace", ex.getMessage());
        } catch (MalformedJwtException ex) {
            LOGGER.error("JWT is invalid", ex);
        } catch (UnsupportedJwtException ex) {
            LOGGER.error("JWT is not supported", ex);
        } catch (SignatureException ex) {
            LOGGER.error("Signature validation failed");
        }
         
        return false;
    }
     
    public String getSubject(String token) {
        return parseClaims(token).getSubject();
    }
     
    public Claims parseClaims(String token) {
        return Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
	    
}
