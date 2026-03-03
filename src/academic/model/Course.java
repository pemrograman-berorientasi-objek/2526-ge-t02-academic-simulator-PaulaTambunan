package academic.model;

/**
 * @author 12S24025-Paula Gevriella Tambunan
 */
public class Course {
    private String code;
    private String name;
    private int credits;
    private String grade; // Assuming 'C' or 'D' from input example is a default grade for the course or an indicator

    public Course(String code, String name, int credits, String grade) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getGrade() {
        return grade;
    }

    // Method to get course details in the specified output format
    public String getCourseDetails() {
        return code + "|" + name + "|" + credits + "|" + grade;
    }

    @Override
    public String toString() {
        return getCourseDetails();
    }
}
