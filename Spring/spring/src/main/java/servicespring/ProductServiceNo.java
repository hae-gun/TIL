package servicespring;

public class ProductServiceNo implements ProductService {

	ProductDAO dao;
		
		
	public void setDao(ProductDAO dao) {
			this.dao = dao;
		}


	@Override
	public ProductVO sell() {
		System.out.println("정상판매 중입니다.");
//		ProductDAO dao = new ProductDAO();
		
		return dao.sell(0.0, 5);
	}
	
}
