package baitapreviwelan2;

import java.io.IOException;
import java.util.Scanner;

public class MainStudent {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ManagementStudent ql = new ManagementStudent();
        Validate validate = new Validate();
       // ql.addStudent(new Student(23,"CIEN", "2/3", "nam", "ha noi", "le duc chien", 45, 23));
        int choice;
        while (true){
            displayMenu();
            System.out.println("nhập lựa chọn");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    scanner.nextLine();
                    System.out.println("nhập mã số sv cần thêm");
                    String id;
                    boolean checkid;
                    boolean checkids;
                    do {
                        id=scanner.nextLine();
                         checkid = validate.validateId(id);
                         checkids = validate.checkID(id);
                        if (checkid == false){
                            System.out.println("sai định dạng, nhập lại đi");
                        }else if (checkids == false){
                            System.out.println("mã số sv đã tồn tại");
                        }
                    }while (checkid == false||checkids==false);
                    System.out.println("nhập tên sinh viên cần thêm");
                    String name = scanner.nextLine();
                    System.out.println("nhập ngày sinh");
                    String bornday;
                    boolean checkbith;
                    do {
                        bornday = scanner.nextLine();
                        checkbith = validate.validateDate(bornday);
                        if (checkbith == false){
                            System.out.println("sai định dạng nhập lại");
                        }
                    }while (checkbith == false);
                    System.out.println("nhập giới tính");
                    String gender = scanner.nextLine();
                    System.out.println("nhập địa chỉ");
                    String address = scanner.nextLine();
                    System.out.println("nhập email sv");
                    String email;
                    boolean checkemail;
                    do {
                        email = scanner.nextLine();
                        checkemail = validate.validateEmail(email);
                        if (checkemail==false){
                            System.out.println("sai định dạng nhập lại");
                        }

                    }while (checkemail == false);
                    System.out.println("nhập điểm trung bình");
                    double point = scanner.nextDouble();
                    System.out.println("nhập tuổi");
                    int age = scanner.nextInt();
                    Student student = new Student(id, name, bornday, gender, address,email, point, age);
                    ql.addStudent(student);
                    break;
                case 2:
                    ql.display();
                    break;
                case 3:
                    System.out.println("nhập mã số sinh viên cần update");
                    String id1 = scanner.nextLine();
                    if (ql.findById(id1) == -1){
                        System.out.println("không tìm thấy sinh viên này");
                    }else {
                        scanner.nextLine();
                        System.out.println("nhập tên sinh viên cần sửa");
                        String name1 = scanner.nextLine();
                        System.out.println("nhập ngày sinh mới");
                        String bornday1 = scanner.nextLine();
                        System.out.println("nhập giới tính mơi");
                        String gender1 = scanner.nextLine();
                        System.out.println("nhập địa chỉ mới");
                        String address1 = scanner.nextLine();
                        System.out.println("nhập email mơi");
                        String email1 = scanner.nextLine();
                        System.out.println("nhập điểm tb mơi");
                        double point1 = scanner.nextDouble();
                        System.out.println("nhập tuổi mới");
                        int age1= scanner.nextInt();
                        ql.editStudent(id1, new Student(id1,name1,bornday1,gender1, address1, email1, point1,age1));
                    }
                    break;
                case 4:
                    System.out.println("nhập id sinh viên cần xóa");
                    String id2 = scanner.nextLine();
                    if (ql.findById(id2) == -1){
                        System.out.println("không tìm thấy sinh viên này");
                    }else {
                        ql.deleteStudent(id2);
                    }
                    break;
                case 5:
                    System.out.println("bạn muốn tìm kiếm sinh viên theo kiểu gì");
                    System.out.println("1. theo mssv    2.tên    3. tuổi    4. điểm");
                    int option = scanner.nextInt();
                    switch (option){
                        case 1:
                            System.out.println("nhập mssv cần tìm kiếm");
                            String id3 = scanner.nextLine();
                            ql.seachById(id3);
                            break;
                        case 2:
                            System.out.println("nhập tên cần tìm kiếm");
                            String name3 = scanner.nextLine();
                            ql.seachByName(name3);
                            break;
                        case 3:
                            System.out.println("nhập độ tuổi cần tìm kiếm");
                            int firstage = scanner.nextInt();
                            int lastage = scanner.nextInt();
                            ql.SeachByAge(firstage, lastage);
                            break;
                        case 4:
                            System.out.println("nhập khoảng điểm cần tìm kiếm");
                            double firstpoint = scanner.nextDouble();
                            double lastpoint = scanner.nextDouble();
                            ql.SeachByPoint(firstpoint,lastpoint);
                            break;
                    }
                    break;
                case 6:
                    System.out.println("bạn muốn sắp xếp sinh viên theo kiểu gì");
                    System.out.println("1.sắp xếp theo điểm   2.sắp xếp theo tên");
                    int option1 = scanner.nextInt();
                    switch (option1){
                        case 1:
                            ql.sortByPoint();
                            break;
                        case 2:
                            ql.sortByName();
                            break;
                    }
                    break;
                case 7:
                    ql.writeFile("data.csv", ql.getList());
                    break;
                case 8:
                    ql.readFile("data.csv");
                    ql.display();
                    break;
                case 9:
                     System.exit(0);
                    break;
            }
        }

    }
    public static void displayMenu(){
        System.out.println("---------------menu------------");
        System.out.println("1. Thêm mới sinh viên");
        System.out.println("2. Hiển thị danh sách sinh viên");
        System.out.println("3. Cập nhật danh sách sinh viên");
        System.out.println("4. Xóa sinh viên");
        System.out.println("5. Tìm kiếm sinh viên");
        System.out.println("6. sắp xếp danh sách sinh viên");
        System.out.println("7. Lưu danh sách sinh viên");
        System.out.println("8. hiển thị danh sách sinh viên đã lưu");
        System.out.println("9. thoát chương trình");
    }
}
