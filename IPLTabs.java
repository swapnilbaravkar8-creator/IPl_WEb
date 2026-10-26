package ipldemo;

import java.util.Scanner;

public class IPLTabs {

	Scanner sc = new Scanner(System.in);
	PlayerService service = new PlayerService();

	void showMenu() throws Exception {

		int choice;

		do {
			System.out.println("\n===== TATA IPL =====");
			System.out.println("1. News");
			System.out.println("2. Videos");
			System.out.println("3. Photos");
			System.out.println("4. Matches");
			System.out.println("5. Points Table");
			System.out.println("6. Teams");
			System.out.println("7. More");
			System.out.println("8. All Players (Database)");
			System.out.println("0. Exit");

			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Latest IPL News");
				break;

			case 2:
				System.out.println("IPL Match Videos");
				break;

			case 3:
				System.out.println("IPL Photo Gallery");
				break;

			case 4:
				System.out.println("IPL Match Schedule");
				break;

			case 5:
				service.showPointsTable();
				break;

			case 6:
				System.out.println("Enter team (RCB/MI/CSK/KKR/SRH/GT/RR/LSG/PBKS/DC): ");

				String team = sc.next();

				service.showPlayersByTeam(team);

				break;

			case 7:
				System.out.println("About IPL | Help | Contact");
				break;

			case 8:
				service.showAllPlayers();
				break;

			case 0:
				System.out.println("Thank you!");
				break;

			default:
				System.out.println("Invalid choice!");
			}

		} while (choice != 0);
	}

	public static void main(String[] args) throws Exception {

		IPLTabs obj = new IPLTabs();
		obj.showMenu();
	}
}
