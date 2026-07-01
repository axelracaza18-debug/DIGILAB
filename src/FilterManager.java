import java.util.ArrayList;

public class FilterManager {

    public static void showPatientsOlderThan(ArrayList<Patient> patients, int age) {

        boolean found = false;

        for (Patient p : patients) {

            if (p.getAge() > age) {

                printPatient(p);

                found = true;
            }
        }

        if (!found) {
            System.out.println("No patients found.");
        }
    }

    public static void showPatientsYoungerThan(ArrayList<Patient> patients, int age) {

        boolean found = false;

        for (Patient p : patients) {

            if (p.getAge() < age) {

                printPatient(p);

                found = true;
            }
        }

        if (!found) {
            System.out.println("No patients found.");
        }
    }
    public static void showPatientsBetween(ArrayList<Patient> patients, int minAge, int maxAge) {
        boolean found = false;

        for (Patient p : patients) {

            if (p.getAge() >= minAge && p.getAge() <= maxAge) {

                printPatient(p);

                found = true;
            }
        }

        if (!found) {
            System.out.println("No patients found.");
        }

    }
    private static void printPatient(Patient p) {


        System.out.println(p);

    }
}