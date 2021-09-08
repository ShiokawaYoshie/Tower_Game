package sukkiriTower_22;

import java.util.List;
import java.util.Random;

public class ButtleAction {
	OperationProperties op; //プロパティファイルを操作するクラス
	List <Integer> actionRate;

	//コンストラクタ
	public ButtleAction() {
		op = new OperationProperties();
		actionRate = op.getActionRate();

	}

	public Hero buttle(int count, Hero hero, Monster monster) {
		Print p = new Print();
		boolean action = false;

		p.intoFloor(count, monster); //階数を表示

		//ヒーローの行動
		while(hero.getHp() != 0 && monster.getHp() > 0) {
			int a = p.selectCommand(hero, monster);

			switch(a) {
			case 1:
				hero.attack(monster);
				break;
			case 2:
				hero.specialAttack(monster);
				break;

			case 3:
			  action = hero.run();
				break;
			}

			if(monster.getHp() <=0) {
				break;
			}


			if(a == 3 && action == true) {
				break;
			}

			//モンスター側の行動
			Random random = new Random();
			int b = random.nextInt(100);
			if(b<actionRate.get(0)) {
				monster.attack(hero);
			}else if( b<actionRate.get(0) + actionRate.get(1)) {
				monster.specialAttack(hero);
			}else {
				monster.watch();
			}
		}

		return hero;
	}

}
