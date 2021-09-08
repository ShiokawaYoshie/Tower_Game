package sukkiriTower_22;

// モンスタークラス

public class Monster extends Character{
	private int experiencePoint;

	//コンストラクタ
	public  Monster(String name, int hp, int mp, int attack, int defense, int specialAttack, int experiencePoint ){
		super(name, hp, mp, attack, defense, specialAttack);
		this.setExperiencePoint(experiencePoint);
	}

	//様子を見る時の処理
	public void watch() {
		p.watch(this);
	}

	public int getExperiencePoint() {
		return experiencePoint;
	}

	public void setExperiencePoint(int experiencePoint) {
		this.experiencePoint = experiencePoint;
	}
}