package sukkiriTower_22;

public class Character {
	private String name;
	private int hp;
	private int mp;
	private int attack;//DB上の項目だとpower
	private int defense;
	private int specialAttack;
	Print p ;

	public Character(String name, int hp, int mp, int attack, int defense, int specialAttack) {
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.attack = attack;
		this.defense = defense;
		this.specialAttack = specialAttack;
		p = new Print();
	}

	//getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getSpecialAttack() {
		return specialAttack;
	}
	public void setSpecialAttack(int specialAttack) {
		this.specialAttack = specialAttack;
	}

	//攻撃時の処理をするメソッド
	public void attack(Character c) {
		int attackPoint = this.getAttack() - c.getDefense();
		if(attackPoint <0) {
			attackPoint = 0;
		}
		int remainingHp = c.getHp() - attackPoint;
		if(remainingHp <0) {
			remainingHp = 0;
		}
		c.setHp(remainingHp);
		p.printAttack(this, c, attackPoint);
	}

	//必殺技時の処理をするメソッド
	public void specialAttack(Character c) {
		if(this.mp<=0) {
			p.failureSpecialAttack(this);
		}else {
		int attackPoint = this.getSpecialAttack();
		int remainingHp = c.getHp() - attackPoint;
			if(remainingHp <0) {
				remainingHp = 0;
			}
		c.setHp(remainingHp);
		p.printSpecialAttack(this, c, attackPoint);
		this.mp --;
		}
	}

}
