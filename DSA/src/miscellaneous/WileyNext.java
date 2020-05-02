package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class WileyNext {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int type = Integer.parseInt(br.readLine());
		String name = br.readLine();
		int birthYear = Integer.parseInt(br.readLine());
		if(type==1) {
			String department = br.readLine();
			int percentage = Integer.parseInt(br.readLine());
			Student student = new Student(name, birthYear, department, percentage);
			System.out.println("Name : "+name);
			System.out.println("BirthYear : "+birthYear);
			System.out.println("Department : "+department);
			if(student.isEligible()) {
				System.out.println("Eligible : Yes");
			}else {
				System.out.println("Eligible : No");
			}
		}
		else if(type==2) {
			String subject = br.readLine();
			int resultPercentage = Integer.parseInt(br.readLine());
			double salary = Double.parseDouble(br.readLine());
			TeachingStaff teachingStaff = new TeachingStaff(name, birthYear, salary, subject, resultPercentage);
			System.out.println("Name : "+name);
			System.out.println("BirthYear : "+birthYear);
			System.out.println("Old Salary : "+salary);
			System.out.println("Subject : "+subject);
			System.out.println("New Salary : "+teachingStaff.newSalary());
		}
		else if(type==3) {
			String lab = br.readLine();
			int experience = Integer.parseInt(br.readLine());
			double salary = Double.parseDouble(br.readLine());
			NonTeachingStaff nonTeachingStaff = new NonTeachingStaff(name, birthYear, salary,lab,experience);
			System.out.println("Name : "+name);
			System.out.println("BirthYear : "+birthYear);
			System.out.println("Old Salary : "+salary);
			System.out.println("Lab : "+lab);
			System.out.println("New Salary : "+nonTeachingStaff.newSalary());
		}
		br.close();
	}
	
}

abstract class Person{
	String name;
	int birthYear;
}

class Student extends Person{
	String department;
	int percentage;
	public Student(String name,int birthYear,String department, int percentage) {
		this.name = name;
		this.birthYear = birthYear;
		this.department = department;
		this.percentage = percentage;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	public boolean isEligible() {
		return this.percentage>=75;
	}
}

class Staff extends Person{
	double salary;
	public Staff(String name,int birthYear,double salary) {
		this.name = name;
		this.birthYear = birthYear;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}

class TeachingStaff extends Staff{
	String subject;
	int resultPercentage;
	public TeachingStaff(String name, int birthYear, double salary,String subject,int resultPercentage) {
		super(name,birthYear,salary);
		this.subject = subject;
		this.resultPercentage = resultPercentage;
	}
	
	public double newSalary() {
		double newPercentage = this.resultPercentage/10;
		double dec = (this.salary*newPercentage)/100;
		return this.salary+dec;
	}
	
}

class NonTeachingStaff extends Staff{
	String lab;
	int experience;
	
	public NonTeachingStaff(String name, int birthYear, double salary,String lab,int experience) {
		super(name, birthYear, salary);
		this.lab = lab;
		this.experience = experience;
	}
	
	public double newSalary() {
		double dec = (this.salary*this.experience)/100;
		return this.salary+dec;
	}
}

/*
 * 
2
Vikram
1980
Maths
90
50000


3
Arun
1984
DS LAB
3
15000


 */



