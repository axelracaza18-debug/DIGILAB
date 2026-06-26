import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Patient> patients = new ArrayList<>();

        PatientManager.loadPatients(patients);

        boolean running = true;

        while (running) {

            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Update Patient");
            System.out.println("5. Delete Patient");
            System.out.println("6. Patient Statistics");
            System.out.println("7. Sort Patients");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                // ADD
                case 1:
                    String name;

                    do {
                        System.out.print("Enter patient name: ");
                        name = scanner.nextLine();

                        if (name.trim().isEmpty()) {
                            System.out.println("Name cannot be empty.");
                        }

                    } while (name.trim().isEmpty());

                    int age;

                    do {
                        System.out.print("Enter patient age: ");
                        age = scanner.nextInt();
                        scanner.nextLine();

                        if (age <= 0) {
                            System.out.println("Age must be greater than 0.");
                        }

                    } while (age <= 0);

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

                    System.out.print("Enter Patient Name: ");
                    String searchName = scanner.nextLine();

                    boolean found = false;

                    for (Patient p : patients) {

                        if (p.name.toLowerCase().contains(searchName.toLowerCase())) {

                            System.out.println("\n=== PATIENT FOUND ===");
                            System.out.println("ID   : " + p.id);
                            System.out.println("Name : " + p.name);
                            System.out.println("Age  : " + p.age);

                            found = true;
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

                case 5:

                    System.out.print("Enter Patient ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    boolean deleted = false;

                    for (int i = 0; i < patients.size(); i++) {

                        if (patients.get(i).id == deleteId) {

                            patients.remove(i);

                            PatientManager.savePatients(patients);

                            System.out.println("Patient deleted successfully!");

                            deleted = true;
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Patient ID not found.");
                    }

                    break;

                    case 6:

                    StatisticsManager.showStatistics(patients);

                    break;




                case 7:

                    System.out.println("\n=== SORT PATIENTS ===");
                    System.out.println("1. Sort by ID");
                    System.out.println("2. Sort by Name");
                    System.out.print("Choose option: ");

                    int sortChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (sortChoice) {

                        case 1:

                            Collections.sort(patients,
                                    Comparator.comparingInt(p -> p.id));

                            System.out.println("Patients sorted by ID.");
                            break;

                        case 2:

                            Collections.sort(patients,
                                    Comparator.comparing(p -> p.name));

                            System.out.println("Patients sorted by Name.");
                            break;

                        default:

                            System.out.println("Invalid option.");
                    }

                    break;

                case 8:

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