import org.junit.Assert;
import org.junit.Test;
import CashRegister.CashRegister;
import CashRegister.USMoney;

/**
 * These are the basic tests for the CashRegister and USMoney classes
 */

public class HelloChangeTest {

    CashRegister cashRegister = new CashRegister(1,2,3,4,5);

    @Test
    public void testUSMoney(){
        USMoney usMoney = new USMoney(1, 2, 3, 4 , 5);
        int [] put = {1, 2, 3, 0, 5};
        int [] take = {1, 4, 3, 0, 10 };
        Assert.assertEquals("$68 1 2 3 4 5", usMoney.toString());
        usMoney.putBills(put);
        Assert.assertEquals("$128 2 4 6 4 10", usMoney.toString());
        usMoney.takeBills(take);
        Assert.assertEquals("$43 1 0 3 4 0", usMoney.toString());
        usMoney.change(11);
        Assert.assertEquals("$32 1 0 2 1 0", usMoney.toString());
        usMoney.change(14);
        Assert.assertEquals("$32 1 0 2 1 0", usMoney.toString());
        usMoney.change(45);
        Assert.assertEquals("$32 1 0 2 1 0", usMoney.toString());
    }

    @Test
    public void testCashRegister(){
        String [] put = {"1", "2", "3", "0", "5"};
        String [] take = {"1", "4", "3", "0", "10" };
        Assert.assertEquals("$68 1 2 3 4 5", cashRegister.show());
        cashRegister.put(put);
        Assert.assertEquals("$128 2 4 6 4 10", cashRegister.show());
        cashRegister.take(take);
        Assert.assertEquals("$43 1 0 3 4 0", cashRegister.show());
        cashRegister.change("11");
        Assert.assertEquals("$32 1 0 2 1 0", cashRegister.show());
        cashRegister.change("14");
        Assert.assertEquals("$32 1 0 2 1 0", cashRegister.show());
    }

}
