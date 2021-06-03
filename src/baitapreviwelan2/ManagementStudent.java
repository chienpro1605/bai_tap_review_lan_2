package baitapreviwelan2;

import java.io.*;
import java.util.*;

public class ManagementStudent {
      List<Student> list;
     //ReadWireCsv rwc = new ReadWireCsv();

     public ManagementStudent(){
          try {
              this.list = readFile("data.csv");
          }catch (Exception e){
               this.list = new ArrayList<>();
          }
     }

      public List<Student> getList() {
            return list;
      }

      public void setList(List<Student> list) {
            this.list = list;
      }
      public void display(){
          for (int i = 0; i<list.size(); i++){
              System.out.println(list.get(i));
          }
          System.out.println("---------------");
      }
      public void addStudent(Student student) throws IOException {
           this.list.add(student);
            writeFile("data.csv",this.list);
            System.out.println("đã thêm thành công sinh viên vào danh sách");
      }
      public int findById(String id){
           for (int i = 0; i<list.size(); i++){
                 if (list.get(i).getIdStudent() == id){
                       return i;
                 }
           }
           return -1;
      }
      public void editStudent(String id, Student student){
           if (findById(id) == -1){
                 System.out.println("mã số sinh viên này k tồn tại");
           }else {
                 list.set(findById(id), student);
                 System.out.println("cập nhật thành công");
           }
     }
     public void deleteStudent(String id) throws IOException {
           if (findById(id) == -1){
                 System.out.println("mã số sinh viên này k tồn tại");
           }else {
                 list.remove(findById(id));
                 writeFile("data.csv",this.list);
                 System.out.println("bạn đã xóa thành công!");
                 display();
           }
     }
     public void seachById(String id){
           if (findById(id) == -1){
                 System.out.println("mã số sinh viên không tồn tại");
           }else {
                 System.out.println( list.get(findById(id)).toString());
           }
     }
     public void seachByName(String name){
         boolean ten = false;
         for (int i = 0; i<list.size(); i++){
             if (list.get(i).getName() == name){
                   System.out.println(list.get(i).toString());
                   ten = true;
             }
         }
         if (!ten){
               System.out.println("không tìm thấy sinh viên này");
         }
     }
     public void SeachByAge(int firstAge, int lastAge){
         boolean tuoi = false;
         for (int i = 0; i<list.size(); i++){
             if (firstAge<=list.get(i).getAge() &&list.get(i).getAge() <= lastAge){
                 System.out.println(list.get(i).toString());
                 tuoi = true;
             }
         }
         if (!tuoi){
             System.out.println("không tìm thấy sx này");
         }
     }
     public void SeachByPoint(double firstPoint, double lastPoint){
         boolean diem = false;
         for (int i = 0; i<list.size(); i++){
             if (firstPoint<= list.get(i).getCoveragePoint()&& list.get(i).getCoveragePoint()<= lastPoint){
                 System.out.println(list.get(i).toString());
             }
         }
         if (!diem){
             System.out.println("không tìm thấy sinh viên này");
         }
     }
     public void sortByPoint(){
         Collections.sort(list, new Comparator<Student>() {
             @Override
             public int compare(Student o1, Student o2) {
                 int result = (int) (o1.getCoveragePoint() - o2.getCoveragePoint());
                 if (result == 0)
                     return o1.getName().compareTo(o2.getName());
                     return result;
             }
         });
     }
     public void sortByName(){
         Collections.sort(list, new Comparator<Student>() {
             @Override
             public int compare(Student o1, Student o2) {
                 return o1.getName().compareTo(o2.getName());
             }
         });
     }
    void writeFile(String path, List<Student> students) throws IOException {
        FileWriter fw = new FileWriter(path);
        BufferedWriter bf = new BufferedWriter(fw);
        String str = "name, bornDay, gender, address, email, coveragePoint, age\n";
        for (int i = 0; i<students.size(); i++){
            str+= students.get(i).getIdStudent()+","+students.get(i).getName()+","+students.get(i).getBornDay()+","
                    +students.get(i).getGender()+","+students.get(i).getAddress()+","+students.get(i).getEmail()+","
                    +students.get(i).getCoveragePoint()+","+students.get(i).getAge()+"\n";
        }
        bf.write(str);
        bf.close();
        fw.close();
    }
    List<Student> readFile(String path) throws IOException {
        List<Student> people = new ArrayList<>();
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String content = br.readLine();
        while ((content = br.readLine())!=null){
            String[] values = content.split(",");
            people.add(new Student(values[0],values[1],values[2],values[3],values[4],values[5],Double.parseDouble(values[6]),Integer.parseInt(values[7])));
        }
        return people;
    }

}
