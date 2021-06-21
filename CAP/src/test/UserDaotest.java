package test;

import java.util.List;

import dao.UserDao;
import model.User;

public class UserDaotest {
	public static void main(String[] args) {
		UserDao dao = new UserDao();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<User> cardList2 = dao.select(new User(1,"","","","","",0));  // 田、県を含むものをリストで出す↓
		for (User card : cardList2) {
			System.out.println("user_id：" + card.getUser_id());
			System.out.println("l_name：" + card.getUser_l_name());
			System.out.println("f_name：" + card.getUser_f_name());
			System.out.println("user_password:" + card.getUser_password());
			System.out.println("secret_id：" + card.getSecret_id());
			System.out.println("user_name：" + card.getUser_answer());
			System.out.println("user_type：" + card.getUser_type());
		}

		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		User insRec = new User(0,"test","test","test","test","test",0);
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			List<User> cardList3 = dao.select(insRec);
			for (User card : cardList3) {
				System.out.println("user_id：" + card.getUser_id());
				System.out.println("l_name：" + card.getUser_l_name());
				System.out.println("f_name：" + card.getUser_f_name());
				System.out.println("user_password:" + card.getUser_password());
				System.out.println("secret_id：" + card.getSecret_id());
				System.out.println("user_name：" + card.getUser_answer());
				System.out.println("user_type：" + card.getUser_type());
			}
		}
		else {
			System.out.println("登録失敗！");
		}

		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		User upRec = new User(0,"相川","侑璃","aikawa","3","うり",1);
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
			List<User> cardList4 = dao.select(upRec);
			for (User card : cardList4) {
				System.out.println("user_id：" + card.getUser_id());
				System.out.println("l_name：" + card.getUser_l_name());
				System.out.println("f_name：" + card.getUser_f_name());
				System.out.println("user_password:" + card.getUser_password());
				System.out.println("secret_id：" + card.getSecret_id());
				System.out.println("user_name：" + card.getUser_answer());
				System.out.println("user_type：" + card.getUser_type());
			}
		}
		else {
			System.out.println("更新失敗！");
		}
	}
}
