package com.wuzl.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.crypto.spec.SecretKeySpec;

import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

public class token {
    private static Logger LOG = LoggerFactory.getLogger(token.class);

    /**
     * 创建TOKEN
     *
     * @param id, issuer, subject, ttlMillis
     * @return java.lang.String
     * @methodName createJWT
     * @author fusheng
     * @date 2019/1/10
     */
    public static String createJWT(String id, String issuer, String subject, long ttlMillis) {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("englishlearningwebsite");
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey);

        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }
    /**
     * 解密TOKEN
     *
     * @param jwt
     * @return io.jsonwebtoken.Claims
     * @methodName parseJWT
     * @author fusheng
     * @date 2019/1/10
     */
    public static Claims parseJWT(String jwt) {
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary("englishlearningwebsite"))
                .parseClaimsJws(jwt).getBody();
        return claims;
    }

//    //解密token          claims = TokenUtil.parseJWT(token);        //得到用户的类型
//    String issuer = claims.getIssuer();        //得到登录的时间
//    Date issuedAt = claims.getIssuedAt();         //得到设置的登录id
//    String id = claims.getId();    //claims.getExpiration().getTime() > DateUtil.date().getTime() ,判断tokern是否过期
//    // 得到存入token的对象          cn.hutool.json.JSONObject jsonObject = JSONUtil.parseObj(claims.getSubject());        Contact  contact = jsonObject.get("user", Contact.class);



}
