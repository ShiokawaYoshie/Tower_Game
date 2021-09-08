package sukkiriTower_22;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {


		int count = 0;
		System.out.println("★☆スッキリタワー☆★");
		System.out.println("1：ゲームスタート");
		System.out.println("2：モンスターデータ取込");
		System.out.println("3：モンスターの追加登録");
		System.out.println("半角数字で入力を行って下さい。");
		int choice =0;
		try{
		choice = new Scanner(System.in).nextInt();
		}catch(InputMismatchException e) {
			System.out.println("入力値が違います。初めからやり直して下さい。");
			return;
		}
		Print p = new Print();

		switch(choice) {
		case 1: //ゲームスタート
			List <String> md; //モンスターのデータの入れ物
			List<String> hd; //ヒーローのデータの入れ物
			List<List<String>> allHero;//複数のHeroインスタンスが入るList

			//ヒーローの作成
			HeroDBConnect hdbc = new HeroDBConnect(args);
			OperationProperties op = new OperationProperties();
			hdbc.clearTable(); //tableデータを消去
			allHero = op.getProperties(hdbc);//Listに戻り値を格納
			Register register = new Register();
			int number =0;
			for(List<String> a : allHero) {
				number++; //Heroのid
				a.add(0, number + ""); //Listの0番目に値を追加
				register.RegisterDB(a, hdbc);//DBに登録
			}

			int heroChoice =  p.choiceHero(hdbc);//HeroをUserが選ぶ
			hd = hdbc.getHeroData(heroChoice);// Heroの情報をListに代入
			Hero h = register.RegisterHero(hd); //Heroインスタンスを作る
			ResultOutput ro = new ResultOutput(h); //text出力用のインスタンスを作成

			while(true) {
				//カウントの追加
				count++;

				//モンスターの作成
				MonsterDBConnect mdbc = new MonsterDBConnect(args);
				md = mdbc.getMonsterData(count);

				if(md.size() == 0) { //MonsterのデータがDBから受け取れなかったら
					System.out.println("");
					System.out.println("おめでとう！クリアーです！");
					System.out.println("--END--");
					ro.setResult(true);
					ro.OutputResult(count-1);  //textを出力する
					break;
				}

				//Monsterのインスタンスを作成
				Monster monster = register.RegisterMonster(md);

				//戦闘する
				ButtleAction ba = new ButtleAction();
				h = ba.buttle(count, h, monster);

				//行動結果の判定
				if(h.getHp() == 0) {
					System.out.println("");
					System.out.println(h.getName() +  "は死んでしまった‥‥");
					System.out.println("--GAME OVER--");
					ro.OutputResult(count);
					break;

				}else if (h.getHp() > 0 && h.isRunAction() == true) {
					//runが成功したら何も表示しない

				}else if(h.getHp()>0) {
					p.getExperiencePoint(h, monster);
					Levelup le = new Levelup();
					le.levelup(h);

					//回復薬をGetする処理
					Random rm = new Random();
					boolean getItem = rm.nextBoolean();
					if(getItem) {
						System.out.println("");
						System.out.println(h.getName() +"は回復薬を１個手に入れた");
						h.setHealingItems(h.getHealingItems() +1);
					}
				}

				//回復薬を使った時の処理
				if(h.getHealingItems() > 0) {
					p.useHealingItem(h);
				}
			}

			break; //スイッチ文を抜ける時のbreak

		case 2 : //MonsterDBにmonsterを登録
			OperationCSV ocsv = new OperationCSV();
			System.out.println("取り込むCSVファイルのパスを入力してください。");
			String pass = new Scanner(System.in).nextLine();
			ocsv.readCSV(pass, args);

			break;

		case 3://MonsterDBに追加でMonsterを登録
			boolean ans = true;//while文を抜ける際の処理
			p.printMonsterInfo(args);
			while(ans) {
				System.out.println("登録するモンスターの情報を入力してください");
				System.out.print("登録IDを半角数字で入力してください。＞＞");
				int id = new Scanner(System.in).nextInt();
				System.out.println("");
				System.out.print("登録名を入力してください。＞＞");
				String name = new Scanner(System.in).nextLine();
				System.out.println("");
				System.out.print("登録するHPを半角数字で入力してください。＞＞");
				int  hp = new Scanner(System.in).nextInt();
				System.out.println("");
				System.out.print("登録するMPを半角数字で入力してください。＞＞");
				int  mp = new Scanner(System.in).nextInt();
				System.out.println("");
				System.out.print("登録する攻撃力を半角数字で入力してください。＞＞");
				int  power = new Scanner(System.in).nextInt();
				System.out.println("");
				System.out.print("登録する防御力を半角数字で入力してください。＞＞");
				int  defense = new Scanner(System.in).nextInt();
				System.out.println("");
				System.out.print("登録する必殺技の威力を半角数字で入力してください。＞＞");
				int  specialPower = new Scanner(System.in).nextInt();
				System.out.println("");
				System.out.print("登録する経験値を半角数字で入力してください。＞＞");
				int  experiencePoint = new Scanner(System.in).nextInt();

				MonsterDBConnect db = new MonsterDBConnect(args);
				db.setCharacterDate(id, name, hp, mp, power, defense, specialPower, experiencePoint);

				System.out.println("更にモンスターを登録しますか？");
				System.out.print("コマンドを入力（１：はい　２：いいえ）＞＞");
				int action =  new Scanner(System.in).nextInt();

				if(action == 2) {
					System.out.println("システムを終了します。");
					ans = false;
				}

			}

			break;
		}
	}

}
