import java.util.List;

import dao.DAO;
import model.News;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		List<News> list = dao.GetNews();
		System.out.println(list.size());
	}

}
