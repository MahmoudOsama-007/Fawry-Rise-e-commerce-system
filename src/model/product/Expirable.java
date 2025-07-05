package model.product;

import java.time.LocalDate;

public interface Expirable {
    boolean isExpired(LocalDate today);
}
