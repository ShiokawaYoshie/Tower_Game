package sukkiriTower_22;

public class Levelup {

	//レベルアップの処理
	public void levelup(Hero h) {
		while(maxPointCalc(h) <= h.getExperiencePoint() ) {
			int a = maxPointCalc(h);
			int b = upPoint(h);
			h.setLevel(h.getLevel() +1);
			h.setAttack(h.getAttack() + b);
			h.setDefense(h.getDefense() + b);
			h.setSpecialAttack(h.getSpecialAttack() + b);
			System.out.println(h.getName() + "はレベル" + h.getLevel() + "になった");
			h.setExperiencePoint(h.getExperiencePoint() - a );
		}
	}
	//経験値の上限を設定
	public int maxPointCalc(Hero h) {
		double base = h.getLevel();
		int maxPoint =(int) Math.pow(4.0, base);// 乗数計算するメソッド
		return  maxPoint;
	}
	//上昇するステータスの数値を計算
	public int upPoint(Hero h) {
		double base = h.getLevel();
		int upPoint =(int) Math.pow(2, base);// 乗数計算するメソッド
		return upPoint;
	}

}
