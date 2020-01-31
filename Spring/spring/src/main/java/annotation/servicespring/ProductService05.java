package annotation.servicespring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service05")
public class ProductService05 implements ProductService {

	@Autowired // <bean>태그 X -> @Repository 로 만들어진 것.
	ProductDAO dao;

	@Override
	public ProductVO sell() {
		System.out.println("5월은 30% 세일중입니다.");
//		ProductDAO dao = new ProductDAO();

		return dao.sell(0.3, 1);
	}

}
