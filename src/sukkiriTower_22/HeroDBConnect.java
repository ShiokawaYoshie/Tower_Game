package sukkiriTower_22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HeroDBConnect implements DBConnect {
	private  String URL ;
	private  String USER ;
	private  String PASSWORD;
	List<String> heroData = new ArrayList<>();

	public HeroDBConnect(String[] args) {
		this.URL = args[0];
		this.USER = args[1];
		this.PASSWORD = args[2];
	}

	//DBにあるHeroの情報をインスタンスにセットするメソッド
	public List getHeroData(int i) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet re = null;

		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			String sql = " select * from hero where hero_id = ? ; ";
			ps = con.prepareStatement(sql);
			ps.setInt(1,i);
			re= ps.executeQuery();
			while(re.next()) {
				heroData.add(re.getString("name"));
				heroData.add(re.getString("hp"));
				heroData.add(re.getString("mp"));
				heroData.add(re.getString("power"));
				heroData.add(re.getString("defense"));
				heroData.add(re.getString("special_power"));
				heroData.add(re.getString("experience_point"));

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
		return heroData;
	}


	//Heroの名前だけ習得
	public List getHeroInfo() {
		List<String> heroName  = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet re = null;

		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			String sql = " select name from hero ; ";
			ps = con.prepareStatement(sql);
			re= ps.executeQuery();
			while(re.next()) {
				heroName.add(re.getString("name"));
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
		return heroName;
	}

	//DBにHero情報をセットするメソッド
	public void setCharacterDate(int id, String name, int hp, int mp, int power, int defense, int specialPower, int experiencePoint) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet re = null;

		try {
			int count = 0;
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql1 = "insert into hero values(?,?,?,?,?,?,?,?) ; " ;
			ps = con.prepareStatement(sql1);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, hp);
			ps.setInt(4, mp);
			ps.setInt(5, power );
			ps.setInt(6, defense);
			ps.setInt(7, specialPower);
			ps.setInt(8, experiencePoint);
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

	//Herotableの情報を消去するメソッド
	public void clearTable() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet re = null;

		try {
			int count = 0;
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql1 = " truncate table hero ";
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

}
