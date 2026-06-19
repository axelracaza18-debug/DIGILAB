import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Patient> patients = new ArrayList<>();

        int nextId = 1; // 👈 NEW: ID generator

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
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter patient name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter patient age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();


                    Patient patient = new Patient(nextId, name, age);
                    patients.add(patient);

                    System.out.println("Patient added successfully! ID: " + nextId);

                    nextId++; // 👈 increase ID for next patient
                    break;

                case 2:

                    System.out.println("\n=== PATIENT LIST ===");

                    if (patients.isEmpty()) {
                        System.out.println("No patients found.");
                    } else {

                        for (Patient p : patients) {
                            System.out.println("--------------------");
                            System.out.println("ID   : " + p.id);
                            System.out.println("Name : " + p.name);
                            System.out.println("Age  : " + p.age);
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