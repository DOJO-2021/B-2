package test;

import java.util.List;

import dao.UserDao;
import model.User;

public class UserDaotest {
	public static void main(String[] args) {
		UserDao dao = new UserDao();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<User> cardList2 = dao.select(new User(1,"相川","","","","","",""));  // 田、県を含むものをリストで出す↓
		for (User card : cardList2) {
			System.out.println("id：" + card.getUser_id());
			System.out.println("l_name：" + card.getUser_l_name());
			System.out.println("f_name：" + card.getUser_f_name());
			System.out.println("sex:" + card.getUser_password());
			System.out.println("age：" + card.getUser_questions());
			System.out.println("department_name：" + card.getUser_answer());
			System.out.println("company：" + card.getUser_word());
			System.out.println("tell：" + card.getUser_type());
		}

		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		User insRec = new User(0,"test","test","test","test","test","test","test");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			List<User> cardList3 = dao.select(insRec);
			for (User card : cardList3) {
				System.out.println("id：" + card.getUser_id());
				System.out.println("l_name：" + card.getUser_l_name());
				System.out.println("f_name：" + card.getUser_f_name());
				System.out.println("sex:" + card.getUser_password());
				System.out.println("age：" + card.getUser_questions());
				System.out.println("department_name：" + card.getUser_answer());
				System.out.println("company：" + card.getUser_word());
				System.out.println("tell：" + card.getUser_type());
			}
		}
		else {
			System.out.println("登録失敗！");
		}

		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		User upRec = new User(0,"test","test","test","test","test","test","test");
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
			List<User> cardList4 = dao.select(upRec);
			for (User card : cardList4) {
				System.out.println("id：" + card.getUser_id());
				System.out.println("l_name：" + card.getUser_l_name());
				System.out.println("f_name：" + card.getUser_f_name());
				System.out.println("sex:" + card.getUser_password());
				System.out.println("age：" + card.getUser_questions());
				System.out.println("department_name：" + card.getUser_answer());
				System.out.println("company：" + card.getUser_word());
				System.out.println("tell：" + card.getUser_type());
			}
		}
		else {
			System.out.println("更新失敗！");
		}
	}
}
