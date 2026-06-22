import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Patient> patients = new ArrayList<>();

        PatientManager.loadPatients(patients);

        boolean running = true;

        while (running) {

            System.out.println("\n================================");
            System.out.println("      DIGILAB HOSPITAL SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Update Patient");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                // ADD
                case 1:
                    System.out.print("Enter patient name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter patient age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    int id = PatientManager.getNextId(patients);

                    patients.add(new Patient(id, name, age));
                    PatientManager.savePatients(patients);

                    System.out.println("Patient added successfully! ID: " + id);
                    break;

                // VIEW
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
                    }
                    break;

                // SEARCH
                case 3:
                    System.out.print("Enter Patient ID: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();

                    boolean found = false;

                    for (Patient p : patients) {
                        if (p.id == searchId) {
                            System.out.println("\n=== FOUND ===");
                            System.out.println("ID   : " + p.id);
                            System.out.println("Name : " + p.name);
                            System.out.println("Age  : " + p.age);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Patient not found.");
                    }
                    break;

                // UPDATE
                case 4:
                    System.out.print("Enter Patient ID: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    boolean updated = false;

                    for (Patient p : patients) {
                        if (p.id == updateId) {

                            System.out.println("Current Name: " + p.name);
                            System.out.println("Current Age : " + p.age);

                            System.out.print("New Name: ");
                            p.name = scanner.nextLine();

                            System.out.print("New Age: ");
                            p.age = scanner.nextInt();
                            scanner.nextLine();

                            PatientManager.savePatients(patients);

                            System.out.println("Updated successfully!");
                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Patient not found.");
                    }
                    break;

                // EXIT
                case 5:
                    PatientManager.savePatients(patients);
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