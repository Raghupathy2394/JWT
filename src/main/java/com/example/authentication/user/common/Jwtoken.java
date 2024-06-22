package com.example.authentication.user.common;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.example.authentication.user.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class Jwtoken {
     
	private static String secret="This_is_secret";
	public String generateJWT(User user) {
		Date issuedAt=new Date();
//		
//		Claims claims=Jwts.claims().setIssuer(user.getId().toString())
//				.setIssuedAt(issuedAt);
		   // Set JWT claims
	    Claims claims = Jwts.claims().setIssuer(String.valueOf(user.getId()));
	    claims.setIssuedAt(issuedAt);
			return Jwts.builder().setClaims(claims).compact();
		
	}
}
