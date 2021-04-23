package kasyan.controller;

import kasyan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Контроллер для сортировки списка продуктов

@Controller
@RequestMapping(value = "/product")
public class ProductSortController {

    private ProductService productService;

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

    // сортировка списка по ID (от меньшего к большему) для Гостя
    @GetMapping(value = "/sortbyidguest")
    public ModelAndView sortByIdGuest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbyidguest");
        modelAndView.addObject("product", productService.sortList(1));
        return modelAndView;
    }

    // сортировка списка по ID (от большего к меньшему) для Гостя
    @GetMapping(value = "/sortbyidreverseguest")
    public ModelAndView sortByIdReverseGuest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbyidreverseguest");
        modelAndView.addObject("product", productService.sortList(2));
        return modelAndView;
    }

    // сортировка списка по категории (от A к Z) для Гостя
    @GetMapping(value = "/sortbycategoryguest")
    public ModelAndView sortByCategoryGuest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbycategoryguest");
        modelAndView.addObject("product", productService.sortList(3));
        return modelAndView;
    }

    // сортировка списка по категории (от Z к A) для Гостя
    @GetMapping(value = "/sortbycategoryreverseguest")
    public ModelAndView sortByCategoryReverseGuest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbycategoryreverseguest");
        modelAndView.addObject("product", productService.sortList(4));
        return modelAndView;
    }

    // сортировка списка по названию (A -> Z) для Гостя
    @GetMapping(value = "/sortbynameguest")
    public ModelAndView sortByNameGuest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbynameguest");
        modelAndView.addObject("product", productService.sortList(5));
        return modelAndView;
    }

    // сортировка списка по названию (Z -> A) для Гостя
    @GetMapping(value = "/sortbynamereverseguest")
    public ModelAndView sortByNameReverseGuest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbynamereverseguest");
        modelAndView.addObject("product", productService.sortList(6));
        return modelAndView;
    }

    // сортировка списка по цене (от меньшего к большему) для Гостя
    @GetMapping(value = "/sortbypriceguest")
    public ModelAndView sortByPriceGuest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbypriceguest");
        modelAndView.addObject("product", productService.sortList(7));
        return modelAndView;
    }

    // сортировка списка по цене (от большего к меньшему) для Гостя
    @GetMapping(value = "/sortbypricereverseguest")
    public ModelAndView sortByPriceReverseGuest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbypricereverseguest");
        modelAndView.addObject("product", productService.sortList(8));
        return modelAndView;
    }

    // сортировка списка по скидке (от меньшего к большему) для Гостя
    @GetMapping(value = "/sortbydiscountguest")
    public ModelAndView sortByDiscountGuest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbydiscountguest");
        modelAndView.addObject("product", productService.sortList(9));
        return modelAndView;
    }

    // сортировка списка по скидке (от большего к меньшему) для Гостя
    @GetMapping(value = "/sortbydiscountreverseguest")
    public ModelAndView sortByDiscountReverseGuest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbydiscountreverseguest");
        modelAndView.addObject("product", productService.sortList(10));
        return modelAndView;
    }

    // сортировка списка по конечной цене (от меньшего к большему) для Гостя
    @GetMapping(value = "/sortbyactualpriceguest")
    public ModelAndView sortByActualPriceGuest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbyactualpriceguest");
        modelAndView.addObject("product", productService.sortList(11));
        return modelAndView;
    }

    // сортировка списка по конечной цене (от большего к меньшему) для Гостя
    @GetMapping(value = "/sortbyactualpricereverseguest")
    public ModelAndView sortByActualPriceReverseGuest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbyactualpricereverseguest");
        modelAndView.addObject("product", productService.sortList(12));
        return modelAndView;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}