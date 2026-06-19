public class Main {

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("      DIGILAB HOSPITAL SYSTEM");
        System.out.println("================================");

        Patient patient = new Patient();

        patient.name = "Axel";
        patient.age = 22;

        System.out.println();
        System.out.println("Patient Information");
        System.out.println("-------------------");
        System.out.println("Name: " + patient.name);
        System.out.println("Age : " + patient.age);
    }
}