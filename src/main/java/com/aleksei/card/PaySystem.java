package com.aleksei.card;

public enum PaySystem {

    MIR(2, "MIR"),
    AMERICAN_EXPRESS(3, "American Express"),
    VISA(4,"VISA"),
    MASTERCARD(5,"MasterCard"),
    MAESTRO(6,"Maestro"),
    UNKNOWN("unknown");

    private String paySystemName;
    private int paySystemId;

    PaySystem(int paySystemId, String paySystemName) {
        this.paySystemId = paySystemId;
        this.paySystemName = paySystemName;
    }

    PaySystem(String paySystemName) {
        this.paySystemName = paySystemName;
    }

    public String getPaySystemName() {
        return paySystemName;
    }

    public static PaySystem getById(int paySystemId) {

        for (PaySystem name : PaySystem.values()) {

            if (name.paySystemId == paySystemId)
                return name;
        }

        return UNKNOWN;
    }
}
