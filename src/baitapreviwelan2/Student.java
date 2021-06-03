package baitapreviwelan2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {
     private String idStudent;
     private String name;
     private String bornDay;
     private String gender;
     private String address;
     private String email;
     private double coveragePoint;
     private int age;

    public Student() {
    }

    public Student(String idStudent, String name, String bornDay, String gender, String address, String email, double coveragePoint, int age) {
        this.idStudent = idStudent;
        this.name = name;
        this.bornDay = bornDay;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.coveragePoint = coveragePoint;
        this.age = age;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBornDay() {
        return bornDay;
    }

    public void setBornDay(String bornDay) {
        this.bornDay = bornDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getCoveragePoint() {
        return coveragePoint;
    }

    public void setCoveragePoint(double coveragePoint) {
        this.coveragePoint = coveragePoint;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getTuoi(String bornDay){
        String[] content = bornDay.split("/");
      return (Integer.parseInt(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy")))) -  Integer.parseInt(content[content.length -1]);
    }
    @Override
    public String toString() {
        return "Student{" +
                "idStudent=" + idStudent +
                ", name='" + name + '\'' +
                ", bornDay='" + getTuoi(bornDay) + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", coveragePoint=" + coveragePoint +
                ", age=" + age +
                '}';
    }
}
