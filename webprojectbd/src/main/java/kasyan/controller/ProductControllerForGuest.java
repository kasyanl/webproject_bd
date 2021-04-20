package kasyan.controller;

import kasyan.exceptions.ProductNotFoundException;
import kasyan.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/product")
public class ProductControllerForGuest {

    private ProductServiceImpl productServiceImpl;

    @GetMapping(value = "/allproductguest")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/allproductguest");
        modelAndView.addObject("product", productServiceImpl.getAllProduct());
        return modelAndView;
    }
//
//
//    @GetMapping(value = "/sortbyidguest")
//    public ModelAndView sortById() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("guestpages/sort/sortbyidguest");
//        modelAndView.addObject("product", productService.sortList(1));
//        return modelAndView;
//    }
//
//    @GetMapping(value = "/sortbyidreverseguest")
//    public ModelAndView sortByIdReverse() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("guestpages/sort/sortbyidreverseguest");
//        modelAndView.addObject("product", productService.sortList(2));
//        return modelAndView;
//    }
//
//    @GetMapping(value = "/sortbycategoryguest")
//    public ModelAndView sortByCategory() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("guestpages/sort/sortbycategoryguest");
//        modelAndView.addObject("product", productService.sortList(3));
//        return modelAndView;
//    }
//
//    @GetMapping(value = "/sortbycategoryreverseguest")
//    public ModelAndView sortByCategoryReverse() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("guestpages/sort/sortbycategoryreverseguest");
//        modelAndView.addObject("product", productService.sortList(4));
//        return modelAndView;
//    }
//
//    @GetMapping(value = "/sortbynameguest")
//    public ModelAndView sortByName() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("guestpages/sort/sortbynameguest");
//        modelAndView.addObject("product", productService.sortList(5));
//        return modelAndView;
//    }
//
//    @GetMapping(value = "/sortbynamereverseguest")
//    public ModelAndView sortByNameReverse() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("guestpages/sort/sortbynamereverseguest");
//        modelAndView.addObject("product", productService.sortList(6));
//        return modelAndView;
//    }
//
//    @GetMapping(value = "/sortbypriceguest")
//    public ModelAndView sortByPrice() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("guestpages/sort/sortbypriceguest");
//        modelAndView.addObject("product", productService.sortList(7));
//        return modelAndView;
//    }
//
//    @GetMapping(value = "/sortbypricereverseguest")
//    public ModelAndView sortByPriceReverse() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("guestpages/sort/sortbypricereverseguest");
//        modelAndView.addObject("product", productService.sortList(8));
//        return modelAndView;
//    }
//
//    @GetMapping(value = "/sortbydiscountguest")
//    public ModelAndView sortByDiscount() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("guestpages/sort/sortbydiscountguest");
//        modelAndView.addObject("product", productService.sortList(9));
//        return modelAndView;
//    }
//
//    @GetMapping(value = "/sortbydiscountreverseguest")
//    public ModelAndView sortByDiscountReverse() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("guestpages/sort/sortbydiscountreverseguest");
//        modelAndView.addObject("product", productService.sortList(10));
//        return modelAndView;
//    }
//
//    @GetMapping(value = "/sortbyactualpriceguest")
//    public ModelAndView sortByActualPrice() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("guestpages/sort/sortbyactualpriceguest");
//        modelAndView.addObject("product", productService.sortList(11));
//        return modelAndView;
//    }
//
//    @GetMapping(value = "/sortbyactualpricereverseguest")
//    public ModelAndView sortByActualPriceReverse() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("guestpages/sort/sortbyactualpricereverseguest");
//        modelAndView.addObject("product", productService.sortList(12));
//        return modelAndView;
//    }
//
//    @GetMapping(value = "/finefruitsguest")
//    public ModelAndView fineFruits() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("guestpages/finecategory/finefruitsguest");
//        modelAndView.addObject("product", ProductService.fineCategoryForRead("FRUITS"));
//        return modelAndView;
//    }
//
//    @GetMapping(value = "/fineberriesguest")
//    public ModelAndView fineBerries() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("guestpages/finecategory/fineberriesguest");
//        modelAndView.addObject("product", ProductService.fineCategoryForRead("BERRIES"));
//        return modelAndView;
//    }
//
//    @GetMapping(value = "/finevegetablesguest")
//    public ModelAndView fineVegetables() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("guestpages/finecategory/finevegetablesguest");
//        modelAndView.addObject("product", ProductService.fineCategoryForRead("VEGETABLES"));
//        return modelAndView;
//    }
//
//    @GetMapping(value = "/finemilkproductguest")
//    public ModelAndView fineMilkProduct() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("guestpages/finecategory/finemilkproductguest");
//        modelAndView.addObject("product", ProductService.fineCategoryForRead("MILK_PRODUCT"));
//        return modelAndView;
//    }
//
//    @GetMapping(value = "/finealcoholguest")
//    public ModelAndView fineAlcohol() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("guestpages/finecategory/finealcoholguest");
//        modelAndView.addObject("product", ProductService.fineCategoryForRead("ALCOHOLIC_BEVERAGES"));
//        return modelAndView;
//    }
//
//    @GetMapping(value = "/finemeatguest")
//    public ModelAndView fineMeat() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("guestpages/finecategory/finemeatguest");
//        modelAndView.addObject("product", ProductService.fineCategoryForRead("MEAT"));
//        return modelAndView;
//    }
//
//    @GetMapping(value = "/exportexcel/alcoholguest")
//    public ModelAndView exportExcelAlcohol() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("guestpages/exportexcel/alcoholguest");
//        modelAndView.addObject("product", ExportToExcel.exportCategoryList("ALCOHOLIC_BEVERAGES"));
//        return modelAndView;
//    }
//    @GetMapping(value = "/exportexcel/berriesguest")
//    public ModelAndView exportExcelBerries() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("guestpages/exportexcel/berriesguest");
//        modelAndView.addObject("product", ExportToExcel.exportCategoryList("BERRIES"));
//        return modelAndView;
//    }
//    @GetMapping(value = "/exportexcel/fruitsguest")
//    public ModelAndView exportExcelFruits() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("guestpages/exportexcel/fruitsguest");
//        modelAndView.addObject("product", ExportToExcel.exportCategoryList("FRUITS"));
//        return modelAndView;
//    }
//    @GetMapping(value = "/exportexcel/meatguest")
//    public ModelAndView exportExcelMeat() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("guestpages/exportexcel/meatguest");
//        modelAndView.addObject("product", ExportToExcel.exportCategoryList("MEAT"));
//        return modelAndView;
//    }
//    @GetMapping(value = "/exportexcel/milkguest")
//    public ModelAndView exportExcelMikl() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("guestpages/exportexcel/milkguest");
//        modelAndView.addObject("product", ExportToExcel.exportCategoryList("MILK_PRODUCT"));
//        return modelAndView;
//    }
//    @GetMapping(value = "/exportexcel/vegetablesguest")
//    public ModelAndView exportExcelVegetables() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("guestpages/exportexcel/vegetablesguest");
//        modelAndView.addObject("product", ExportToExcel.exportCategoryList("VEGETABLES"));
//        return modelAndView;
//    }


    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleStudentNotFoundException(ProductNotFoundException exception) {
        ModelAndView modelAndView = new ModelAndView("usernotfound");
        modelAndView.addObject("exception", exception.getMessage());
        return modelAndView;
    }

    @Autowired
    public  void setProductServiceImpl(ProductServiceImpl productServiceImpl){
        this.productServiceImpl = productServiceImpl;
    }

}
