package dao;

//public class CheckDao {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
//		public List<Check> select(Check param) {
//			Connection conn = null;
//			List<Check> cardList = new ArrayList<Check>();
//
//			try {
//				// JDBCドライバを読み込む
//				Class.forName("org.h2.Driver");
//				jdbc:h2:file:C:\pleiades\workspace\B-2\CAP\capdb
//				// データベースに接続する
//				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleides/workspace/data/simpleBC", "sa", "sa");
//
//				// SQL文を準備する
//				String sql = "SELECT id, company, company_hurigana, name, name_hurigana, department, position, address, phone, mail, remarks from BC"
////						+ " company,"
////						+ " company_hurigana,"
////						+ " name, name_hurigana,"
////						+ " department,"
////						+ " position,"
////						+ " address,"
////						+ " phone,"
////						+ " mail,"
////						+ " remarks"
//						+ " WHERE company LIKE ? AND company_hurigana like ? AND name LIKE ? AND name_hurigana like ? AND address LIKE ?";
////				System.out.println(sql);
//				PreparedStatement pStmt = conn.prepareStatement(sql);
//
//				// SQL文を完成させる
//				if (param.getCompany() != null) {
//					pStmt.setString(1, "%" + param.getCompany() + "%");
//				} else {
//					pStmt.setString(1, "%");
//				}
//				if (param.getCompany_hurigana() != null) {
//					pStmt.setString(2, "%" + param.getCompany_hurigana() + "%");
//				} else {
//					pStmt.setString(2, "%");
//				}
//				if (param.getName() != null) {
//					pStmt.setString(3, "%" + param.getName() + "%");
//				} else {
//					pStmt.setString(3, "%");
//				}
//				if (param.getName_hurigana() != null) {
//					pStmt.setString(4, "%" + param.getName_hurigana() + "%");
//				} else {
//					pStmt.setString(4, "%");
//				}
//
//				if (param.getAddress() != null) {
//					pStmt.setString(5, "%" + param.getAddress() + "%");
//				} else {
//					pStmt.setString(5, "%");
//				}
//
//
//
//				// SQL文を実行し、結果表を取得する
//				ResultSet rs = pStmt.executeQuery();
//
//				// 結果表をコレクションにコピーする
//				while (rs.next()) {
//					Bc card = new Bc(
//							rs.getInt("id"),
//							rs.getString("company"),
//							rs.getString("company_hurigana"),
//							rs.getString("name"),
//							rs.getString("name_hurigana"),
//							rs.getString("department"),
//							rs.getString("position"),
//							rs.getString("address"),
//							rs.getString("phone"),
//							rs.getString("mail"),
//							rs.getString("remarks")
//							);
//					cardList.add(card);
//
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//				cardList = null;
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//				cardList = null;
//			} finally {
//				// データベースを切断
//				if (conn != null) {
//					try {
//						conn.close();
//					} catch (SQLException e) {
//						e.printStackTrace();
//						cardList = null;
//					}
//				}
//			}
//
//			// 結果を返す
//			return cardList;
//		}
//
//		// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
//		public boolean insert(Bc card) {
//			Connection conn = null;
//			boolean result = false;
//
//			try {
//				// JDBCドライバを読み込む
//				Class.forName("org.h2.Driver");
//
//				// データベースに接続する
//				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleides/workspace/data/simpleBC", "sa", "");
//
//				// SQL文を準備する
//				String sql = "insert into BC values (null,?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
//				PreparedStatement pStmt = conn.prepareStatement(sql);
//
//				// SQL文を完成させる
//				if (card.getCompany() != null) {
//					pStmt.setString(1, card.getCompany());
//				} else {
//					pStmt.setString(1, "null");
//				}
//				if (card.getCompany_hurigana() != null) {
//					pStmt.setString(2, card.getCompany_hurigana());
//				} else {
//					pStmt.setString(2, "null");
//				}
//				if (card.getName() != null) {
//					pStmt.setString(3, card.getName());
//				} else {
//					pStmt.setString(3, "null");
//				}
//				if (card.getName_hurigana() != null) {
//					pStmt.setString(4, card.getName_hurigana());
//				} else {
//					pStmt.setString(4, "null");
//				}
//				if (card.getDepartment() != null) {
//					pStmt.setString(5, card.getDepartment());
//				} else {
//					pStmt.setString(5, "null");
//				}
//				if (card.getPosition() != null) {
//					pStmt.setString(6, card.getPosition());
//				} else {
//					pStmt.setString(6, "null");
//				}
//				if (card.getAddress() != null) {
//					pStmt.setString(7, card.getAddress());
//				} else {
//					pStmt.setString(7, "null");
//				}
//				if (card.getPhone() != null) {
//					pStmt.setString(8, card.getPhone());
//				} else {
//					pStmt.setString(8, "null");
//				}
//				if (card.getMail() != null) {
//					pStmt.setString(9, card.getMail());
//				} else {
//					pStmt.setString(9, "null");
//				}
//				if (card.getRemarks() != null) {
//					pStmt.setString(10, card.getRemarks());
//				} else {
//					pStmt.setString(10, "null");
//				}
//
//
//				// SQL文を実行する
//				if (pStmt.executeUpdate() == 1) {
//					result = true;
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			} finally {
//				// データベースを切断
//				if (conn != null) {
//					try {
//						conn.close();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//
//			// 結果を返す
//			return result;
//		}
//
//		// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
//		public boolean update(Bc card) {
//			Connection conn = null;
//			boolean result = false;
//
//			try {
//				// JDBCドライバを読み込む
//				Class.forName("org.h2.Driver");
//
//				// データベースに接続する
//				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleides/workspace/data/simpleBC", "sa", "");
//
//				// SQL文を準備する
//				String sql = "update BC set company=?,"
//						+ "company_hurigana=?,"
//						+ " name=?,"
//						+ " name_hurigana=?,"
//						+ "  department=?,"
//						+ " position=?,"
//						+ " address=?,"
//						+ " phone=?,"
//						+ " mail=?,"
//						+ "remarks=? "
//						+"where id=?";
//				PreparedStatement pStmt = conn.prepareStatement(sql);
//
//				// SQL文を完成させる
//				if (card.getCompany() != null) {
//					pStmt.setString(1, card.getCompany());
//				} else {
//					pStmt.setString(1, "null");
//				}
//				if (card.getCompany_hurigana() != null) {
//					pStmt.setString(2, card.getCompany_hurigana());
//				} else {
//					pStmt.setString(2, "null");
//				}
//				if (card.getName() != null) {
//					pStmt.setString(3, card.getName());
//				} else {
//					pStmt.setString(3, "null");
//				}
//				if (card.getName_hurigana() != null) {
//					pStmt.setString(4, card.getName_hurigana());
//				} else {
//					pStmt.setString(4, "null");
//				}
//				if (card.getDepartment() != null) {
//					pStmt.setString(5, card.getDepartment());
//				} else {
//					pStmt.setString(5, "null");
//				}
//				if (card.getPosition() != null) {
//					pStmt.setString(6, card.getPosition());
//				} else {
//					pStmt.setString(6, "null");
//				}
//				if (card.getAddress() != null) {
//					pStmt.setString(7, card.getAddress());
//				} else {
//					pStmt.setString(7, "null");
//				}
//				if (card.getPhone() != null) {
//					pStmt.setString(8, card.getPhone());
//				} else {
//					pStmt.setString(8, "null");
//				}
//				if (card.getMail() != null) {
//					pStmt.setString(9, card.getMail());
//				} else {
//					pStmt.setString(9, "null");
//				}
//				if (card.getRemarks() != null) {
//					pStmt.setString(10, card.getRemarks());
//				} else {
//					pStmt.setString(10, "null");
//				}
//
//
//				pStmt.setInt(11, card.getId());
//
//				// SQL文を実行する
//				if (pStmt.executeUpdate() == 1) {
//					result = true;
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			} finally {
//				// データベースを切断
//				if (conn != null) {
//					try {
//						conn.close();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//
//			// 結果を返す
//			return result;
//		}
//
//		// 引数idで指定されたレコードを削除し、成功したらtrueを返す
//		public boolean delete(int id) {
//			Connection conn = null;
//			boolean result = false;
//
//			try {
//				// JDBCドライバを読み込む
//				Class.forName("org.h2.Driver");
//
//				// データベースに接続する
//				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleides/workspace/data/simpleBC", "sa", "");
//
//				// SQL文を準備する
//				String sql = "delete from BC where id=?";
//				PreparedStatement pStmt = conn.prepareStatement(sql);
//
//				// SQL文を完成させる
//				pStmt.setInt(1, id);
//
//				// SQL文を実行する
//				if (pStmt.executeUpdate() == 1) {
//					result = true;
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			} finally {
//				// データベースを切断
//				if (conn != null) {
//					try {
//						conn.close();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//
//			// 結果を返す
//			return result;
//		}
//	}
//
//
