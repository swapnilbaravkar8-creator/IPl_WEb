package ipldemo;

public class Player {

    int id;
    String name;
    String teamName;
    String category;
    int score;
    int wickets;

    public Player(int id, String name, String teamName,
                  String category, int score, int wickets) {

        this.id = id;
        this.name = name;
        this.teamName = teamName;
        this.category = category;
        this.score = score;
        this.wickets = wickets;
    }

    public void display() {
        System.out.println(
            id + " | " + name + " | " + teamName + " | "
            + category + " | " + score + " | " + wickets
        );
    }
}
