import java.util.ArrayList;
import java.util.HashMap;

public class Week8 {
    //Exercise 9
    public static void main(String[] args) {
        // Exercise 9.1 test
        RegistrationPlate reg1 = new RegistrationPlate("FI", "ABC-123");
        RegistrationPlate reg2 = new RegistrationPlate("FI", "UXE-456");
        RegistrationPlate reg3 = new RegistrationPlate("D", "B WQ-431");

        ArrayList<RegistrationPlate> finnish = new ArrayList<RegistrationPlate>();
        finnish.add(reg1);
        finnish.add(reg2);

        RegistrationPlate newPlate = new RegistrationPlate("FI", "ABC-123");
        if (!finnish.contains(newPlate)) {
            finnish.add(newPlate);
        }
        System.out.println("Finnish: " + finnish);

        HashMap<RegistrationPlate, String> owners = new HashMap<RegistrationPlate, String>();
        owners.put(reg1, "Arto");
        owners.put(reg3, "Jürgen");

        System.out.println("Owners:");
        System.out.println(owners.get(new RegistrationPlate("FI", "ABC-123")));
        System.out.println(owners.get(new RegistrationPlate("D", "B WQ-431")));

        // Exercise 9.2 and 9.3 test
        System.out.println("\nTesting VehicleRegister:");

        VehicleRegister register = new VehicleRegister();

        // Test add
        System.out.println("Adding reg1 with Arto: " + register.add(reg1, "Arto"));
        System.out.println("Adding reg1 with Pekka: " + register.add(reg1, "Pekka"));
        register.add(reg2, "Arto");
        register.add(reg3, "Jürgen");

        // Test get
        System.out.println("\nOwner of reg1: " + register.get(reg1));

        // Test printRegistrationPlates
        System.out.println("\nAll registration plates:");
        register.printRegistrationPlates();

        // Test printOwners
        System.out.println("\nAll owners:");
        register.printOwners();

        // Test delete
        System.out.println("\nDeleting reg1: " + register.delete(reg1));
        System.out.println("Deleting reg1 again: " + register.delete(reg1));

        // Exercise 10 test
        System.out.println("\n--- Testing Exercise 10 ---");

        CivilService civil = new CivilService();
        System.out.println("Civil service days left: " + civil.getDaysLeft());
        civil.work();
        System.out.println("After 1 day of work: " + civil.getDaysLeft());

        MilitaryService military = new MilitaryService(180);
        System.out.println("\nMilitary service days left: " + military.getDaysLeft());
        military.work();
        System.out.println("After 1 day of work: " + military.getDaysLeft());

        // Test that days don't go negative
        MilitaryService shortService = new MilitaryService(1);
        shortService.work();
        System.out.println("\nShort service after 1 day: " + shortService.getDaysLeft());
        shortService.work();
        System.out.println("After working again (should stay 0): " + shortService.getDaysLeft());
    }
}

// RegistrationPlate class (Exercise 9.1)
class RegistrationPlate {
    private final String regCode;
    private final String country;

    public RegistrationPlate(String country, String regCode) {
        this.regCode = regCode;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + regCode;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        if (this == object) {
            return true;
        }
        RegistrationPlate compared = (RegistrationPlate) object;
        return this.regCode.equals(compared.regCode) &&
                this.country.equals(compared.country);
    }

    @Override
    public int hashCode() {
        return this.regCode.hashCode() + this.country.hashCode();
    }
}

// VehicleRegister class (Exercise 9.2 and 9.3)
class VehicleRegister {
    private HashMap<RegistrationPlate, String> owners;

    public VehicleRegister() {
        this.owners = new HashMap<RegistrationPlate, String>();
    }

    public boolean add(RegistrationPlate plate, String owner) {
        if (this.owners.containsKey(plate)) {
            return false;
        }
        this.owners.put(plate, owner);
        return true;
    }

    public String get(RegistrationPlate plate) {
        return this.owners.get(plate);
    }

    public boolean delete(RegistrationPlate plate) {
        if (this.owners.containsKey(plate)) {
            this.owners.remove(plate);
            return true;
        }
        return false;
    }

    public void printRegistrationPlates() {
        for (RegistrationPlate plate : this.owners.keySet()) {
            System.out.println(plate);
        }
    }

    public void printOwners() {
        ArrayList<String> printedOwners = new ArrayList<String>();

        for (String owner : this.owners.values()) {
            if (!printedOwners.contains(owner)) {
                System.out.println(owner);
                printedOwners.add(owner);
            }
        }
    }
}

// Exercise 10: NationalService interface
interface NationalService {
    int getDaysLeft();
    void work();
}

// Exercise 10.1: CivilService
class CivilService implements NationalService {
    private int daysLeft;

    public CivilService() {
        this.daysLeft = 362;
    }

    @Override
    public int getDaysLeft() {
        return this.daysLeft;
    }

    @Override
    public void work() {
        if (this.daysLeft > 0) {
            this.daysLeft--;
        }
    }
}

// Exercise 10.2: MilitaryService
class MilitaryService implements NationalService {
    private int daysLeft;

    public MilitaryService(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    @Override
    public int getDaysLeft() {
        return this.daysLeft;
    }

    @Override
    public void work() {
        if (this.daysLeft > 0) {
            this.daysLeft--;
        }
    }
}