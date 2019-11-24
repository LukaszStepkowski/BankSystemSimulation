package pl.sda.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.sda.exception.NegativeAmountException;
import pl.sda.exception.insufficientBalanceException;

import java.math.BigDecimal;

public class CurrentAccountTest {

    @Test
    public void shouldInvokePayment() throws NegativeAmountException {
        //given
        CurrentAccount account = new CurrentAccount();
        double testPayment = 1000d;

        //when
        account.payment(testPayment);

        //then
        Assertions.assertEquals(BigDecimal.valueOf(testPayment), account.getBalance());

    }

    @Test
    public void shouldInvokeWithdrawal() throws NegativeAmountException, insufficientBalanceException {
        //given
        CurrentAccount account = new CurrentAccount();
        double testPayment = 1000d;
        double testWithdrawal = 500d;
        account.payment(testPayment);

        //when
        account.withdrawal(testWithdrawal);

        //then
        Assertions.assertEquals(BigDecimal.valueOf(testPayment - testWithdrawal), account.getBalance());

    }

    @Test
    public void shouldInvokeTransfer() throws NegativeAmountException, insufficientBalanceException {
        //given
        CurrentAccount accountSrc = new CurrentAccount();
        CurrentAccount accountDst = new CurrentAccount();
        double testPayment = 1000d;
        double testTransfer = 700d;
        accountSrc.payment(testPayment);

        //when
        accountSrc.transfer(accountDst, testTransfer);

        //then
        Assertions.assertEquals(BigDecimal.valueOf(testPayment - testTransfer), accountSrc.getBalance());
        Assertions.assertEquals(BigDecimal.valueOf(testTransfer), accountDst.getBalance());

    }
}
