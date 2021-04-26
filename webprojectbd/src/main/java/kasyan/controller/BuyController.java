package kasyan.controller;

import kasyan.exceptions.ProductNotFoundException;
import kasyan.service.ExportToExcel;
import kasyan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@RequestMapping(value = "/product")
public class BuyController {

    private ProductService productService;
    private ExportToExcel exportToExcel;

    // получение страницы с формой для добавления продукта
    @GetMapping(value = "/buystarted")
    public ModelAndView buyStarted() throws SQLException {
        productService.cleanBuyDB();
        productService.startTransaction();
        productService.autocommit();
        return new ModelAndView("adminpages/buystarted");

    }
    // получение страницы с формой для добавления продукта
    @GetMapping(value = "/buyproduct")
    public ModelAndView buyProductGet() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/buyproduct");
        modelAndView.addObject("product", productService.findAll());
        return modelAndView;
    }

    // отправка данных для добавления продуктов в БД и перенаправления на страницу со всем списком
    @PostMapping(value = "/buyproduct")
    public ModelAndView buyProductPost(@RequestParam(value = "id") int id,
                                       @RequestParam(value = "quantity") double quantity) throws SQLException, ProductNotFoundException {
        productService.bayProduct(id, quantity);
        return new ModelAndView("redirect:/product/buyproduct");
    }

    // получение страницы с формой для добавления продукта
    @GetMapping(value = "/endbuyproduct")
    public ModelAndView endBuyProductGet() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/endbuyproduct");
        modelAndView.addObject("product", productService.findAllBuyProduct());
        return modelAndView;
    }

    // получение страницы с формой для добавления продукта
    @GetMapping(value = "/checkend")
    public ModelAndView checkend() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/checkend");
        exportToExcel.check(productService.findAllBuyProduct());
        productService.endTransaction();
        modelAndView.addObject("product", productService.findAllBuyProduct());
        return modelAndView;
    }

    // получение страницы с сообщением, что продукт удален из основной БД
    @GetMapping(value = "/deleteproductbuy")
    public ModelAndView deleteproduct(@RequestParam(value = "id") int id) throws  SQLException {
        productService.deletebuy(id);
        return new ModelAndView("redirect:/product/endbuyproduct");
    }

    // получение страницы с сообщением, что продукт удален из основной БД
    @GetMapping(value = "/failbuyproduct")
    public ModelAndView failbuyproduct() throws  SQLException {
        productService.rollBack();
        return new ModelAndView("adminpages/failbuyproduct");
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setExportToExcel(ExportToExcel exportToExcel) {
        this.exportToExcel = exportToExcel;
    }
}
