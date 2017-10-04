import org.junit.Assert;
import org.junit.Test;
import CashRegister.CashRegister;
import CashRegister.USMoney;

public class HelloChangeTest {

    CashRegister cashRegister = new CashRegister(1,2,3,4,5);

    @Test
    public void testUSMoney(){
        USMoney usMoney = new USMoney(1, 2, 3, 4 , 5);
        Assert.assertEquals("$68 1 2 3 4 5", usMoney.toString());
        int [] put = {1, 2, 3, 0, 5};
        int [] take = {1, 4, 3, 0, 10 };
        int [] change = {0, 0, 1, 3, 0};
        usMoney.putBills(put);
        Assert.assertEquals("$128 2 4 6 4 10", usMoney.toString());
        usMoney.takeBills(take);
        Assert.assertEquals("$43 1 0 3 4 0", usMoney.toString());
        //Assert.assertEquals(usMoney.change(11), "0 0 1 3 0");
        //Assert.assertArrayEquals(usMoney.makeChange(11), change);
        usMoney.change(11);

        //Assert.assertEquals("$32 1 0 2 1 0", usMoney.toString());

    }

    @Test
    public void testTotal(){
        Assert.assertEquals("$68 1 2 3 4 5", cashRegister.show());
    }


}
