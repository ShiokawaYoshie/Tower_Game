package sukkiriTower_22;

import java.util.List;

public class Register {

//Character情報をStringからintに変換
	public void RegisterDB(List<String> list , DBConnect DB ) {
		int id = Integer.parseInt(list.get(0));
		String name = list.get(1);
		int hp = Integer.parseInt(list.get(2));
		int mp= Integer.parseInt(list.get(3));
		int power= Integer.parseInt(list.get(4));
		int defense = Integer.parseInt(list.get(5));
		int specialAttack= Integer.parseInt(list.get(6));
		int experiencePoint= Integer.parseInt(list.get(7));

		DB.setCharacterDate(id, name, hp, mp, power, defense, specialAttack,experiencePoint);;
	}

	public Hero RegisterHero(List<String> list ) {
		String name = list.get(0);
		int hp = Integer.parseInt(list.get(1));
		int mp= Integer.parseInt(list.get(2));
		int power= Integer.parseInt(list.get(3));
		int defense = Integer.parseInt(list.get(4));
		int specialAttack= Integer.parseInt(list.get(5));
		int experiencePoint= Integer.parseInt(list.get(6));

		Hero h = new Hero(name, hp, mp, power, defense, specialAttack, experiencePoint);

		return h;

	}

	public Monster RegisterMonster(List<String> list ) {
		String name = list.get(0);
		int hp = Integer.parseInt(list.get(1));
		int mp= Integer.parseInt(list.get(2));
		int power= Integer.parseInt(list.get(3));
		int defense = Integer.parseInt(list.get(4));
		int specialAttack= Integer.parseInt(list.get(5));
		int experiencePoint= Integer.parseInt(list.get(6));

		Monster m = new Monster(name, hp, mp, power, defense, specialAttack, experiencePoint);

		return m;

	}

}
