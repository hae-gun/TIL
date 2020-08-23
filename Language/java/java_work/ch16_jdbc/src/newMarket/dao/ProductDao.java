package newMarket.dao;

import java.util.List;

import newMarket.vo.Product;

public interface ProductDao {

	List<Product> getAll();

	Product searchNSN(String nsn);

	int insertProduct(String nsn, int type_no, String name, int price, int amount);

	int updateProduct(String nsn, int amount);

	int orderProduct(String nsn, String id, String string, int amount);
	int makeOrderList(String nsn,String id,int amount);
}
