import java.util.Arrays;
import java.util.Scanner;

import javax.sound.sampled.Line;

public class Map {

	int[][] mistMap = new int[10][10];
	private boolean foundtreasureboolean = false;

	public void populateMap(item player) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == player.getX() && j == player.getY()) {
					mistMap[i][j] = 1;
				} else {
					mistMap[i][j] = 0;
				}
			}
		}
	}

	public void printMap() {

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(mistMap[i][j]);
			}
			System.out.println();
		}
	}

	public double pythag(int a, int b, int a1, int b2) {
		return Math.hypot(a - a1, b - b2);
	}

	Scanner sc = new Scanner(System.in);

	public void moveNorth(Treasure treasure, Player player) {
		if (player.getX() == 0) {
			System.out.println("Unable to move North!");
		} else {
			player.setX(player.getX() - 1);
			System.out.println("Moved north");
			foundTreasure(treasure, player);
			foundmistMonster(player);
		}
	}

	public void moveEast(Treasure treasure, Player player) {
		if (player.getY() == 9) {
			System.out.println("Unable to move East!");
		} else {
			player.setY(player.getY() + 1);
			System.out.println("Moved east");
			foundTreasure(treasure, player);
			foundmistMonster(player);
		}
	}

	public void moveSouth(Treasure treasure, Player player) {
		if (player.getX() == 9) {
			System.out.println("Unable to move South!");
		}

		else {
			player.setX(player.getX() + 1);
			System.out.println("Moved south");
			foundTreasure(treasure, player);
			foundmistMonster(player);
		}
	}

	public void moveWest(Treasure treasure, Player player) {
		if (player.getY() == 0) {
			System.out.println("Unable to move West!");
		} else {
			player.setY(player.getY() - 1);
			System.out.println("Moved west");
			foundTreasure(treasure, player);
			foundmistMonster(player);
		}
	}

	public void foundTreasure(Treasure treasure, Player player) {
		if (treasure.getX() == player.getX() && treasure.getY() == player.getY()) {
			System.out.println("Found the Treasure!!!!!!!!!!! WOOOOO !!!!! WINNER !!!!!!!!");
			foundtreasureboolean = true;
		} else {
		}
	}

	public void foundmistMonster(Player player) {
		if (player.getX() == 0 && player.getY() == 0 || player.getX() == 1 && player.getY() == 4
				|| player.getX() == 2 && player.getY() == 2 || player.getX() == 2 && player.getY() == 4
				|| player.getX() == 3 && player.getY() == 7 || player.getX() == 8 && player.getY() == 5
				|| player.getX() == 4 && player.getY() == 4 || player.getX() == 9 && player.getY() == 2
				|| player.getX() == 5 && player.getY() == 2) {
			System.out.println("A mist creasture hit you! You took damage!");
			player.setHealth(player.getHealth() - 1);
			System.out.println("Current health = " + player.getHealth());

			if (player.getHealth() == 0) {
				System.out.println("You died game over!");
			}
		} else {
		}
	}

	public void updatePerson(item treasure, item player) {

		System.out.println("Welcome to the Maze");
		Treasure treasuure = (Treasure) treasure;
		Player play = (Player) player;
		while (play.getHealth() > 0 && foundtreasureboolean == false) {

			switch (sc.next().toLowerCase()) {
			case ("north"):
				moveNorth(treasuure, play);
				populateMap(player);
				printMap();
				System.out.println(pythag(player.getX(), player.getY(), treasure.getX(), treasure.getY()));
				break;

			case ("east"):
				moveEast(treasuure, play);
				populateMap(player);
				printMap();
				System.out.println(pythag(player.getX(), player.getY(), treasure.getX(), treasure.getY()));
				break;

			case ("south"):
				moveSouth(treasuure, play);
				populateMap(player);
				printMap();
				System.out.println(pythag(player.getX(), player.getY(), treasure.getX(), treasure.getY()));
				break;

			case ("west"):
				moveWest(treasuure, play);
				populateMap(player);
				printMap();
				System.out.println(pythag(player.getX(), player.getY(), treasure.getX(), treasure.getY()));
				break;

			default:
				System.out.println("Less of that");
				break;
			}

		}
	}

}
