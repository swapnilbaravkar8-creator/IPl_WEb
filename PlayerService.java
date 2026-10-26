package ipldemo;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlayerService {

	PlayerConnection pc = new PlayerConnection();

	public List<Player> getAllPlayers() throws Exception {

		List<Player> list = new ArrayList<>();

		String sql = "SELECT * FROM Player";

		try (Connection con = pc.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			while (rs.next()) {

				Player p = new Player(rs.getInt("id"), rs.getString("name"), rs.getString("team_name"),
						rs.getString("category"), rs.getInt("score"), rs.getInt("wickets"));

				list.add(p);
			}
		}

		return list;
	}

	public void showAllPlayers() throws Exception {

		List<Player> list = getAllPlayers();

		System.out.println("ID | Name | Team | Category | Score | Wickets");

		for (Player p : list) {
			p.display();
		}
	}

	public void showPlayersByTeam(String team) throws Exception {

		List<Player> list = getAllPlayers();

		for (Player p : list) {
			if (p.teamName.equalsIgnoreCase(team)) {
				p.display();
			}
		}
	}

	public void showPointsTable() throws Exception {

		List<Player> list = getAllPlayers();

		System.out.println("TEAM | TOTAL SCORE | TOTAL WICKETS");

		String[] teams = { "RCB", "MI", "CSK", "KKR", "SRH", "GT", "RR", "LSG", "PBKS", "DC" };

		for (String team : teams) {

			int totalScore = 0;
			int totalWickets = 0;

			for (Player p : list) {

				if (p.teamName.equalsIgnoreCase(team)) {
					totalScore += p.score;
					totalWickets += p.wickets;
				}
			}

			System.out.println(team + " | " + totalScore + " | " + totalWickets);
		}
	}
}