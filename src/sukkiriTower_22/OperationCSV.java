package sukkiriTower_22;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OperationCSV {

	//csvファイルからデータの読み込み
	public void readCSV(String pass){
		FileReader fr = null;
		BufferedReader br = null;
		MonsterDBConnect mdbc = new MonsterDBConnect();

		mdbc.clearTable();

		try {
			fr = new FileReader(pass);
			br = new BufferedReader(fr);
			String line = null;
			br.readLine();

			while((line = br.readLine()) != null) {
				List<String> monster =  new ArrayList<>();
				System.out.println("【取り込みデータ】" + line);
				monster = Arrays.asList(line.split(","));
				int id = Integer.parseInt(monster.get(0));
				String name = monster.get(1);
				int hp = Integer.parseInt(monster.get(2));
				int mp= Integer.parseInt(monster.get(3));
				int power= Integer.parseInt(monster.get(4));
				int defense = Integer.parseInt(monster.get(5));
				int specialAttack= Integer.parseInt(monster.get(6));
				int experiencePoint= Integer.parseInt(monster.get(7));

				mdbc.setCharacterDate(id, name, hp, mp, power, defense, specialAttack, experiencePoint);

			}
			System.out.println("取込処理が完了しました。");

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}

			if(fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
	}

}
