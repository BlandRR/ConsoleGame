
public class Main {

	public static void main(String[] args) {
		Map map = new Map();
		item player = new Player();
		item treasure = new Treasure();
		item mist = new MistMonster();
		item mist2 = new MistMonster();
		item mist3 = new MistMonster();
		item mist4 = new MistMonster();

		map.populateMap(player);
	/*	map.populateMap(mist);
		map.populateMap(mist3);
		map.populateMap(mist2);
		map.populateMap(mist4);*/
	
		map.populateMap(treasure);
		
		
		map.updatePerson(treasure,player);
		
	}
}
