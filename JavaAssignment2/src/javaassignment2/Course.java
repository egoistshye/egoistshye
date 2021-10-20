package javaassignment2;

/**
 *
 * @author Ben Platt
 */
class Course {


    public Student[] studentArray;
    public String courseName;
    public String instructor;
    public int totalStudents;
    public float maleStudents;
    public float femaleStudents;
    public float femaleStPerc;
    public float maleStPerc;

    public Course() {
        studentArray = new Student[20];
        for (int i = 0; i < studentArray.length; i++) {
            studentArray[i] = new Student();
        }
        this.courseName = "";
        this.instructor = "";
        this.totalStudents = 0;
        this.maleStudents = 0;
        this.femaleStudents = 0;
        this.maleStPerc = 0;
        this.femaleStPerc = 0;
    }

    public Course(String cName_, String instructor_) {
        this.courseName = cName_;
        this.instructor = instructor_;

        studentArray = new Student[20];
        for (int i = 0; i < studentArray.length; i++) {
            studentArray[i] = new Student();
        }

        this.totalStudents = 0;
        this.maleStudents = 0;
        this.femaleStudents = 0;
        this.maleStPerc = 0;
        this.femaleStPerc = 0;
    }

    public void print() {
        System.out.println("Address : " + studentArray[0].address);
    }

    public boolean isValidData(Student st) {
        if (st.name == "" || st.DOB == "" || st.address == "" || st.gender == "") {
            return false;
        }
        return true;
    }

    public void addStudent(Student st) {
        if (isValidData(st)) {
            if (totalStudents < 20) {
                for (int i = 0; i < studentArray.length; i++) {
                    if (!isValidData(studentArray[i])) {
                        studentArray[i].name = st.name;
                        studentArray[i].DOB = st.DOB;
                        studentArray[i].address = st.address;
                        studentArray[i].gender = st.gender;
                        totalStudents++;

                        if (studentArray[i].gender.trim().equals("Male")) {
                            maleStudents++;
                        } else if (studentArray[i].gender.trim().equals("Female")) {
                            femaleStudents++;
                        }
                        break;
                    }
                }
            } else {
                System.out.println("Students in this Course are maximum.");
            }
        } else {
            System.out.println("Empty OR invalid data fields, FAILED to add.");
        }

        femaleStPerc = (femaleStudents / totalStudents) * 100;
        maleStPerc = (maleStudents / totalStudents) * 100;
    }

    public void deleteStudent(String name_) {
        boolean found = false;
        if (totalStudents > 0) {
            for (int i = 0; i < studentArray.length; i++) {
                if (studentArray[i].name == name_) {
                    studentArray[i].name = "";
                    studentArray[i].DOB = "";
                    studentArray[i].address = "";
                    if (studentArray[i].gender == "Male") {
                        maleStudents--;
                    } else if (studentArray[i].gender == "Female") {
                        femaleStudents--;
                    }
                    studentArray[i].gender = "";
                    totalStudents--;
                    found = true;
                }
            }
        }

        if (found == false) {
            System.out.println("No such Student is enrolled in the Course.");
        }

        femaleStPerc = (femaleStudents / totalStudents) * 100;
        maleStPerc = (maleStudents / totalStudents) * 100;
    }

    public void search(String name_) {
        boolean found = false;

        femaleStPerc = (femaleStudents / totalStudents) * 100;
        maleStPerc = (maleStudents / totalStudents) * 100;

        System.out.println("======= COURSE DETAILS =======");
        System.out.println("Course Name       : " + courseName);
        System.out.println("Course Instructor : " + instructor);
        System.out.println("Total Students    : " + totalStudents);
        System.out.printf("Male percentage   : %.2f", maleStPerc);
        System.out.printf("\nFemale percentage : %.2f", femaleStPerc);

        if (totalStudents > 0) {
            for (int i = 0; i < studentArray.length; i++) {
                if (studentArray[i].name == name_) {
                    System.out.println("\n\n====== Student Detail ====== ");
                    System.out.println("\nName          : " + studentArray[i].name);
                    System.out.println("Date of Birth : " + studentArray[i].DOB);
                    System.out.println("Address       : " + studentArray[i].address);
                    System.out.println("Gender        : " + studentArray[i].gender);
                    found = true;
                }
            }
        }

        if (found == false) {
            System.out.println("No such Student is enrolled in the Course.");
        }
    }


    public void printCourse() {



        if (totalStudents > 0) {
            System.out.println("\n\n====== Students ====== ");
            for (int i = 0; i < studentArray.length; i++) {
                if (studentArray[i].name != "" && studentArray[i].name != null) {
                    System.out.println("\nName          : " + studentArray[i].name);
                    System.out.println("Date of Birth : " + studentArray[i].DOB);
                    System.out.println("Address       : " + studentArray[i].address);
                    System.out.println("Gender        : " + studentArray[i].gender);
                }
            }
        } else {
            System.out.println("No students Enrolled Yet.");
        }
    }
}
