package hackerrank.datastructures;
import java.util.*;

public class PlayerComparator {

	// Write your Checker class here
	static class Checker implements Comparator<Player> {

		public int compare(Player o1, Player o2) 
		{
			int comparison = Integer.valueOf(o1.score).compareTo(o2.score);
			//for descending order
			comparison *= -1;
			//Compare names
			if(comparison == 0) {
				comparison = o1.name.compareTo(o2.name);
			}

			return comparison;
		}
	}

	static class Player {
		String name;
		int score;

		Player(String name, int score)
		{
			this.name = name;
			this.score = score;
		}
	}


	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		Player[] player = new Player[n];
		Checker checker = new Checker();

		for(int i = 0; i < n; i++){
			player[i] = new Player(scan.next(), scan.nextInt());
		}
		scan.close();

		Arrays.sort(player, checker);
		for(int i = 0; i < player.length; i++){
			System.out.printf("%s %s\n", player[i].name, player[i].score);
		}
	}

}
