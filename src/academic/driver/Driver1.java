package academic.driver;

/**
 * @author 12S24025-Paula Gevriella Tambunan
 */

import academic.model.Course;
import java.util.Scanner;
import java.util.ArrayList; // Using ArrayList for dynamic array size as specified by "array" media

public class Driver1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Using ArrayList to dynamically manage the array of courses
        ArrayList<Course> courses = new ArrayList<>();

        while (input.hasNextLine()) {
            String line = input.nextLine();

            // Check for termination command
            if (line.equals("---")) {
                break;
            }

            // Process course data
            String[] segments = line.split("#");
            if (segments.length == 4) {
                String code = segments[0];
                String name = segments[1];
                int credits = Integer.parseInt(segments[2]);
                String grade = segments[3]; // Assuming the 4th segment is 'grade' as per example

                Course newCourse = new Course(code, name, credits, grade);
                courses.add(newCourse);
            } else {
                // Optional: Handle malformed input lines
                // System.err.println("Skipping malformed input: " + line);
            }
        }

        // Display all stored courses
        for (Course course : courses) {
            System.out.println(course.getCourseDetails());
        }

        input.close();
    }
}
