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
 */
public class Driver3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Menggunakan ArrayList untuk mengelola array Enrollment secara dinamis
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        while (input.hasNextLine()) {
            String line = input.nextLine();

            // Cek perintah berhenti
            if (line.equals("---")) {
                break;
            }

            // Proses data enrollment
            String[] segments = line.split("#");
            // Input memiliki 4 segmen: Course Code, Student ID, Academic Year, Semester
            if (segments.length == 4) {
                String courseCode = segments[0];
                String studentId = segments[1];
                String academicYear = segments[2];
                String semester = segments[3];

                // Memanggil konstruktor Enrollment yang baru
                Enrollment newEnrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                enrollments.add(newEnrollment);
            } else {
                // Opsional: Tangani input yang formatnya salah
                // System.err.println("Melewatkan input yang salah format: " + line);
            }
        }

        // Tampilkan semua enrollments yang tersimpan
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.getEnrollmentDetails());
        }

        input.close();
    }
}
