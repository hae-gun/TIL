package servicespring;

public class ProductService05 implements ProductService {

	ProductDAO dao;
		
		
	public void setDao(ProductDAO dao) {
			this.dao = dao;
		}


	@Override
	public ProductVO sell() {
		System.out.println("5월은 30% 세일중입니다.");
//		ProductDAO dao = new ProductDAO();
		
		return dao.sell(0.3, 1);
	}
	
}
