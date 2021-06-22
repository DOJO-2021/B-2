package model;
import java.io.Serializable;

public class Stamp implements Serializable {
	private String menu;		// タイトル

	// 受講生or講師のメニューへ飛ぶJavabeans

	public Stamp() {
		this(null);
	}

	public Stamp(String menu) {
		this.menu = menu;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

}
