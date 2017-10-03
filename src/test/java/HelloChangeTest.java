import org.junit.Assert;
import org.junit.Test;
import CashRegister.CashRegister;

public class HelloChangeTest {

    CashRegister cashRegister = new CashRegister(1,2,3,4,5);

    @Test
    public void testTotal(){
        Assert.assertEquals(68, cashRegister.Total());
    }


}
