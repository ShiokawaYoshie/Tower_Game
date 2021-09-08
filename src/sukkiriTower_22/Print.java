package sukkiriTower_22;
import java.util.List;
import java.util.Scanner;

public class Print {

	public void printAttack(Character c1, Character c2, int damage) {
		System.out.println(c1.getName() + "の攻撃！！");
		System.out.println(c2.getName() + "に" + damage + "のダメージ！！");
	}

	public void printSpecialAttack(Character c1, Character c2, int damage) {
		System.out.println(c1.getName() + "は必殺技を放った！！");
		System.out.println(c2.getName() + "に" + damage + "のダメージ！！");
	}

	public void failureSpecialAttack(Character c1) {
		System.out.println(c1.getName() + "は必殺技を放った！！");
		System.out.println("しかし技は失敗してしまった…");
	}

	public void watch(Monster c1) {
		System.out.println(c1.getName() + "は様子を見ている");
	}

	public void successRun(Hero c1) {
		System.out.println(c1.getName() + "は逃げ出した!");
		c1.setRunAction(true);
	}

	public void failureRun(Hero c1) {
		System.out.println(c1.getName() + "は逃げきれなかった!");
		c1.setRunAction(false);
	}

	public void intoFloor(int x, Character c) {
		System.out.println("");
		System.out.println("【" + x + "階に到着した！】");
		System.out.println(c.getName() + "が現れた！！");
	}


	public int selectCommand(Hero h, Monster m) {
		System.out.println("");
		System.out.printf("["+h.getName() +"の HP：%4d MP：%3d]", h.getHp(), h.getMp());
		System.out.printf(" ["+m.getName() +"の HP：%4d MP：%3d]", m.getHp(), m.getMp());
		System.out.println("---------------------------------");
		System.out.print("コマンドを入力（1:攻撃 2:必殺技 3:逃げる) >>");
		int choice = new Scanner(System.in).nextInt();
		return choice;
	}

	public void useHealingItem(Hero h) {
		System.out.println("");
		System.out.println("回復アイテムを使いますか？");
		System.out.print("コマンドを入力（1：使う 2：使わない）>>");
		int choice = new Scanner(System.in).nextInt();
		if(choice == 1) {
			System.out.println(h.getName() +  "のHPが20回復した");
			h.setHp(Math.min(h.getHp() + 20, h.getMaxHp()));
			h.setHealingItems(h.getHealingItems() -1);
		}

	}

	public int choiceHero() {
		HeroDBConnect hdbc = new HeroDBConnect();
		System.out.println("使用する勇者の一覧を表示します。");
		List<String> heroName = hdbc.getHeroInfo();
		for(int i = 1; i <= heroName.size(); i++ ) {
			System.out.print(i + ":" + heroName.get(i-1) + "  ");
		}
		System.out.println("");
		System.out.println("使用する勇者を選んで下さい(半角数字で入力)＞＞");
		int choice = new Scanner(System.in).nextInt();
		return choice;
	}

	public void getExperiencePoint(Hero h, Monster m) {
		System.out.println(m.getName() +"をやっつけた！！");
		h.setExperiencePoint(h.getExperiencePoint() + m.getExperiencePoint());
		System.out.println("");
		System.out.println(h.getName()+ "は" + m.getExperiencePoint() + "ポイントの経験値を獲得した");

	}

	public void printMonsterInfo() {
		MonsterDBConnect mdbc = new MonsterDBConnect();
		System.out.println("現在登録されているモンスターの一覧を表示します。");
		List<String> monsterInfo = mdbc.getMonsterInfo();
		for(int i = 0; i < monsterInfo.size(); i++ ) {
			String [] monster = monsterInfo.get(i).split(",");
			System.out.println(monster[0] + "：" + monster[1]);
			}
		System.out.println("");
		System.out.println("モンスターIDが連番になるように登録してください(連番にならないとゲームで使用出来ません)。");
		System.out.println("");
	}

}

