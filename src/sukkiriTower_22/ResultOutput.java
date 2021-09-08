package sukkiriTower_22;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ResultOutput {

	private Date startTime;
	private Date finishTime;
	private boolean result;
	private int firstHp;
	private int firstMp;
	private int resultStage;
	private Hero h;

	//コンストラクタ
	public ResultOutput(Hero h) {
		this.startTime = new Date();
		this.result = false;
		this.firstHp = h.getHp();
		this.firstMp = h.getMp();
		this.resultStage = 0;
		this.h = h;
	}

	//getter, setter
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public int getFirstHp() {
		return firstHp;
	}
	public void setFirstHp(int firstHp) {
		this.firstHp = firstHp;
	}
	public int getFirstMp() {
		return firstMp;
	}
	public void setFirstMp(int firstMp) {
		this.firstMp = firstMp;
	}
	public int getResultStage() {
		return resultStage;
	}
	public void setResultStage(int resultStage) {
		this.resultStage = resultStage;
	}

	public Hero getH() {
		return h;
	}

	public void setH(Hero h) {
		this.h = h;
	}

	public void OutputResult(int resultStage) {
		this.resultStage = resultStage;
		this.finishTime = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日(E) HH時mm分ss秒");
		String result;
		String textPass ="C:\\result\\"+sdf1.format(this.finishTime) + "_ゲーム結果.txt";

		FileWriter fr = null;
		BufferedWriter br = null;

		try {
			fr = new FileWriter(textPass);
			br = new BufferedWriter(fr);

			br.write("[ゲーム結果]");
			br.newLine();
			br.write("ゲーム開始：" + sdf2.format(this.startTime));
			br.newLine();
			br.write("ゲーム終了：" + sdf2.format(this.finishTime));

			br.newLine();
			br.newLine();

			if(this.result) {
				result = "GAME CLEAR!!";
			}else {
				result = "GAME OVER";
			}
			br.write("結果：" + result);

			br.newLine();
			br.newLine();

			br.write("プレイヤー情報：");
			br.newLine();
			br.write("(名前)"+ this.h.getName());
			br.newLine();
			br.write("(HP)"+ this.firstHp + "→" + this.h.getHp());
			br.newLine();
			br.write("(MP)"+ this.firstMp + "→" + this.h.getMp());
			br.newLine();
			br.write("(攻撃力)"+ this.h.getAttack());
			br.newLine();
			br.write("(防御力)"+ this.h.getDefense());
			br.newLine();
			br.write("(必殺技威力)"+ this.h.getSpecialAttack());
			br.newLine();
			br.write("(レベル)"+ this.h.getLevel());

			br.newLine();
			br.newLine();

			br.write("進んだ階数：" + this.resultStage + "階");

			br.flush();

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			if( br != null){
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
