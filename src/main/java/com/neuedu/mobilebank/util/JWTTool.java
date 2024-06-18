package com.neuedu.mobilebank.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTTool {
    //令牌私有密钥
    private static final String SECRET = "lsr123";
    //定义令牌过期时间的单位
    private static final int calendarField = Calendar.SECOND;
    //定义令牌的过期时间
    private static final int calenderInterval = 60*60;       //5*60
    //创建令牌的方法
    public static String createToken(String mobileJson){
        //确认令牌的签发日期、过期时间
        //签发日期
        Date iaDate=new Date();
        //过期日期
        Calendar nowTime=Calendar.getInstance();
        nowTime.add(calendarField, calenderInterval);
        Date expiryDate=nowTime.getTime();
        //确认令牌的类型和加密算法
        Map<String,Object> map=new HashMap<>();
        map.put("typ","JWT");
        map.put("alg","HS256");
        //结合前两步的结果，创建令牌字符串
        String token = JWT.create()
                .withHeader(map)
                .withClaim("mobileJson", mobileJson)
                .withIssuedAt(iaDate)
                .withExpiresAt(expiryDate)
                .sign(Algorithm.HMAC256(SECRET));
        return token;
    }
    //解密令牌的方法
    private static Map<String, Claim> verifyToken(String token){
        DecodedJWT jwt=null;
        JWTVerifier verifier=JWT.require(Algorithm.HMAC256(SECRET)).build();
        jwt=verifier.verify(token);
        return jwt.getClaims();
    }
    //把令牌解析成json的方法
    public static String parseToken(String token){

        Map<String,Claim> claims=verifyToken(token);
        Claim mobileClaim=claims.get("mobileJson");

        return mobileClaim.asString();
    }
}
