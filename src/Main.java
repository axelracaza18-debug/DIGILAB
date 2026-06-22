import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void savePatients(ArrayList<Patient> patients) {

        try {

            FileWriter writer = new FileWriter("patients.txt");

            for (Patient p : patients) {

                writer.write(
                        p.id + "," +
                                p.name + "," +
                                p.age + "\n"
                );
            }

            writer.close();

            System.out.println("Patients saved successfully!");

        } catch (IOException e) {

            System.out.println("Error saving patients.");
        }
    }
    public static void loadPatients(ArrayList<Patient> patients) {

        try {

            BufferedReader reader = new BufferedReader(new FileReader("patients.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) continue;

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);

                patients.add(new Patient(id, name, age));
            }

            reader.close();

            System.out.println("Patients loaded successfully!");

        } catch (IOException e) {

            System.out.println("No saved patients found.");
        }
    }
    public static int getNextId(ArrayList<Patient> patients) {

        int highestId = 0;

        for (Patient p : patients) {

            if (p.id > highestId) {
                highestId = p.id;
            }
        }

        return highestId + 1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Patient> patients = new ArrayList<>();

        loadPatients(patients);

        int nextId = getNextId(patients);
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
            System.out.println("Choose an option:  ");

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

                    nextId = getNextId(patients);// 👈 increase ID for next patient
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

                        System.out.println("\n1. Delete Patient");
                        System.out.println("2. Return to Main Menu");
                        System.out.print("Choose an option: ");

                        int subChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (subChoice) {

                            case 1:

                                System.out.print("Enter Patient ID to delete: ");
                                int deleteId = scanner.nextInt();
                                scanner.nextLine();

                                boolean found = false;

                                for (int i = 0; i < patients.size(); i++) {

                                    if (patients.get(i).id == deleteId) {

                                        patients.remove(i);

                                        System.out.println("Patient deleted successfully!");
                                        found = true;
                                        break;
                                    }
                                }

                                if (!found) {
                                    System.out.println("Patient ID not found.");
                                }

                                break;

                            case 2:

                                System.out.println("Returning to Main Menu...");
                                break;

                            default:

                                System.out.println("Invalid option.");
                        }
                    }

                    break;
                case 3:

                    System.out.print("Enter Patient ID to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();

                    boolean found = false;

                    for (Patient p : patients) {

                        if (p.id == searchId) {

                            System.out.println("\n=== PATIENT FOUND ===");
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

                case 4:

                    System.out.print("Enter Patient ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    boolean updated = false;

                    for (Patient p : patients) {

                        if (p.id == updateId) {

                            System.out.println("\nCurrent Information:");
                            System.out.println("Name: " + p.name);
                            System.out.println("Age : " + p.age);

                            System.out.print("Enter new name: ");
                            String newName = scanner.nextLine();

                            System.out.print("Enter new age: ");
                            int newAge = scanner.nextInt();
                            scanner.nextLine();

                            p.name = newName;
                            p.age = newAge;

                            System.out.println("Patient updated successfully!");

                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Patient not found.");
                    }

                    break;

                case 5:

                    savePatients(patients);

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