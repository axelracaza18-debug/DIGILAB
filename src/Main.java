import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Patient> patients = new ArrayList<>();

        boolean running = true;

        while (running) {

            System.out.println("\n================================");
            System.out.println("      DIGILAB HOSPITAL SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {

                case 1:

                    Patient patient = new Patient();

                    System.out.print("Enter patient name: ");
                    patient.name = scanner.nextLine();

                    System.out.print("Enter patient age: ");
                    patient.age = scanner.nextInt();
                    scanner.nextLine();

                    patients.add(patient);

                    System.out.println("Patient added successfully!");
                    break;

                case 2:

                    System.out.println("\n=== PATIENT LIST ===");

                    if (patients.isEmpty()) {
                        System.out.println("No patients found.");
                    } else {

                        for (Patient p : patients) {
                            System.out.println("--------------------");
                            System.out.println("Name: " + p.name);
                            System.out.println("Age : " + p.age);
                        }

                        System.out.println("--------------------");
                        System.out.println("Total Patients: " + patients.size());
                    }

                    break;

                case 3:

                    running = false;
                    System.out.println("Closing DIGILAB...");
                    break;

                default:

                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}