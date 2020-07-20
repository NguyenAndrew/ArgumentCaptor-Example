import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class NeighborTest {

    Bank bank = mock(Bank.class);

    Neighbor neighbor = new Neighbor(bank);

    @Test
    void singleVerify() {
        neighbor.deposit(20);

        verify(bank).deposit(15);
    }

    @Test
    void argumentCaptor() {

        neighbor.deposit(20);

        ArgumentCaptor<Integer> depositedMoney = ArgumentCaptor.forClass(Integer.class);

        verify(bank).deposit(depositedMoney.capture());

        assertEquals(depositedMoney.getValue(), 15);
    }

    @Test
    void multipleVerifies() {
        neighbor.depositCoins(new int[]{1, 5, 10, 25, 50, 100});

        verify(bank).deposit(5);
        verify(bank).deposit(10);
        verify(bank).deposit(25);
        verify(bank).deposit(50);
        verify(bank).deposit(100);
    }

    @Test
    void argumentCaptorAllValues() {
        neighbor.depositCoins(new int[]{1, 5, 10, 25, 50, 100});

        ArgumentCaptor<Integer> depositedMoney = ArgumentCaptor.forClass(Integer.class);

        verify(bank, atLeastOnce()).deposit(depositedMoney.capture());

        assertEquals(depositedMoney.getAllValues(), Arrays.asList(5, 10, 25, 50, 100));
    }

}