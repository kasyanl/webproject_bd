package kasyan.service;

import kasyan.exceptions.ProductNotFoundException;
import kasyan.util.SQLConfiguration;
import kasyan.bean.Product;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService extends SQLConfiguration implements InitializingBean {

    public static int COUNTER;
    public List<Product> findAll() {
        return findProductFromBD("SELECT id, category, name, price, discount, actualPrice FROM product");
    }

    public void save(String category, String name, double price, double discount) {
        List<Product> newList = findAll();
        int id = COUNTER;
        if (!newList.isEmpty()) {
            SortDataBase.sortById(newList);
            int i = 1;
            for (Product product : newList) {
                if (product.getId() == i) i++;
                id = i;
            }
        } else id = newList.size();
        double actualPrice = calculating(price, discount);
        String select = "INSERT INTO product (id, category, name, price, discount, actualPrice) VALUES (" + id +
                " ,'" + category + "' ,'" + name + "' ," + price + " ," + discount + " ," + actualPrice + ")";
        selectBD(select);

    }

    public static double calculating(double price, double discount) {
        return (price - (price * discount / 100));
    }

    public Product findById(int id) throws ProductNotFoundException {
        String select = "";
        List<Product> newList = findAll();
        for (Product product : newList) {
            if (product.getId() == id)
                select = "SELECT id, category, name, price, discount, actualPrice FROM product WHERE id=" + id + "";
            return findByIdFromBD(select);
        }
        throw new ProductNotFoundException("Product with id=" + id + " not found!");

    }

    public void delete(int id){
        List<Product> newList = findAll();
        String select = "";
        for (Product product : newList) {
            if (product.getId() == id)
                select = "DELETE * FROM product WHERE id=" + id + "";
            selectBD(select);
        }
        newList.removeIf(nextProduct -> nextProduct.getId() == id);
    }

    public void update(int id, String category, String name, double price, double discount) throws ProductNotFoundException {
        Product product = findById(id);
        product.setCategory(category);
        product.setName(name);
        product.setPrice(price);
        product.setDiscount(discount);
        product.setActualPrice(calculating(product.getPrice(), product.getDiscount()));
        String select = "UPDATE product SET category='" + category + "', name='" + name + "', price=" + price +
                ", discount=" + discount + "actualPrice=" + calculating(price, discount) + " WHERE id=" + product.getId()+ "";
        selectBD(select);

    }

    public List<Product> fineCategoryForRead(String category) {
        List<Product> listProduct = findAll();
        List<Product> newListForRead = new ArrayList<>();
        for (Product product : listProduct) {
            if (product.getCategory().equals(category)) {
                newListForRead.add(product);
            }
        }
        String select = "SELECT id, category, name, price, discount, actualPrice FROM product WHERE category='"+category+"'";
        findProductFromBD(select);
        return newListForRead;
    }

    public List<Product> sortList(int sort) {
        List<Product> listProduct = findAll();

        switch (sort) {
            case 1:
                SortDataBase.sortById(listProduct);
                break;
            case 2:
                SortDataBase.sortByIdReverse(listProduct);
                break;
            case 3:
                SortDataBase.sortByCategory(listProduct);
                break;
            case 4:
                SortDataBase.sortByCategoryReverse(listProduct);
                break;
            case 5:
                SortDataBase.sortByName(listProduct);
                break;
            case 6:
                SortDataBase.sortByNameReverse(listProduct);
                break;
            case 7:
                SortDataBase.sortByPrice(listProduct);
                break;
            case 8:
                SortDataBase.sortByPriceReverse(listProduct);
                break;
            case 9:
                SortDataBase.sortByDiscount(listProduct);
                break;
            case 10:
                SortDataBase.sortByDiscountReverse(listProduct);
                break;
            case 11:
                SortDataBase.sortByActualPrice(listProduct);
                break;
            case 12:
                SortDataBase.sortByActualPriceReverse(listProduct);
                break;
        }
        return listProduct;
    }

    @Override
    public void afterPropertiesSet(){

    }
}
