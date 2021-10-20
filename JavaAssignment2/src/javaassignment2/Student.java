
package javaassignment2;

/**
 *
 * @author Ben Platt
 */

class Student {//data members
    public String name;
    public String DOB;
    public String address;
    public String gender;

    // Def. Constructor
    public Student(){
        name = "";
        DOB = "";
        address = "";
        gender = ""; //'Male' for male, 'Female' for female
    }

    public Student(Student st){
        this.name = st.name;
        this.DOB = st.DOB;
        this.address = st.address;
        this.gender = st.gender;
    }

    //Param. constructor
    public Student(String name_, String DOB_, String address_, String gender_){
        this.name = name_;
        this.DOB = DOB_;
        this.address = address_;
        this.gender = gender_;
    }
}
