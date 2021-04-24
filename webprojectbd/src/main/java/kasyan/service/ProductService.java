package kasyan.service;

import kasyan.exceptions.ProductNotFoundException;
import kasyan.repository.RepositoryService;
import kasyan.bean.Product;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService extends RepositoryService implements InitializingBean {

    //отправка запроса на получение всех продуктов из основной БД
    public List<Product> findAll() {
        String select = "SELECT id, category, name, price, discount, actualPrice FROM product";
        return findProductFromBD(select);
    }

    //отправка запроса на получение всех ранее удаленных продуктов из основной БД
    public List<Product> findAllDeleted() {
        String select = "SELECT id, category, name, price, discount, actualPrice, data FROM productofdelete";
        return findDeleteProductFromBD(select);
    }

    /* отправка запроса на добавление новой записи в БД Product
    и автоматическим расчетом цены с учетом скидки */
    public void save(String category, String name, double price, double discount) {
        List<Product> newList = findAll();
        int id = createId(newList);
        double actualPrice = calculating(price, discount);
        String select = "INSERT product (id, category, name, price, discount, actualPrice) VALUES (" + id +
                " ,'" + category + "' ,'" + name + "' ," + price + " ," + discount + " ," + actualPrice + ")";
        selectBD(select);
    }

    // формирование ID с одновременной проверкой (если есть пропуск (например 2, 3, ,5 то будет присвоен id=4))
    public int createId(List<Product> newList) {
        int id = 0; // по умолчанию id = 0
        if (!newList.isEmpty()) { // если записи имеются, проверяем на пропущенные id
            SortDataBase.sortById(newList); //сортируем для корректной проверки
            int i = 0;
            for (Product product : newList) { // проверяем
                if (product.getId() == i) i++; // теперь i больше текущего id на 1
                id = i; // присваиваем значение id (здесь id на 1 больше последнего проверенного)
            }
        }
        return id;
    }

    // метод для расчета стоимости с учетом скидки
    public static double calculating(double price, double discount) {
        return (price - (price * discount / 100));
    }

    //находим конкретный Product по ID
    public Product findById(int id) throws ProductNotFoundException {
        List<Product> newList = findAll();
        for (Product product : newList) {
            if (product.getId() == id) {
                return product;
            }
        }
        throw new ProductNotFoundException("Product with id=" + id + " not found!");
    }

    //находим Product по его ID и отправка запроса в БД для удаления и одновременно добавления в "корзину" (и добавляем дату удаления)
    public void delete(int id) {
        List<Product> newList = findAll();
        String select = "";
        String deleteProduct = "";
        for (Product product : newList) {
            if (product.getId() == id) {
                select = "DELETE FROM product WHERE id=" + id;
                deleteProduct = "INSERT productofdelete (id, category, name, price, discount, actualPrice, data) VALUES (" + id +
                        " ,'" + product.getCategory() + "' ,'" + product.getName() + "' ," + product.getPrice() + " ," +
                        product.getDiscount() + " ," + product.getActualPrice() + ", NOW())";
                break;
            }
        }
        selectBD(select); // отправка запроса на удаление из основной БД
        selectBD(deleteProduct); // отправка запроса на добавление в корзину
    }

    //находим Product по его ID  в корзине и отправка запроса для удаления
    public void deleteOfBasket(int id) {
        List<Product> newList = findAllDeleted();
        String select = "";
        for (Product product : newList) {
            if (product.getId() == id) {
                select = "DELETE FROM productofdelete WHERE id=" + id;
                break;
            }
        }
        selectBD(select); // отправка запроса на удаление из основной БД
    }

    //находим Product по его ID  в корзине и отправка запроса для удаления
    public void cleanBasket() {
        selectBD("TRUNCATE TABLE productofdelete");
    }

    // восстановление всех записей из корзины
    public void recoveryAllProduct() {
        List<Product> newList = findAllDeleted();
        for (Product product : newList) {
            save(product.getCategory(), product.getName(), product.getPrice(), product.getDiscount());
        }
        cleanBasket();
    }

    //восстанавливаем удаленный ранее Product по его ID и отправка запроса в БД
    public void recovered(int id) {
        List<Product> newList = findAllDeleted();
        String selectDel = "";
        for (Product product : newList) {
            if (product.getId() == id) {
                save(product.getCategory(), product.getName(), product.getPrice(), product.getDiscount()); // добавление в основную БД
                selectDel = "DELETE FROM productofdelete WHERE id=" + id; // запрос на удаление из корзины
                break;
            }
        }
        selectBD(selectDel);
    }

    // отправляем запрос в БД на обновление Product по ID
    public void update(int id, String category, String name, double price, double discount) {
        double actualPrice = calculating(price, discount);
        String select = "UPDATE product SET category='" + category + "', name='" + name + "', price=" + price +
                ", discount=" + discount + ", actualPrice=" + actualPrice + " WHERE id=" + id;
        selectBD(select);
    }

    // установка скидки для одной категории
    public void updateDiscountForCategory(String category, double discount) {
        List<Product> listCategory = fineCategoryForRead(category);
        for (Product product : listCategory) {
            update(product.getId(), category, product.getName(), product.getPrice(), discount);
        }
    }

    // ищем все Products одной категории и отправляем в БД соответствующий запрос
    public List<Product> fineCategoryForRead(String category) {
        List<Product> listProduct = findAll();
        List<Product> newListForRead = new ArrayList<>();
        for (Product product : listProduct) {
            if (product.getCategory().equals(category)) {
                newListForRead.add(product);
            }
        }
        String select = "SELECT id, category, name, price, discount, actualPrice FROM product WHERE category='" + category + "'";
        findProductFromBD(select);
        return newListForRead;
    }

    // сортировка списка Products по категориям, в т.ч. и реверсивно
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
            default:
                throw new IllegalStateException("Unexpected value: " + sort);
        }
        return listProduct;
    }

    @Override
    public void afterPropertiesSet() {
    }
}