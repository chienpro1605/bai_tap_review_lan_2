package baitapreviwelan2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWireCsv {
   public static void writeFile(String path, List<Student> students) throws IOException {
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
    public static List<Student> readFile(String path) throws IOException {
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
