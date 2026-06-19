import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("      DIGILAB HOSPITAL SYSTEM");
        System.out.println("================================");

        ArrayList<Patient> patients = new ArrayList<>();

        Patient patient1 = new Patient();
        patient1.name = "Axel";
        patient1.age = 22;

        Patient patient2 = new Patient();
        patient2.name = "John";
        patient2.age = 35;

        Patient patient3 = new Patient();
        patient3.name = "Sarah";
        patient3.age = 28;

        patients.add(patient1);
        patients.add(patient2);
        patients.add(patient3);

        System.out.println("\nPATIENT LIST");
        System.out.println("----------------------------");

        for (Patient patient : patients) {
            System.out.println("Name: " + patient.name);
            System.out.println("Age : " + patient.age);
            System.out.println("----------------------------");
        }

        System.out.println("Total Patients: " + patients.size());
    }
}