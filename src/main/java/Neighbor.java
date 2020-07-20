public class Neighbor {

    Bank bank;

    Neighbor(Bank bank) {
        this.bank = bank;
    }

    public void deposit(int money) {
        money = money - 5;
        bank.deposit(money);
    }

    public void depositCoins(int[] coin) {

        int takeFirstCoins = coin[0];

        for(int i = 1; i < coin.length; i++) {
            bank.deposit(coin[i]);
        }
    }

}