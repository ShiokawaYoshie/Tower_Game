package sukkiriTower_22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MonsterDBConnect implements DBConnect {
	private final String URL = "jdbc:postgresql://localhost:5432/monster";
	private final String USER = "postgres";
	private final String PASSWORD = "test";
	List<String> monsterData = new ArrayList<>();

	//DBからMonsterのデータを取得
	public List getMonsterData(int i) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet re = null;

		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "select * from monster where monster_no = ? ;";
			ps = con.prepareStatement(sql);
			ps.setInt(1, i);
			re = ps.executeQuery();
			while (re.next()) {
				monsterData.add(re.getString("name"));
				monsterData.add(re.getString("hp"));
				monsterData.add(re.getString("mp"));
				monsterData.add(re.getString("power"));
				monsterData.add(re.getString("defense"));
				monsterData.add(re.getString("special_power"));
				monsterData.add(re.getString("experience_point"));
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			System.out.println("DB接続時に異常が発生しました。");
			e.printStackTrace();
		}finally {
			if(re != null) {
				try {
					re.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}

		return monsterData;

	}

	//MonsterをDBにセットする
	public void setCharacterDate(int id, String name, int hp, int mp, int power, int defense, int specialPower, int experiencePoint) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet re = null;

		try {
			int count = 0;
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "insert into monster values(?,?,?,?,?,?,?,?) ; " ;
				ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setInt(3, hp);
				ps.setInt(4, mp);
				ps.setInt(5, power );
				ps.setInt(6, defense);
				ps.setInt(7, specialPower);
				ps.setInt(8, experiencePoint);
				count = ps.executeUpdate();
//				System.out.println(count + "件の処理が実行されました。");


		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			if(re != null) {
				try {
					re.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
	}

	//MonsterDBのデータを消去
	public void clearTable() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet re = null;

		try {
			int count = 0;
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql1 = " truncate table monster ";
			ps= con.prepareStatement(sql1);
			count += ps.executeUpdate();
//			System.out.println(count + "件の処理が実行されました。");


		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			if(re != null) {
				try {
					re.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
	}

	public List getMonsterInfo() {
		List<String> MonsterInfo  = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet re = null;

		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			String sql = " select monster_no, name from Monster ; ";
			ps = con.prepareStatement(sql);
			re= ps.executeQuery();
			while(re.next()) {
				String info = re.getString("monster_no") + "," + re.getString("name");
				MonsterInfo.add(info);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			System.out.println("DB接続時に異常が発生しました。");
			e.printStackTrace();
		}finally {
			if(re!=null) {
				try {
					re.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
		return MonsterInfo;
	}

}
