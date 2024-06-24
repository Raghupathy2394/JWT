package com.example.authentication.user.common;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.example.authentication.user.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class Jwtoken {
     
	private static String secret="This_is_secret";
	
	private static long expiryDuration= 60 * 60;
	
	public String generateJWT(User user) {
		long milliTime=System.currentTimeMillis();
		long expiryTime=milliTime + expiryDuration * 1000;
		Date issuedAt=new Date(milliTime);
		Date expiryAt=new Date(expiryTime);
//		Claims claims=Jwts.claims().setIssuer(user.getId().toString())
//				.setIssuedAt(issuedAt);
 //       Set JWT claims
	    Claims claims = Jwts.claims().setIssuer(String.valueOf(user.getId()));
	    claims.setIssuedAt(issuedAt).setExpiration(expiryAt);
	    claims.put("type", user.getUserType());
	    claims.put("name", user.getName());
	    claims.put("emailid", user.getEmailid());
	   	return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512,secret)
	   			.compact();
	}
	
	public void verify(String authorization) throws Exception {
		try {
		Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization);
	} catch(Exception e) {
		throw new Exception();
	}
}
}