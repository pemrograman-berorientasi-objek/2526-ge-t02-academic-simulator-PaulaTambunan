package academic.driver;

/**
 * @author 12S24025-Paula Gevriella Tambunan
 */
import academic.model.Enrollment;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Driver class for Task 3: Simulating storage of multiple Enrollment objects
 * using an array and handling interactive user input.
 * Now refactored with a dedicated function for adding enrollments.
 */
public class Driver3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        while (input.hasNextLine()) {
            String line = input.nextLine();

            // Cek perintah berhenti
            if (line.equals("---")) {
                break;
            }

            String actualDataLine = line; 

            // Cek apakah baris input diawali dengan "enrollment-add#"
            if (line.startsWith("enrollment-add#")) {
                String[] parts = line.split("#", 2);
                if (parts.length > 1) {
                    actualDataLine = parts[1]; // Ambil bagian data setelah prefix
                } else {
                    // Jika hanya ada "enrollment-add" tanpa data, abaikan atau log error
                    continue; 
                }
            }
            // else: Jika tidak diawali "enrollment-add#", maka actualDataLine tetap 'line' aslinya.

            // Panggil fungsi baru untuk memproses dan menambahkan enrollment
            addEnrollment(actualDataLine, enrollments);
        }

        // Tampilkan semua enrollments yang tersimpan
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.getEnrollmentDetails());
        }

        input.close();
    }

    /**
     * Helper method to parse enrollment data from a string and add it to the list.
     * @param dataLine The string containing enrollment details (e.g., "12S2203#12S20999#2021/2022#even")
     * @param enrollments The ArrayList to which the new Enrollment object will be added.
     */
    private static void addEnrollment(String dataLine, ArrayList<Enrollment> enrollments) {
        String[] segments = dataLine.split("#");
        // Input Enrollment memiliki 4 segmen: Course Code, Student ID, Academic Year, Semester
        if (segments.length == 4) {
            String courseCode = segments[0];
            String studentId = segments[1];
            String academicYear = segments[2];
            String semester = segments[3];

            Enrollment newEnrollment = new Enrollment(courseCode, studentId, academicYear, semester);
            enrollments.add(newEnrollment);
        } else {
            // Opsional: Tangani input data pendaftaran yang formatnya salah
            // System.err.println("Melewatkan input pendaftaran yang salah format: " + dataLine);
        }
    }
}
