
/*
public class Week4 {
    public static void main(String[] args) {
        // Test  DecreasingCounter
        System.out.println("=== Testing Exercise 75 ===");

        // Tavaline test
        DecreasingCounter counter = new DecreasingCounter(10);
        counter.printValue();
        counter.decrease();
        counter.printValue();
        counter.decrease();
        counter.printValue();

        System.out.println();

        // alla 0 testimine
        DecreasingCounter counter2 = new DecreasingCounter(2);
        counter2.printValue();
        counter2.decrease();
        counter2.printValue();
        counter2.decrease();
        counter2.printValue();
        counter2.decrease();
        counter2.printValue();

        System.out.println();

        // Testi reseti
        DecreasingCounter counter3 = new DecreasingCounter(100);
        counter3.printValue();
        counter3.reset();
        counter3.printValue();
        counter3.decrease();
        counter3.printValue();

        System.out.println();

        // Testime setInitial
        DecreasingCounter counter4 = new DecreasingCounter(100);
        counter4.printValue();
        counter4.decrease();
        counter4.printValue();
        counter4.decrease();
        counter4.printValue();
        counter4.reset();
        counter4.printValue();
        counter4.setInitial();
        counter4.printValue();
    }
}

class DecreasingCounter {
    private int value;
    private int initialValue;

    public DecreasingCounter(int valueAtStart) {
        this.value = valueAtStart;
        this.initialValue = valueAtStart;
    }

    public void printValue() {
        System.out.println("value: " + this.value);
    }

    // Exercise 75.1
    public void decrease() {
        // Exercise 75.2
        if (this.value > 0) {
            this.value = this.value - 1;
        }
    }

    // Exercise 75.3
    public void reset() {
        this.value = 0;
    }

    // Exercise 75.4
    public void setInitial() {
        this.value = this.initialValue;
    }
}



public class Week4 {
    public static void main(String[] args) {
        // Test Exercise 77
        System.out.println("Testing Exercise 77 - LyyraCard");

        // Test 77.1
        System.out.println("Test 77.1: Basic functionality");
        LyyraCard card = new LyyraCard(50);
        System.out.println(card);

        // Test 77.2
        System.out.println("\nTest 77.2: Paying for meals");
        LyyraCard card2 = new LyyraCard(50);
        System.out.println(card2);
        card2.payEconomical();
        System.out.println(card2);
        card2.payGourmet();
        card2.payEconomical();
        System.out.println(card2);

        // Test 77.3
        System.out.println("\nTest 77.3: Balance stays positive");
        LyyraCard card3 = new LyyraCard(5);
        System.out.println(card3);
        card3.payGourmet();
        System.out.println(card3);
        card3.payGourmet();
        System.out.println(card3);

        // Test 77.4
        System.out.println("\nTest 77.4: Loading money");
        LyyraCard card4 = new LyyraCard(10);
        System.out.println(card4);
        card4.loadMoney(15);
        System.out.println(card4);
        card4.loadMoney(10);
        System.out.println(card4);
        card4.loadMoney(200); // Should cap at 150
        System.out.println(card4);

        // Test 77.5
        System.out.println("\nTest 77.5: Loading negative amount");
        LyyraCard card5 = new LyyraCard(10);
        System.out.println("Pekka: " + card5);
        card5.loadMoney(-15); // Should not change balance
        System.out.println("Pekka: " + card5);

        // Test 77.6
        System.out.println("\nTest 77.6: Multiple cards");
        LyyraCard cardPekka = new LyyraCard(20);
        LyyraCard cardBrian = new LyyraCard(30);

        // Pekka gourmet lunch
        cardPekka.payGourmet();
        // Brian  economical lunch
        cardBrian.payEconomical();
        // Print both
        System.out.println("Pekka: " + cardPekka);
        System.out.println("Brian: " + cardBrian);

        // Pekka loads 20 eur
        cardPekka.loadMoney(20);
        // Brian gourmet lunch
        cardBrian.payGourmet();
        // Print both cards
        System.out.println("Pekka: " + cardPekka);
        System.out.println("Brian: " + cardBrian);

        // Pekka buys economical lunch twice
        cardPekka.payEconomical();
        cardPekka.payEconomical();
        // Brian loads 50 euros
        cardBrian.loadMoney(50);
        // Print both cards
        System.out.println("Pekka: " + cardPekka);
        System.out.println("Brian: " + cardBrian);
    }
}

class LyyraCard {
    private double balance;

    // Exercise 77.1
    public LyyraCard(double balanceAtStart) {
        this.balance = balanceAtStart;
    }

    public String toString() {
        return "The card has " + this.balance + " euros";
    }

    // Exercise 77.2
    // Exercise 77.3
    public void payEconomical() {
        if (this.balance >= 2.50) {
            this.balance = this.balance - 2.50;
        }
    }

    public void payGourmet() {
        if (this.balance >= 4.00) {
            this.balance = this.balance - 4.00;
        }
    }

    // Exercise 77.4
    public void loadMoney(double amount) {
        // Exercise 77.5
        if (amount > 0) {
            this.balance = this.balance + amount;
            // Maximum balance is 150 euros
            if (this.balance > 150.0) {
                this.balance = 150.0;
            }
        }
    }
}
*/
