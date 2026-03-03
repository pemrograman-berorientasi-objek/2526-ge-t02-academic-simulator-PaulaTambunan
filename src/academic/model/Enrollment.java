package academic.model;

/**
 * @author 12S24025-Paula Gevriella Tambunan
 */
public class Enrollment {
    private String courseCode;   // Diganti dari objek Course
    private String studentId;    // Diganti dari objek Student
    private String academicYear; // Atribut baru
    private String semester;     // Atribut baru
    private String grade;        // Akan kita default menjadi "None"

    public Enrollment(String courseCode, String studentId, String academicYear, String semester) {
        this.courseCode = courseCode;
        this.studentId = studentId;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = "None"; // Menginisialisasi grade secara default menjadi "None"
    }

    // Getters untuk semua atribut
    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getSemester() {
        return semester;
    }

    public String getGrade() {
        return grade;
    }

    // Metode untuk mendapatkan detail Enrollment dalam format output yang diminta
    public String getEnrollmentDetails() {
        return courseCode + "|" + studentId + "|" + academicYear + "|" + semester + "|" + grade;
    }

    @Override
    public String toString() {
        return getEnrollmentDetails();
    }
}
