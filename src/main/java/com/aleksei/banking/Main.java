package com.aleksei.banking;

import com.aleksei.card.PaySystem;
import com.aleksei.card.validators.CardNumberValidity;
import com.aleksei.card.validators.CardValidator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String cardNumber;
        String whiteSpacesRegex = "\\s+";
        CardValidator validator = new CardNumberValidity();

        System.out.println("Please enter card number: ");

        try (Scanner scanner = new Scanner(System.in)){
            cardNumber = scanner.nextLine().replaceAll(whiteSpacesRegex,"");

            if (!validator.validate(cardNumber)) {
                do {
                    System.out.println("Card number was entered with an error, please try again");
                    cardNumber = scanner.nextLine().replaceAll(whiteSpacesRegex,"");
                } while (!validator.validate(cardNumber));
            }
        }

        int paySystemId = Character.getNumericValue(cardNumber.charAt(0));
        PaySystem paySystemName = PaySystem.getById(paySystemId);
        String cardPaySystemName = paySystemName.getPaySystemName();

        System.out.println(String.format("Your card is valid and it is %s", cardPaySystemName));

    }
}
