package academic.driver;

/**
 * @author 12S24025-Paula Gevriella Tambunan
 */
import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;

import java.util.Scanner;
import java.util.ArrayList;

public class Driver4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Menggunakan ArrayList terpisah untuk setiap jenis entitas
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        while (input.hasNextLine()) {
            String line = input.nextLine();

            // Cek perintah berhenti
            if (line.equals("---")) {
                break;
            }

            // Pisahkan perintah dari data
            String[] parts = line.split("#", 2); // Split hanya pada '#' pertama
            String command = parts[0];
            String data = parts.length > 1 ? parts[1] : ""; // Ambil sisa string setelah command

            String[] segments; // Untuk menyimpan segmen data setelah di-split lagi

            switch (command) {
                case "course-add":
                    segments = data.split("#");
                    if (segments.length == 4) {
                        String code = segments[0];
                        String name = segments[1];
                        int credits = Integer.parseInt(segments[2]);
                        String grade = segments[3];
                        Course newCourse = new Course(code, name, credits, grade);
                        courses.add(newCourse);
                    }
                    break;
                case "student-add":
                    segments = data.split("#");
                    if (segments.length == 4) {
                        String id = segments[0];
                        String name = segments[1];
                        int year = Integer.parseInt(segments[2]);
                        String program = segments[3];
                        Student newStudent = new Student(id, name, year, program);
                        students.add(newStudent);
                    }
                    break;
                case "enrollment-add":
                    segments = data.split("#");
                    if (segments.length == 4) { // Input Enrollment memiliki 4 segmen data
                        String courseCode = segments[0];
                        String studentId = segments[1];
                        String academicYear = segments[2];
                        String semester = segments[3];
                        Enrollment newEnrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                        enrollments.add(newEnrollment);
                    }
                    break;
                default:
                    
                    break;
            }
        }

        // Tampilkan semua Course
        for (Course course : courses) {
            System.out.println(course.getCourseDetails());
        }

        // Tampilkan semua Student
        for (Student student : students) {
            System.out.println(student.getStudentDetails());
        }

        // Tampilkan semua Enrollment
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }

        input.close();
    }
}
