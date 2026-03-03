package academic.model;

/**
 * @author 12S24025-Paula Gevriella Tambunan
 */

    public class Student {
        private String id;
        private String name;
        private int year;
        private String program; // <--- PASTIKAN ATRIBUT INI ADA

        // Konstruktor asli (yang 3 argumen) - TIDAK DIUBAH untuk Task 1
        public Student(String id, String name, int year) {
            this.id = id;
            this.name = name;
            this.year = year;
            this.program = ""; // Diinisialisasi default agar tidak null jika digunakan oleh Task 1
        }

        // Konstruktor OVERLOADED (yang 4 argumen) - Ini yang dibutuhkan Driver2
        public Student(String id, String name, int year, String program) { // <--- PASTIKAN KONSTRUKTOR INI ADA
            this(id, name, year); // Memanggil konstruktor 3 argumen di atas
            this.program = program; // Menginisialisasi atribut program
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getYear() {
            return year;
        }

        public String getProgram() { // <--- PASTIKAN GETTER INI ADA
            return program;
        }

        public String getStudentDetails() { // Metode untuk format output Task 2
            return id + "|" + name + "|" + year + "|" + program;
        }

        @Override
        public String toString() {
            return getStudentDetails();
        }
    }
    
