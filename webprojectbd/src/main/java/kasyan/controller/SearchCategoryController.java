package kasyan.controller;

import kasyan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.SQLException;

@Controller
@RequestMapping(value = "/product")
public class SearchCategoryController {

    private ProductService productService;

    // получение списка категории FRUITS
    @GetMapping(value = "/finefruits")
    public ModelAndView fineFruits() throws IOException, SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/finecategory/finefruits");
        modelAndView.addObject("product", productService.fineCategoryForRead("FRUITS"));
        return modelAndView;
    }

    // получение списка категории BERRIES
    @GetMapping(value = "/fineberries")
    public ModelAndView fineBerries() throws IOException, SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/finecategory/fineberries");
        modelAndView.addObject("product", productService.fineCategoryForRead("BERRIES"));
        return modelAndView;
    }

    // получение списка категории VEGETABLES
    @GetMapping(value = "/finevegetables")
    public ModelAndView fineVegetables() throws IOException, SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/finecategory/finevegetables");
        modelAndView.addObject("product", productService.fineCategoryForRead("VEGETABLES"));
        return modelAndView;
    }

    // получение списка категории MILK_PRODUCT
    @GetMapping(value = "/finemilkproduct")
    public ModelAndView fineMilkProduct() throws IOException, SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/finecategory/finemilkproduct");
        modelAndView.addObject("product", productService.fineCategoryForRead("MILK_PRODUCT"));
        return modelAndView;
    }

    // получение списка категории ALCOHOLIC_BEVERAGES
    @GetMapping(value = "/finealcohol")
    public ModelAndView fineAlcohol() throws IOException, SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/finecategory/finealcohol");
        modelAndView.addObject("product", productService.fineCategoryForRead("ALCOHOLIC_BEVERAGES"));
        return modelAndView;
    }

    // получение списка категории MEAT
    @GetMapping(value = "/finemeat")
    public ModelAndView fineMeat() throws IOException, SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/finecategory/finemeat");
        modelAndView.addObject("product", productService.fineCategoryForRead("MEAT"));
        return modelAndView;
    }

    // получение списка категории FRUITS для Гостя
    @GetMapping(value = "/finefruitsguest")
    public ModelAndView fineFruitsGuest() throws IOException, SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/finecategory/finefruitsguest");
        modelAndView.addObject("product", productService.fineCategoryForRead("FRUITS"));
        return modelAndView;
    }

    // получение списка категории BERRIES для Гостя
    @GetMapping(value = "/fineberriesguest")
    public ModelAndView fineBerriesGuest() throws IOException, SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/finecategory/fineberriesguest");
        modelAndView.addObject("product", productService.fineCategoryForRead("BERRIES"));
        return modelAndView;
    }

    // получение списка категории VEGETABLES для Гостя
    @GetMapping(value = "/finevegetablesguest")
    public ModelAndView fineVegetablesGuest() throws IOException, SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/finecategory/finevegetablesguest");
        modelAndView.addObject("product", productService.fineCategoryForRead("VEGETABLES"));
        return modelAndView;
    }

    // получение списка категории MILK_PRODUCT для Гостя
    @GetMapping(value = "/finemilkproductguest")
    public ModelAndView fineMilkProductGuest() throws IOException, SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/finecategory/finemilkproductguest");
        modelAndView.addObject("product", productService.fineCategoryForRead("MILK_PRODUCT"));
        return modelAndView;
    }

    // получение списка категории ALCOHOLIC_BEVERAGES для Гостя
    @GetMapping(value = "/finealcoholguest")
    public ModelAndView fineAlcoholGuest() throws IOException, SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/finecategory/finealcoholguest");
        modelAndView.addObject("product", productService.fineCategoryForRead("ALCOHOLIC_BEVERAGES"));
        return modelAndView;
    }

    // получение списка категории MEAT для Гостя
    @GetMapping(value = "/finemeatguest")
    public ModelAndView fineMeatGuest() throws IOException, SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/finecategory/finemeatguest");
        modelAndView.addObject("product", productService.fineCategoryForRead("MEAT"));
        return modelAndView;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}