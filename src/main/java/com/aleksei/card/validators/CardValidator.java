package com.aleksei.card.validators;

public interface CardValidator {

    int CARD_NUMBER_LENGTH = 16;

    boolean validate(String cardNumber);
}
