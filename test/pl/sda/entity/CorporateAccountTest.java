package pl.sda.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.sda.exception.NegativeAmountException;
import pl.sda.exception.insufficientBalanceException;

import java.math.BigDecimal;

public class CorporateAccountTest {

    @Test
    public void shouldInvokeWithdrawal() throws NegativeAmountException, insufficientBalanceException {
        //given
        CorporateAccount account = new CorporateAccount();
        double testPayment = 1000d;
        double testWithdrawal = 900d;

        account.payment(testPayment);

        //when
        account.withdrawal(testWithdrawal);

        //then
        Assertions.assertEquals(BigDecimal.valueOf(testPayment - testWithdrawal - account.getCorporateFee()), account.getBalance());
    }
}
