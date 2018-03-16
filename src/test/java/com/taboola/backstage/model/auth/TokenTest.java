package com.taboola.backstage.model.auth;

import com.taboola.backstage.BackstageTestBase;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by vladi
 * Date: 2/24/2018
 * Time: 11:06 PM
 * By Taboola
 */
public class TokenTest extends BackstageTestBase {

    @Test
    public void testIsExpired() throws InterruptedException {
        Token token = new Token();
        token.setExpiresIn(1);
        assertFalse("Token should not be expired", token.isExpired());
        Thread.sleep(1200L);
        assertTrue("Token should be expired", token.isExpired());
    }
    
    @Test
    public void testTokenCreationTime() throws InterruptedException {
        Token token = new Token();
        token.setAccessToken("access");
        token.setExpiresIn(123);
        token.setRefreshToken("refresh");
        token.setTokenType("type");

        Thread.sleep(5L);

        Token sameTokenNewInstance = new Token();
        sameTokenNewInstance.setAccessToken(token.getAccessToken());
        sameTokenNewInstance.setExpiresIn(token.getExpiresIn());
        sameTokenNewInstance.setRefreshToken(token.getRefreshToken());
        sameTokenNewInstance.setTokenType(token.getTokenType());

        assertFalse("Invalid equals", token.equals(sameTokenNewInstance));
        assertFalse("Invalid hash code result", token.hashCode() == sameTokenNewInstance.hashCode());
    }
    
    @Test(expected = NullPointerException.class)
    public void testIsExpired_exceptionOnNullExpiresIn() {
        Token token = new Token();
        token.isExpired();
    }
}
