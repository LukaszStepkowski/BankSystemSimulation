package pl.sda.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.sda.exception.NegativeAmountException;

import java.math.BigDecimal;

public class SavingAccountTest {

    @Test
    public void shouldInvokePayment() throws NegativeAmountException {
        //given
        SavingAccount account = new SavingAccount();
        double testPayment = 1000d;

        //when
        account.payment(testPayment);

        //then
        Assertions.assertEquals(BigDecimal.valueOf(testPayment * account.getSavingFactor()), account.getBalance());
    }

}
