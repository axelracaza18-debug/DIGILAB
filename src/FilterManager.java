import java.util.ArrayList;

public class FilterManager {

    public static void showPatientsOlderThan(ArrayList<Patient> patients, int age) {

        boolean found = false;

        for (Patient p : patients) {

            if (p.age > age) {

                System.out.println("--------------------");
                System.out.println("ID   : " + p.id);
                System.out.println("Name : " + p.name);
                System.out.println("Age  : " + p.age);

                found = true;
            }
        }

        if (!found) {
            System.out.println("No patients found.");
        }
    }

}