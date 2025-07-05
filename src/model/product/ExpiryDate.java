package model.product;

import java.time.LocalDate;

public class ExpiryDate implements Expirable{
    private final LocalDate expiry;

    public ExpiryDate(LocalDate expiry) {
        this.expiry = expiry;
    }

    public boolean isExpired(LocalDate today) {
        return today.isAfter(expiry);
    }
}
