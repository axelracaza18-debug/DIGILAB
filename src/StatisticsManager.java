import java.util.ArrayList;

public class StatisticsManager {

    public static void showStatistics(ArrayList<Patient> patients) {

        if (patients.isEmpty()) {

            System.out.println("No patients found.");

        } else {

            System.out.println("\n=== PATIENT STATISTICS ===");
            System.out.println("Total Patients: " + patients.size());

            int totalAge = 0;

            Patient oldestPatient = patients.get(0);
            Patient youngestPatient = patients.get(0);

            for (Patient p : patients) {

                totalAge += p.age;

                if (p.age > oldestPatient.age) {
                    oldestPatient = p;
                }

                if (p.age < youngestPatient.age) {
                    youngestPatient = p;
                }
            }

            double averageAge = (double) totalAge / patients.size();

            System.out.println("Average Age: " + averageAge);
            System.out.println("Oldest Patient: " + oldestPatient.name + " (" + oldestPatient.age + ")");
            System.out.println("Youngest Patient: " + youngestPatient.name + " (" + youngestPatient.age + ")");
        }
    }

}