import java.util.ArrayList;

public class Week7 {
   /* public static void main(String[] args) {
        Thing book = new Thing("Happiness in Three Steps", 2);
        Thing mobile = new Thing("Nokia 3210", 1);
        System.out.println("Book name: " + book.getName());
        System.out.println("Book weight: " + book.getWeight());

        System.out.println("Book: " + book);
        System.out.println("Mobile: " + mobile);
    }

        public static void main(String[] args) {
            Thing book = new Thing("Happiness in three steps", 2);
            Thing mobile = new Thing("Nokia 3210", 1);
            Thing brick = new Thing("Brick", 4);

            Suitcase suitcase = new Suitcase(5);
            System.out.println(suitcase);

            suitcase.addThing(book);
            System.out.println(suitcase);

            suitcase.addThing(mobile);
            System.out.println(suitcase);

            suitcase.addThing(brick);
            System.out.println(suitcase);
        }

    public static void main(String[] args) {
        Thing book = new Thing("Happiness in Three Steps", 2);
        Thing mobile = new Thing("Nokia 3210", 1);
        Thing brick = new Thing("Brick", 4);

        Suitcase suitcase = new Suitcase(10);
        suitcase.addThing(book);
        suitcase.addThing(mobile);
        suitcase.addThing(brick);

        System.out.println("Your suitcase contains the following things:");
        suitcase.printThings();
        System.out.println("Total weight: " + suitcase.totalWeight() + " kg");
    }*/
   public static void main(String[] args) {
       Thing book = new Thing("Happiness in Three Steps", 2);
       Thing mobile = new Thing("Nokia 3210", 1);
       Thing brick = new Thing("Brick", 4);

       Suitcase suitcase = new Suitcase(10);
       suitcase.addThing(book);
       suitcase.addThing(mobile);
       suitcase.addThing(brick);

       Thing heaviest = suitcase.heaviestThing();
       System.out.println("The heaviest thing: " + heaviest);
   }



}

    class Thing {
        private String name;
        private int weight;

        public Thing(String name, int weight) {
            this.name = name;
            this.weight = weight;

        }
        public String getName() {
            return name;

        }
        public int getWeight() {
            return weight;
        }

        public String toString() {
            return name + " (" + weight + " kg)";
        }

    }
    class Suitcase {
    private ArrayList<Thing> things;
    private int maxWeight;

    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<>();

    }
    public void addThing(Thing thing) {
        int currentWeight = 0;
        for (Thing t : things) {
            currentWeight = currentWeight + t.getWeight();
        }
        if  (currentWeight + thing.getWeight ()<= maxWeight) {
            things.add(thing);

        }
    }

    public void printThings() {
        for (Thing t : things) {
            System.out.println(t);
        }
    }

    public int totalWeight() {
        int total = 0;
        for (Thing t : things) {
            total = total + t.getWeight();
        } return total;
    }

    public Thing heaviestThing() {
        if  (things.isEmpty()) {
            return null;
        }
        Thing heaviest = things.get(0);
        for (Thing t : things) {
            if (t.getWeight() > heaviest.getWeight()) {
                heaviest = t;
            }
        }
        return heaviest;
    }

    public String toString() {
        int totalWeight = 0;
        for (Thing t : things) {
            totalWeight = totalWeight + t.getWeight();
        }
        if (things.size() == 0) {
            return "empty (" + totalWeight + " kg)";
        }else if (things.size() == 1) {
            return "1 thing (" + totalWeight + " kg)";
        }else
        return things.size() + " things (" + totalWeight +" kg)";
    }

}


