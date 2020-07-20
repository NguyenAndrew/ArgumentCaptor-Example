# ArgumentCaptor-Example
ArgumentCaptor - Example and Quick Tutorial

## Quick Code (Verify -to-> ArgumentCaptor)

Single Verify and ArgumentCaptor, single Value 
```
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
```

Multiple Verifies and ArgumentCaptor, all values
```
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
```

## Pros - and - Cons

Pros of ArgumentCaptor:

* Sometimes **less** boilerplate code then verify statements (check all values example above)
* Sometimes clearer tests using assertions

Cons of ArgumentCaptor:

* Sometimes **more** boilerplate code then verify statements (check single value example above)



