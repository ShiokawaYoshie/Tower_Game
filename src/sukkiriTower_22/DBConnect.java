package sukkiriTower_22;


//DBを処理するクラスが実装するインターフェース
public interface DBConnect {
	public void setCharacterDate(int id, String name, int hp, int mp, int power, int defense, int specialPower, int experiencePoint);
}
