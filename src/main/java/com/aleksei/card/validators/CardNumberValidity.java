package com.aleksei.card.validators;

public class CardNumberValidity implements CardValidator {

    @Override
    public boolean validate (String cardNumber) {

        if (cardNumber.length() != CARD_NUMBER_LENGTH)
            return false;

        if (!cardNumber.matches("[0-9]+"))
            return false;

        if (!checkControlNumber(cardNumber))
            return false;

        return true;
    }

    private boolean checkControlNumber(String cardNumber) {

        int evenPositionNumberSum = 0;
        int oddPositionNumberSum = 0;

        for (int i = cardNumber.length(); i >  0; i--) {

            int digit = Character.getNumericValue(cardNumber.charAt(i - 1));

            if (i % 2 != 0) {
                digit *= 2;

                if (digit > 9)
                    digit -= 9;
                evenPositionNumberSum += digit;
            } else {
                oddPositionNumberSum += digit;
            }
        }

        if ((evenPositionNumberSum + oddPositionNumberSum) % 10 != 0)
            return false;

        return true;
    }
}
