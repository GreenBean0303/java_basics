import java.util.ArrayList;
import java.util.List;

public class week10 {
    //Exercise 28 and 29

    public static void printDepartment(List<Person> people) {
        for (Person person : people) {
            System.out.println(person);
        }
    }

    public static void main(String[] args) {
        System.out.println("Exercise 28.1");
        Organism organism = new Organism(20, 30);
        System.out.println(organism);
        organism.move(-10, 5);
        System.out.println(organism);
        organism.move(50, 20);
        System.out.println(organism);

        System.out.println();

        System.out.println("Exercise 28.2");
        Group group = new Group();
        group.addToGroup(new Organism(73, 56));
        group.addToGroup(new Organism(57, 66));
        group.addToGroup(new Organism(46, 52));
        group.addToGroup(new Organism(19, 107));
        System.out.println(group);

        System.out.println();

        System.out.println("Exercise 29.1");
        Person pekka = new Person("Pekka Mikkola",  "Korsontie Street 1 03100 Vantaa");
        Person esko = new Person("Esko Ukkonen", "Mannerheimintie Street 15 00100 Helsinki");
        System.out.println(pekka);
        System.out.println(esko);

        System.out.println();

        System.out.println("Exercise 29.2");
        Student olli = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki");
        System.out.println(olli);
        System.out.println("credits " + olli.credits());
        olli.study();
        System.out.println("credits "+ olli.credits());

        System.out.println();

        System.out.println("Exercise 29.3");
        Student olli2 = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki");
        System.out.println(olli2);
        olli2.study();
        System.out.println(olli2);
        System.out.println();

        System.out.println("Exercise 29.4");
        Teacher pekkaTeacher = new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200);
        Teacher eskoTeacher = new Teacher("Esko Ukkonen", "Mannerheimintie Street 15 00100 Helsinki", 5400);
        System.out.println(pekkaTeacher);
        System.out.println(eskoTeacher);

        Student olli3 = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki");
        for (int i = 0; i < 25; i++) {
            olli3.study();
        }

        System.out.println(olli3);
        System.out.println();

        System.out.println("Exercise 29.5");
        List<Person> people = new ArrayList<Person>();
        people.add(new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200));
        people.add(new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki"));

        printDepartment(people);

        System.out.println();

        //Test group movement
        System.out.println("Testing nested Groups");
        Group group1 = new Group();
        group1.addToGroup(new Organism(1, 1));
        group1.addToGroup(new Organism(2, 2));

        Group group2 = new Group();
        group2.addToGroup(new Organism(10, 10));
        group2.addToGroup(new Organism(20, 20));

        Group mainGroup = new Group();
        mainGroup.addToGroup(group1);
        mainGroup.addToGroup(group2);

        System.out.println("Main group before moving:");
        System.out.println(mainGroup);

        System.out.println("\nMoving main group by (5, 5):");
        mainGroup.move(5, 5);
        System.out.println(mainGroup);
    }
}

interface Movable {
    void move(int dx, int dy);
}

class Organism implements Movable {
    private int x;
    private int y;

    public Organism(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x: " + this.x + "; y: " + this.y;
    }

    @Override
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
}

class Group implements Movable {
    private ArrayList<Movable> movables;

    public Group() {
        this.movables = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Movable movable : this.movables) {
            result.append(movable.toString()).append("\n");
        }
        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }
        return result.toString();
    }

    public void addToGroup(Movable movable) {
        this.movables.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable movable : this.movables) {
            movable.move(dx, dy);
        }
    }
}

class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return this.name + "\n  " + this.address;
    }
}

class Student extends Person {
    private int credits;

    public Student(String name, String address) {
        super(name, address);
        this.credits = 0;
    }

    public int credits() {
        return this.credits;
    }

    public void study() {
        this.credits++;
    }

    @Override
    public String toString() {
        return super.toString() + "\n  credits " + this.credits;
    }
}

class Teacher extends Person {
    private int salary;

    public Teacher(String name, String address, int salary) {
        super(name, address);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + "\n  salary " + this.salary + " euros/month";
    }
}