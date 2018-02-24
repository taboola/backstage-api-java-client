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
}
