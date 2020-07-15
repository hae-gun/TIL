package servicespring;

public class ProductDAO {
	
	ProductVO vo;

	public void setVo(ProductVO vo) {
		this.vo = vo;
	}
	public ProductVO sell(double sale, int coupon) {
		//ProductVO vo = new ProductVO();
		//vo.setCode(100);
		//vo.setName("멀티컴퓨터");
		//vo.setPrice(1000000);
		vo.setSale(sale);
		vo.setCoupon(coupon);
		return vo;
	}
	
}
