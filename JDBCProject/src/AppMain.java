import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class AppMain {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Welcome to Student Management App");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Press 1 to Add Student:");
			System.out.println("Press 2 to Delete Student:");
			System.out.println("Press 3 to Display Student:");
			System.out.println("Press 4 to Update Student :");
			System.out.println("Press 5 to exit:");
			int c = Integer.parseInt(br.readLine());
			
			if(c==1) {
				System.out.println("Enter user name:");
				String name = br.readLine();
				
				System.out.println("Enter user phone:");
				String phone = br.readLine();
				
				System.out.println("Enter user city:");
				String city = br.readLine();
				
				//create student object to store student
				Student st = new Student(name, phone, city);
				boolean answer = StudentDao.insertStudentToDB(st);
				if(answer) {
					System.out.println("Student is added successfully...");
				}else {
					System.out.println("Something went wrong");
				}
				System.out.println(st);
				
			}else if(c==2) {
				//delete student
				System.out.println("Enter student id to delete");
				int userId = Integer.parseInt(br.readLine());
				boolean f = StudentDao.deleteStudent(userId);
				if(f) {
					System.out.println("Deleted");
				}else {
					System.out.println("Something went wrong..");
				}
				
			}else if(c==3) {
				//display students
				StudentDao.showAllStudent();
				
			}else if(c==4) {
				System.out.println("Enter username to be updated:");
				String sname = br.readLine();
				System.out.println("Enter student id to update:");
				int userId = Integer.parseInt(br.readLine());
				boolean f1 = StudentDao.UpdateStudent(userId,sname);
				if(f1) {
					System.out.println("Updated Successfully");
				}else {
					System.out.println("Something went wrong");
				}
			}else if(c==5){
				break;
				
			}
		}
		System.out.println("Thank you for using my Application");
			
	}

}
