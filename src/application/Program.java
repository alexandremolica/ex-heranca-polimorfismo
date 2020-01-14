package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsoucedEmployee;

public class Program {

	public static void main(String[] args) {
		// Exercício de polimorfismo e herança.
		// Herança de Classes Employee e OutsourcedEmployee
		// O metodo payment() é polimorfico, pois o comportamento
		// depende do objeto instanciado.
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		// Entrada de dados
		System.out.print("Enter the number of employee: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n ; i++) {
			System.out.println("Employee #"+i+" data: ");
			System.out.print("Outsourced (y/n)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			
			if (ch == 'y') {
				System.out.print("Additional charge: ");
				double additionalCharge = sc.nextDouble();
				list.add(new OutsoucedEmployee(name, hours, valuePerHour, additionalCharge));
			}
			else {
				list.add(new Employee(name, hours, valuePerHour));
			}
		}
		
		// Saida de dados
		System.out.println();
		System.out.println("PAYMENTS: ");

		for (Employee emp: list) {
			System.out.println(emp.getName()+" $"+ String.format("%.2f", emp.payment()));
		}
		
		sc.close();
	}

}
