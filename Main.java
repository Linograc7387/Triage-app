import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TriageSystem triage = new TriageSystem();

        // Sample patients
        triage.addPatient("Alice", 30, 10, 10, 10);
        triage.addPatient("Bob", 35, 5, 10, 10);
        triage.addPatient("Carl", 20, 20, 10, 10);
        triage.addPatient("Dana", 25, 15, 10, 10);
        triage.addPatient("Eric", 10, 10, 10, 10);
        triage.addPatient("Frank", 40, 20, 20, 20);
        triage.addPatient("Gina", 25, 10, 15, 10);
        triage.addPatient("Hank", 30, 5, 10, 5);
        triage.addPatient("Iris", 20, 10, 15, 10);
        triage.addPatient("Jake", 35, 10, 10, 10);

        // Print sorted patient list
        triage.printPatients();

        System.out.println("\nChoose starting index (0 to " + (triage.size() - 1) + "): ");
        int start = scanner.nextInt();

        System.out.println("\nChoose treatment mode:");
        System.out.println("1 = Single Direction");
        System.out.println("2 = Outward Alternating");
        int mode = scanner.nextInt();

        System.out.println("\n--- TREATMENT ORDER ---");

        if (mode == 1) {

            System.out.println("Choose direction (1 = move right, -1 = move left): ");
            int direction = scanner.nextInt();

            triage.setStartPoint(start, direction);

            Patient treated;

            while ((treated = triage.treatNext()) != null) {
                System.out.println("Treating: " + treated);
            }

        }
        else if (mode == 2) {

            triage.treatOutward(start);

        }
        else {

            System.out.println("Invalid mode selected.");

        }

        System.out.println("\nReached end of treatment queue.");

        scanner.close();
    }
}