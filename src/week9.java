import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Exercise 17.1
interface UserInterface {
    void update();
}

// Exercise 17.2
class TextUserInterface implements UserInterface {

    @Override
    public void update() {
        System.out.println("Updating the user interface");
    }
}

// Exercise 17.3:
class ApplicationLogic {
    private UserInterface ui;

    public ApplicationLogic(UserInterface ui) {
        this.ui = ui;
    }

    public void execute(int howManyTimes) {
        for (int i = 0; i < howManyTimes; i++) {
            System.out.println("The application logic works");
            ui.update();
        }
    }
}

// Exercise 20
interface Sensor {
    boolean isOn();
    void on();
    void off();
    int measure();

}

// Exercise 20.1
class ConstantSensor implements Sensor {
    private int value;

    public ConstantSensor(int value) {
        this.value = value;
    }

    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void on() {
    }

    @Override
    public void off() {
    }

    @Override
    public int measure() {
        return this.value;
    }
}

// Exercise 20.2
class Thermometer implements Sensor {
    private boolean on;
    private Random random;

    public Thermometer() {
        this.on = false;
        this.random = new Random();
    }

    @Override
    public boolean isOn() {
        return this.on;
    }

    @Override
    public void on() {
        this.on = true;
    }

    @Override
    public void off() {
        this.on = false;
    }

    @Override
    public int measure() {
        if (!this.on) {
            throw new IllegalStateException("Thermometer is off");
        }
        return this.random.nextInt(61) - 30;
    }
}

// Exercise 20.3
class AverageSensor implements Sensor {
    private List<Sensor> sensors;
    private List<Integer> readings; // Exercise 20.4

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>(); // Exercise 20.4
    }

    public void addSensor(Sensor additional) {
        this.sensors.add(additional);
    }

    @Override
    public boolean isOn() {
        // average sensor is on when all its sensors are on
        if (this.sensors.isEmpty()) {
            return false;
        }

        for (Sensor sensor : this.sensors) {
            if (!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void on() {
        for (Sensor sensor : this.sensors) {
            sensor.on();
        }
    }

    @Override
    public void off() {
        for (Sensor sensor : this.sensors) {
            sensor.off();
        }
    }

    @Override
    public int measure() {
        if (!this.isOn() || this.sensors.isEmpty()) {
            throw new IllegalStateException("AverageSensor is off or has no sensors");
        }

        int sum = 0;
        for (Sensor sensor : this.sensors) {
            sum += sensor.measure();
        }

        int average = sum / this.sensors.size();
        this.readings.add(average); // Exercise 20.4
        return average;
    }

    // Exercise 20.4
    public List<Integer> readings() {
        return this.readings;
    }
}

public class week9 {
    public static void main(String[] args) {
        System.out.println("=== Exercise 17 Testing ===");
        // Testing Exercise 17 implementation
        UserInterface ui = new TextUserInterface();
        new ApplicationLogic(ui).execute(3);

        System.out.println("\n=== Exercise 20.1 Testing ===");
        // Testing ConstantSensor
        ConstantSensor ten = new ConstantSensor(10);
        ConstantSensor minusFive = new ConstantSensor(-5);

        System.out.println(ten.measure());
        System.out.println(minusFive.measure());

        System.out.println(ten.isOn());
        ten.off();
        System.out.println(ten.isOn());

        System.out.println("\n=== Exercise 20.2 Testing ===");
        // Testing Thermometer
        Sensor kumpula = new Thermometer();
        kumpula.on();
        System.out.println("the temperature in Kumpula is " + kumpula.measure() + " degrees");

        System.out.println("\n=== Exercise 20.3 Testing ===");
        // Testing AverageSensor
        Sensor kaisaniemi = new Thermometer();
        Sensor helsinkiVantaa = new Thermometer();

        AverageSensor helsinkiArea = new AverageSensor();
        helsinkiArea.addSensor(kumpula);
        helsinkiArea.addSensor(kaisaniemi);
        helsinkiArea.addSensor(helsinkiVantaa);

        helsinkiArea.on();
        System.out.println("the temperature in Helsinki area is " + helsinkiArea.measure() + " degrees");

        System.out.println("\n=== Exercise 20.4 Testing ===");
        // Testing readings() method
        System.out.println("the temperature in Helsinki area is " + helsinkiArea.measure() + " degrees");
        System.out.println("the temperature in Helsinki area is " + helsinkiArea.measure() + " degrees");

        System.out.println("readings: " + helsinkiArea.readings());
    }
}