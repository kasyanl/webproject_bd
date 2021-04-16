package kasyan.controller;

import kasyan.exceptions.ProductNotFoundException;
import kasyan.service.ExportToExcel;
import kasyan.service.ProductService;
import kasyan.service.ProductServiceBD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    private ProductService productService;
    private ProductServiceBD productServiceBD;

    @GetMapping(value = "/allproduct")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/allproduct");
        modelAndView.addObject("product", productServiceBD.getAll());
        return modelAndView;
    }

    @GetMapping
    public ModelAndView findById(@RequestParam(value = "id") int id) throws ProductNotFoundException {
        ModelAndView modelAndView = new ModelAndView("productcard");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }

    @GetMapping(value = "/addproduct")
    public String addproduct() {
        return "adminpages/addproduct";
    }

    @PostMapping(value = "/addproduct")
    public ModelAndView add(@RequestParam(value = "category") String category,
                            @RequestParam(value = "name") String name,
                            @RequestParam(value = "price") double price,
                            @RequestParam(value = "discount") double discount) {
        productService.save(category, name, price, discount);
        return new ModelAndView("redirect:/product/allproduct");
    }

    @GetMapping(value = "/deleteproduct")
    public ModelAndView deleteproduct(@RequestParam(value = "id") int id) {
          productService.delete(id);
        return new ModelAndView("adminpages/deleteproduct");
    }

     @GetMapping(value = "/editproduct")
    public ModelAndView edit(@RequestParam(value = "id") int id) throws ProductNotFoundException {
        ModelAndView modelAndView = new ModelAndView("adminpages/editproduct");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }

    @PostMapping(value = "/editproduct")
    public ModelAndView edit(@RequestParam(value = "id") int id,
                             @RequestParam(value = "category") String category,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value = "price") double price,
                             @RequestParam(value = "discount") double discount) throws ProductNotFoundException {
        productService.update(id, category, name, price, discount);
        return new ModelAndView("redirect:/product/allproduct");
    }

    @GetMapping(value = "/sortbyid")
    public ModelAndView sortById() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbyid");
        modelAndView.addObject("product", productService.sortList(1));
        return modelAndView;
    }

    @GetMapping(value = "/sortbyidreverse")
    public ModelAndView sortByIdReverse() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbyidreverse");
        modelAndView.addObject("product", productService.sortList(2));
        return modelAndView;
    }

    @GetMapping(value = "/sortbycategory")
    public ModelAndView sortByCategory() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbycategory");
        modelAndView.addObject("product", productService.sortList(3));
        return modelAndView;
    }

    @GetMapping(value = "/sortbycategoryreverse")
    public ModelAndView sortByCategoryReverse() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbycategoryreverse");
        modelAndView.addObject("product", productService.sortList(4));
        return modelAndView;
    }

    @GetMapping(value = "/sortbyname")
    public ModelAndView sortByName() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbyname");
        modelAndView.addObject("product", productService.sortList(5));
        return modelAndView;
    }

    @GetMapping(value = "/sortbynamereverse")
    public ModelAndView sortByNameReverse() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbynamereverse");
        modelAndView.addObject("product", productService.sortList(6));
        return modelAndView;
    }

    @GetMapping(value = "/sortbyprice")
    public ModelAndView sortByPrice() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbyprice");
        modelAndView.addObject("product", productService.sortList(7));
        return modelAndView;
    }

    @GetMapping(value = "/sortbypricereverse")
    public ModelAndView sortByPriceReverse() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbypricereverse");
        modelAndView.addObject("product", productService.sortList(8));
        return modelAndView;
    }

    @GetMapping(value = "/sortbydiscount")
    public ModelAndView sortByDiscount() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbydiscount");
        modelAndView.addObject("product", productService.sortList(9));
        return modelAndView;
    }

    @GetMapping(value = "/sortbydiscountreverse")
    public ModelAndView sortByDiscountReverse() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbydiscountreverse");
        modelAndView.addObject("product", productService.sortList(10));
        return modelAndView;
    }

    @GetMapping(value = "/sortbyactualprice")
    public ModelAndView sortByActualPrice() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbyactualprice");
        modelAndView.addObject("product", productService.sortList(11));
        return modelAndView;
    }

    @GetMapping(value = "/sortbyactualpricereverse")
    public ModelAndView sortByActualPriceReverse() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbyactualpricereverse");
        modelAndView.addObject("product", productService.sortList(12));
        return modelAndView;
    }

    @GetMapping(value = "/finefruits")
    public ModelAndView fineFruits() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/finecategory/finefruits");
        modelAndView.addObject("product", ProductService.fineCategoryForRead("FRUITS"));
        return modelAndView;
    }

    @GetMapping(value = "/fineberries")
    public ModelAndView fineBerries() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/finecategory/fineberries");
        modelAndView.addObject("product", ProductService.fineCategoryForRead("BERRIES"));
        return modelAndView;
    }

    @GetMapping(value = "/finevegetables")
    public ModelAndView fineVegetables() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/finecategory/finevegetables");
        modelAndView.addObject("product", ProductService.fineCategoryForRead("VEGETABLES"));
        return modelAndView;
    }

    @GetMapping(value = "/finemilkproduct")
    public ModelAndView fineMilkProduct() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/finecategory/finemilkproduct");
        modelAndView.addObject("product", ProductService.fineCategoryForRead("MILK_PRODUCT"));
        return modelAndView;
    }

    @GetMapping(value = "/finealcohol")
    public ModelAndView fineAlcohol() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/finecategory/finealcohol");
        modelAndView.addObject("product", ProductService.fineCategoryForRead("ALCOHOLIC_BEVERAGES"));
        return modelAndView;
    }

    @GetMapping(value = "/finemeat")
    public ModelAndView fineMeat() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/finecategory/finemeat");
        modelAndView.addObject("product", ProductService.fineCategoryForRead("MEAT"));
        return modelAndView;
    }

    @GetMapping(value = "/exportexcel/alcohol")
    public ModelAndView exportExcelAlcohol() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/exportexcel/alcohol");
        modelAndView.addObject("product", ExportToExcel.exportCategoryList("ALCOHOLIC_BEVERAGES"));
        return modelAndView;
    }
    @GetMapping(value = "/exportexcel/berries")
    public ModelAndView exportExcelBerries() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/exportexcel/berries");
        modelAndView.addObject("product", ExportToExcel.exportCategoryList("BERRIES"));
        return modelAndView;
    }
    @GetMapping(value = "/exportexcel/fruits")
    public ModelAndView exportExcelFruits() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/exportexcel/fruits");
        modelAndView.addObject("product", ExportToExcel.exportCategoryList("FRUITS"));
        return modelAndView;
    }
    @GetMapping(value = "/exportexcel/meat")
    public ModelAndView exportExcelMeat() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/exportexcel/meat");
        modelAndView.addObject("product", ExportToExcel.exportCategoryList("MEAT"));
        return modelAndView;
    }
    @GetMapping(value = "/exportexcel/milk")
    public ModelAndView exportExcelMikl() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/exportexcel/milk");
        modelAndView.addObject("product", ExportToExcel.exportCategoryList("MILK_PRODUCT"));
        return modelAndView;
    }
    @GetMapping(value = "/exportexcel/vegetables")
    public ModelAndView exportExcelVegetables() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/exportexcel/vegetables");
        modelAndView.addObject("product", ExportToExcel.exportCategoryList("VEGETABLES"));
        return modelAndView;
    }


    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleStudentNotFoundException(ProductNotFoundException exception) {
        ModelAndView modelAndView = new ModelAndView("usernotfound");
        modelAndView.addObject("exception", exception.getMessage());
        return modelAndView;
    }

//    @Autowired
//    public void setProductService(ProductService productService) {
//        this.productService = productService;
//    }


    @Autowired
    public void setProductServiceBD(ProductServiceBD productServiceBD) {
        this.productServiceBD = productServiceBD;
    }
}

