package annotation.servicespring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class ProductServiceNo implements ProductService {

	@Autowired
	ProductDAO dao;

	@Override
	public ProductVO sell() {
		System.out.println("정상판매 중입니다.");
//		ProductDAO dao = new ProductDAO();

		return dao.sell(0.0, 5);
	}

}
