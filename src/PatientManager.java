import java.util.ArrayList;
import java.io.*;

public class PatientManager {

    public static void savePatients(ArrayList<Patient> patients) {

        try {

            FileWriter writer = new FileWriter("patients.txt");

            for (Patient p : patients) {

                writer.write(p.getId() + "," + p.getName() + "," + p.getAge() + "\n");
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving patients.");
        }
    }

    public static void loadPatients(ArrayList<Patient> patients) {

        try {

            BufferedReader reader = new BufferedReader(new FileReader("patients.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);

                patients.add(new Patient(id, name, age));
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("No saved patients found.");
        }
    }

    public static int getNextId(ArrayList<Patient> patients) {

        int highestId = 0;

        for (Patient p : patients) {
            if (p.getId() > highestId) {
                highestId = p.getId();
            }
        }

        return highestId + 1;
    }
}