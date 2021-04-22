package kasyan.controller;

import kasyan.exceptions.ProductNotFoundException;
import kasyan.service.ExportToExcel;
import kasyan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

// Контроллер для работы с залогининым пользователем

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    private ProductService productService;
    private ExportToExcel exportToExcel;

    // получение всего списка продуктов из основной БД
    @GetMapping(value = "/allproduct")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/allproduct");
        modelAndView.addObject("product", productService.findAll());
        return modelAndView;
    }

    // получение всего списка продуктов из корзины
    @GetMapping(value = "/alldeletedproduct")
    public ModelAndView findAllDeletedProduct(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/alldeleteproducts");
        modelAndView.addObject("product", productService.findAllDeleted());
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

    // получение страницы с сообщением, что продукт удален из основной БД
    @GetMapping(value = "/deleteproduct")
    public ModelAndView deleteproduct(@RequestParam(value = "id") int id) throws ProductNotFoundException {
          productService.delete(id);
        return new ModelAndView("adminpages/deleteproduct");
    }

    // получение страницы с сообщением, что продукт удален из корзины
    @GetMapping(value = "/deleteproductbasket")
    public ModelAndView deleteproductbasket(@RequestParam(value = "id") int id) throws ProductNotFoundException {
        productService.deleteBasket(id);
        return new ModelAndView("adminpages/deleteproductbasket");
    }

    // получение страницы с сообщением, что продукт восстановлен
    @GetMapping(value = "/recoveredproduct")
    public ModelAndView recoveredProduct(@RequestParam(value = "id") int id){
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
                             @RequestParam(value = "discount") double discount) throws ProductNotFoundException {
        productService.update(id, category, name, price, discount);
        return new ModelAndView("redirect:/product/allproduct");
    }

    // сортировка списка по ID (от меньшего к большему)
    @GetMapping(value = "/sortbyid")
    public ModelAndView sortById() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbyid");
        modelAndView.addObject("product", productService.sortList(1));
        return modelAndView;
    }

    // сортировка списка по ID (от большего к меньшему)
    @GetMapping(value = "/sortbyidreverse")
    public ModelAndView sortByIdReverse() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbyidreverse");
        modelAndView.addObject("product", productService.sortList(2));
        return modelAndView;
    }

    // сортировка списка по категории (от A к Z)
    @GetMapping(value = "/sortbycategory")
    public ModelAndView sortByCategory() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbycategory");
        modelAndView.addObject("product", productService.sortList(3));
        return modelAndView;
    }

    // сортировка списка по категории (от Z к A)
    @GetMapping(value = "/sortbycategoryreverse")
    public ModelAndView sortByCategoryReverse() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbycategoryreverse");
        modelAndView.addObject("product", productService.sortList(4));
        return modelAndView;
    }

    // сортировка списка по названию (A -> Z)
    @GetMapping(value = "/sortbyname")
    public ModelAndView sortByName() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbyname");
        modelAndView.addObject("product", productService.sortList(5));
        return modelAndView;
    }

    // сортировка списка по названию (Z -> A)
    @GetMapping(value = "/sortbynamereverse")
    public ModelAndView sortByNameReverse() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbynamereverse");
        modelAndView.addObject("product", productService.sortList(6));
        return modelAndView;
    }

    // сортировка списка по цене (от меньшего к большему)
    @GetMapping(value = "/sortbyprice")
    public ModelAndView sortByPrice() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbyprice");
        modelAndView.addObject("product", productService.sortList(7));
        return modelAndView;
    }

    // сортировка списка по цене (от большего к меньшему)
    @GetMapping(value = "/sortbypricereverse")
    public ModelAndView sortByPriceReverse() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbypricereverse");
        modelAndView.addObject("product", productService.sortList(8));
        return modelAndView;
    }

    // сортировка списка по скидке (от меньшего к большему)
    @GetMapping(value = "/sortbydiscount")
    public ModelAndView sortByDiscount() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbydiscount");
        modelAndView.addObject("product", productService.sortList(9));
        return modelAndView;
    }

    // сортировка списка по скидке (от большего к меньшему)
    @GetMapping(value = "/sortbydiscountreverse")
    public ModelAndView sortByDiscountReverse() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbydiscountreverse");
        modelAndView.addObject("product", productService.sortList(10));
        return modelAndView;
    }

    // сортировка списка по конечной цене (от меньшего к большему)
    @GetMapping(value = "/sortbyactualprice")
    public ModelAndView sortByActualPrice() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbyactualprice");
        modelAndView.addObject("product", productService.sortList(11));
        return modelAndView;
    }

    // сортировка списка по конечной цене (от большего к меньшему)
    @GetMapping(value = "/sortbyactualpricereverse")
    public ModelAndView sortByActualPriceReverse() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbyactualpricereverse");
        modelAndView.addObject("product", productService.sortList(12));
        return modelAndView;
    }

    // получение списка категории FRUITS
    @GetMapping(value = "/finefruits")
    public ModelAndView fineFruits() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/finecategory/finefruits");
        modelAndView.addObject("product", productService.fineCategoryForRead("FRUITS"));
        return modelAndView;
    }

    // получение списка категории BERRIES
    @GetMapping(value = "/fineberries")
    public ModelAndView fineBerries() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/finecategory/fineberries");
        modelAndView.addObject("product", productService.fineCategoryForRead("BERRIES"));
        return modelAndView;
    }

    // получение списка категории VEGETABLES
    @GetMapping(value = "/finevegetables")
    public ModelAndView fineVegetables() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/finecategory/finevegetables");
        modelAndView.addObject("product", productService.fineCategoryForRead("VEGETABLES"));
        return modelAndView;
    }

    // получение списка категории MILK_PRODUCT
    @GetMapping(value = "/finemilkproduct")
    public ModelAndView fineMilkProduct() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/finecategory/finemilkproduct");
        modelAndView.addObject("product", productService.fineCategoryForRead("MILK_PRODUCT"));
        return modelAndView;
    }

    // получение списка категории ALCOHOLIC_BEVERAGES
    @GetMapping(value = "/finealcohol")
    public ModelAndView fineAlcohol() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/finecategory/finealcohol");
        modelAndView.addObject("product", productService.fineCategoryForRead("ALCOHOLIC_BEVERAGES"));
        return modelAndView;
    }

    // получение списка категории MEAT
    @GetMapping(value = "/finemeat")
    public ModelAndView fineMeat() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/finecategory/finemeat");
        modelAndView.addObject("product", productService.fineCategoryForRead("MEAT"));
        return modelAndView;
    }

    // получение списка категории ALCOHOLIC_BEVERAGES
    @GetMapping(value = "/exportexcel/alcohol")
    public ModelAndView exportExcelAlcohol() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/exportexcel/alcohol");
        modelAndView.addObject("product", exportToExcel.exportCategoryList("ALCOHOLIC_BEVERAGES"));
        return modelAndView;
    }

    // экспорт списка категории BERRIES в excel
    @GetMapping(value = "/exportexcel/berries")
    public ModelAndView exportExcelBerries() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/exportexcel/berries");
        modelAndView.addObject("product", exportToExcel.exportCategoryList("BERRIES"));
        return modelAndView;
    }

    // экспорт списка категории FRUITS в excel
    @GetMapping(value = "/exportexcel/fruits")
    public ModelAndView exportExcelFruits() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/exportexcel/fruits");
        modelAndView.addObject("product", exportToExcel.exportCategoryList("FRUITS"));
        return modelAndView;
    }

    // экспорт списка категории MEAT в excel
    @GetMapping(value = "/exportexcel/meat")
    public ModelAndView exportExcelMeat() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/exportexcel/meat");
        modelAndView.addObject("product", exportToExcel.exportCategoryList("MEAT"));
        return modelAndView;
    }

    // экспорт списка категории MILK_PRODUCT в excel
    @GetMapping(value = "/exportexcel/milk")
    public ModelAndView exportExcelMikl() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/exportexcel/milk");
        modelAndView.addObject("product", exportToExcel.exportCategoryList("MILK_PRODUCT"));
        return modelAndView;
    }

    // экспорт списка категории VEGETABLES в excel
    @GetMapping(value = "/exportexcel/vegetables")
    public ModelAndView exportExcelVegetables() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/exportexcel/vegetables");
        modelAndView.addObject("product", exportToExcel.exportCategoryList("VEGETABLES"));
        return modelAndView;
    }

    @Autowired
    public  void setProductServiceImpl(ProductService productService){
        this.productService = productService;
    }
    @Autowired
    public  void setExportToExcel(ExportToExcel exportToExcel){
        this.exportToExcel = exportToExcel;
    }
}