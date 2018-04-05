import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Student ID: ");
		String username = sc.nextLine();
		
		System.out.print("Password: ");
		String password = sc.nextLine();
		
		new BlackboardSession(username, password);
		
		sc.close();
	}
}