package kasyan.controller;

import kasyan.bean.Product;
import kasyan.exceptions.ProductNotFoundException;
import kasyan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

// Контроллер для работы с залогининым пользователем

@Controller
@RequestMapping(value = "/product")
public class ProductCrudOperationController {

    private ProductService productService;

    // получение всего списка продуктов из основной БД
    @GetMapping(value = "/allproduct")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/allproduct");
        modelAndView.addObject("product", productService.findAll());
        return modelAndView;
    }

    // полечение всего списка продуктов из лсновной бд для Гостя
    @GetMapping(value = "/allproductguest")
    public ModelAndView findAllForGuest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/allproductguest");
        modelAndView.addObject("product", productService.findAll());
        return modelAndView;
    }

    // получение страницы с формой для добавления продукта
    @GetMapping(value = "/addproduct")
    public String addproduct() {
        return "adminpages/addproduct";
    }

    // отправка данных для добавления продуктов в БД и перенаправления на страницу со всем списком
    @PostMapping(value = "/addproduct")
    public ModelAndView add(@RequestParam(value = "category") String category,
                            @RequestParam(value = "name") String name,
                            @RequestParam(value = "price") double price,
                            @RequestParam(value = "discount") double discount) {
        productService.save(category, name, price, discount);
        return new ModelAndView("redirect:/product/allproduct");
    }

    // получение всего списка продуктов из корзины
    @GetMapping(value = "/bascket")
    public ModelAndView bascket() {
        if(!productService.basketIsEmpty()) {
            return new ModelAndView("redirect:/product/alldeletedproduct");
        }
        return new ModelAndView("adminpages/bascketempty");
    }

    // получение страницы с формой для добавления продукта
    @GetMapping(value = "/bascketempty")
    public String bascketEmpty() {
        return "adminpages/bascketempty";
    }

    @GetMapping(value = "/alldeletedproduct")
    public ModelAndView findAllDeletedProduct() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/alldeleteproducts");
        modelAndView.addObject("product", productService.findAllDeleted());
        return modelAndView;
    }

    // получение страницы с сообщением, что продукт удален из основной БД
    @GetMapping(value = "/deleteproduct")
    public ModelAndView deleteproduct(@RequestParam(value = "id") int id) throws ProductNotFoundException {
        productService.delete(id);
        return new ModelAndView("adminpages/deleteproduct");
    }

    // получение страницы с сообщением, что продукт удален из корзины
    @GetMapping(value = "/deleteproductbasket")
    public ModelAndView deleteproductbasket(@RequestParam(value = "id") int id) throws ProductNotFoundException {
        productService.deleteOfBasket(id);
        return new ModelAndView("adminpages/deleteproductbasket");
    }

    // очистка корзины
    @GetMapping(value = "/cleanbascket")
    public String cleanBascket() {
        productService.cleanBasket();
        return "adminpages/cleanbascket";
    }

    // восстановление всех данных из корзины
    @GetMapping(value = "/recoveredallproduct")
    public String recoveredAllProduct() {
        productService.recoveryAllProduct();
        return "adminpages/recoveredallproduct";
    }

    // получение страницы с сообщением, что продукт восстановлен
    @GetMapping(value = "/recoveredproduct")
    public ModelAndView recoveredProduct(@RequestParam(value = "id") int id) {
        productService.recovered(id);
        return new ModelAndView("adminpages/recoveredproduct");
    }

    // получение страницы с формой для редактирования данных продукта
    @GetMapping(value = "/editproduct")
    public ModelAndView edit(@RequestParam(value = "id") int id) throws ProductNotFoundException {
        ModelAndView modelAndView = new ModelAndView("adminpages/editproduct");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }

    // отправка обновленных данных в БД и перенаправление на страницу со всем списком
    @PostMapping(value = "/editproduct")
    public ModelAndView edit(@RequestParam(value = "id") int id,
                             @RequestParam(value = "category") String category,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value = "price") double price,
                             @RequestParam(value = "discount") double discount) {
        productService.update(id, category, name, price, discount);
        return new ModelAndView("redirect:/product/allproduct");
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}