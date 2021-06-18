package test;

import java.util.List;

import dao.SecretDao;
import model.User;

public class SecretDaoTest {
	public static void main(String[] args) {
		SecretDao dao = new SecretDao();

		// select()のテスト
		System.out.println("---------- selectById()のテスト ----------");
		List<User> cardList2 = dao.selectById(new User(1,"","","","","",0));  // 田、県を含むものをリストで出す↓
		for (User card : cardList2) {
			System.out.println("id：" + card.getUser_id());
			System.out.println("l_name：" + card.getUser_l_name());
			System.out.println("f_name：" + card.getUser_f_name());
			System.out.println("sex:" + card.getUser_password());
			System.out.println("age：" + card.getSecret_id());
			System.out.println("department_name：" + card.getUser_answer());
			System.out.println("tell：" + card.getUser_type());
		}
	}
}
