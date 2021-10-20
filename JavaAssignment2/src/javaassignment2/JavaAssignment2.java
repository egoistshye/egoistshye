package javaassignment2;
/**
 *
 * @author Ben Platt
 */
    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.util.Scanner;
public class JavaAssignment2 {
    
    
    public static void main(String[] args) throws IOException{
        //creating student objects, and adding & deleting them into the course.
        Course course = new Course("Java Programming", "Haiying Wang");


        System.out.println("--------------------------------------------");
        System.out.println("--------------- W E L C O M E --------------");
        System.out.println("--------------------------------------------");
        // input.close();
        Scanner input = new Scanner(System.in);
        int choice = 1;
        while (choice != 0) {
            System.out.println("Select an option Below:");
            System.out.println("0. Exit.");
            System.out.println("1. Add a student to Course.");
            System.out.println("2. Remove a student from Course.");
            System.out.println("3. Search a student in Course.");

            choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1:
                    String name, dob, address, gender;
                    System.out.println("\tEnter Student's Data...");

                    System.out.print("\tName: ");
                    name = input.nextLine();

                    System.out.print("\tDate of birth (DD/MM/YYYY): ");
                    dob = input.nextLine();

                    System.out.print("\tAddress: ");
                    address = input.nextLine();

                    System.out.print("\tGender ('Male' OR 'Female'): ");
                    gender = input.nextLine();

                    Student st3 = new Student(name, dob, address, gender);
                    course.addStudent(st3);

                    System.out.println(name + " has been Enrolled in the course.");
                    break;
                case 2:
                    String nameToRemove;
                    System.out.print("Enter name of the student you want to remove : ");
                    nameToRemove = input.nextLine();
                    course.deleteStudent(nameToRemove);
                    System.out.println(nameToRemove + " has been Removed from the course.\n");
                    break;
                case 3:
                    String nameToSearch;
                    System.out.print("Enter name of student you want to search : ");
                    nameToSearch = input.nextLine();
                    System.out.print("Your search result : ");
                    course.search(nameToSearch);
                    System.out.println("");
                case 0:
                    break;
            }
        }
        input.close();



        //writing data to disk/file
        FileWriter courseFile = new FileWriter("CourseDetails.txt");
        courseFile.write(course.courseName + "\n");
        courseFile.write(course.instructor + "\n");
        courseFile.write(course.totalStudents + "\n");

        courseFile.write(course.maleStPerc + "\n");
        courseFile.write(course.femaleStPerc + "\n");

        courseFile.close();
        System.out.println("\n\nCourse Details saved Successfully!!!");

        FileWriter studentsFile = new FileWriter("StudentDetails.txt");

        for (int i = 0; i < course.totalStudents; i++) {
            if (course.studentArray[i].name != null) {
                studentsFile.write(course.studentArray[i].name + "\n");
                studentsFile.write(course.studentArray[i].DOB + "\n");
                studentsFile.write(course.studentArray[i].address + "\n");
                studentsFile.write(course.studentArray[i].gender + "\n");
            }
        }

        System.out.println("Students Details saved Successfully!!!");
        studentsFile.close();
    }
        
}
    

