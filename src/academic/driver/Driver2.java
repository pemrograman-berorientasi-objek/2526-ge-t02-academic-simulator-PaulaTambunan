package academic.driver;

/**
 * @author 12S24025-Paula Gevriella Tambunan
 */

import academic.model.Student;
import java.util.Scanner;
import java.util.ArrayList;

public class Driver2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (input.hasNextLine()) {
            String line = input.nextLine();

            if (line.equals("---")) {
                break;
            }

            String[] segments = line.split("#");
            if (segments.length == 4) {
                String id = segments[0];
                String name = segments[1];
                int year = Integer.parseInt(segments[2]);
                String program = segments[3];

                // Memanggil konstruktor overloaded yang baru
                Student newStudent = new Student(id, name, year, program);
                students.add(newStudent);
            } else {
                // Opsional: Tangani input yang formatnya salah
                // System.err.println("Melewatkan input yang salah format: " + line);
            }
        }

        for (Student student : students) {
            System.out.println(student.getStudentDetails());
        }

        input.close();
    }
}
