package sukkiriTower_22;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//プロパティファイルの操作クラス

public class OperationProperties {

	//プロパティファイルから勇者の情報を読み込みする処理
	public List getProperties(DBConnect DB) {
		List<List<String>> allCharacter = new ArrayList<>();
		if(DB instanceof HeroDBConnect) {
			FileReader fr = null;
			Properties p = null;
			try {
				fr = new FileReader("C:\\config\\game1.properties");
				p = new Properties();
				p.load(fr);
				String[] allName =p.getProperty("hero_name").split("@");
				String[] allHp = p.getProperty("hero_hp").split("@");
				String[] allMp = p.getProperty("hero_mp").split("@");
				String[] allPower = p.getProperty("hero_power").split("@");
				String[] allDefense = p.getProperty("hero_defense").split("@");
				String[] allSpecialPower =p.getProperty("hero_special_power").split("@");
				String[] allExperiencePoint =p.getProperty("hero_experience_point").split("@");



				int number = Integer.parseInt(p.getProperty("hero_number"));
				for (int i = 0; i<number; i++) {
					List<String> heroList = new ArrayList<>();
					heroList.add(allName[i]);
					heroList.add(allHp[i]);
					heroList.add(allMp[i]);
					heroList.add(allPower[i]);
					heroList.add(allDefense[i]);
					heroList.add(allSpecialPower[i]);
					heroList.add(allExperiencePoint[i]);
					allCharacter.add(heroList);
				}


			} catch (IOException | RuntimeException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}finally {
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
		return allCharacter;
	}

	//Monsterの行動情報を読み込みする処理
	public List getActionRate() {
		List<Integer> actionRate = new ArrayList<>();
		FileReader fr = null;
		Properties p = null;
		try {
			fr = new FileReader("C:\\config\\game.properties");
			p = new Properties();
			p.load(fr);
			actionRate.add(Integer.parseInt(p.getProperty("action_attack")));
			actionRate.add(Integer.parseInt(p.getProperty("action_special_attack")));
			actionRate.add(Integer.parseInt(p.getProperty("action_wait")));

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			if(fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

			}
		}
		return actionRate;
	}
}
