package com.aleksei.card.validators;

import org.junit.Test;
import static org.junit.Assert.*;

public class CardNumberValidityTest {

    @Test
    public void validate() {
        assertTrue(new CardNumberValidity().validate("4561261212345467"));
    }
}
