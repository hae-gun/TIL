package annotation.servicespring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {
	@Autowired // 이름은 중요하지 않다. ProductVO 객체 있으면 받아옴.
	ProductVO vo;

	public ProductVO sell(double sale, int coupon) {
		// ProductVO vo = new ProductVO();
		// vo.setCode(100);
		// vo.setName("멀티컴퓨터");
		// vo.setPrice(1000000);
		vo.setSale(sale);
		vo.setCoupon(coupon);
		return vo;
	}

}
