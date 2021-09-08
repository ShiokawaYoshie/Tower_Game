package sukkiriTower_22;

import java.util.Random;

public class Hero extends Character {

	private boolean runAction;
	private int healingItems;
	private int level = 1;
	private int experiencePoint;
	private int maxHp;

	//コンストラクタ
	public Hero(String name, int hp, int mp, int power, int defence, int specialAttack, int experiencePoint ) {
		super(name, hp, mp, power, defence, specialAttack);
		this.setExperiencePoint(experiencePoint);
		this.setMaxHp(hp);
	}

	//逃げる時の処理をするメソッド
	public boolean run() {
		boolean action = true;
		Random r = new Random();
		int i =  r.nextInt(10);
		if(i>7) {
			p.successRun(this);
			return action;
		}else {
			p.failureRun(this);
			action = false;
			return action;
		}
	}

	//getter, setter
	public boolean isRunAction() {
		return runAction;
	}

	public void setRunAction(boolean runAction) {
		this.runAction = runAction;
	}

	public int getHealingItems() {
		return healingItems;
	}

	public void setHealingItems(int healingItems) {
		this.healingItems = healingItems;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getExperiencePoint() {
		return experiencePoint;
	}

	public void setExperiencePoint(int experiencePoint) {
		this.experiencePoint = experiencePoint;
	}
}
