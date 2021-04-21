package kasyan.service;

import kasyan.bean.Product;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExportToExcel {

    private ExportToExcel() {
    }
    private ProductService productService;

    public static List<Product>exportAllList(List<Product> listProduct){
        exportList(listProduct);
        return listProduct;
    }

    public List<Product> exportCategoryList(String category){
        return exportList(productService.fineCategoryForRead(category));
    }


    public static List <Product> exportList(List<Product> listProduct) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("List products");
        sheet.setDefaultColumnWidth(25);

        Row row = sheet.createRow(0);

        Cell idTop = row.createCell(0);
        idTop.setCellValue("id");

        Cell categoryTop = row.createCell(1);
        categoryTop.setCellValue("Category");

        Cell nameTop = row.createCell(2);
        nameTop.setCellValue("Name");

        Cell priceTop = row.createCell(3);
        priceTop.setCellValue("Price, BYN");

        Cell discountTop = row.createCell(4);
        discountTop.setCellValue("Discount, %");

        Cell actualPriceTop = row.createCell(5);
        actualPriceTop.setCellValue("Actual price, BYN");

        int i = 1;
        for(Product product : listProduct){
            Row rowProduct = sheet.createRow(i);
            Cell id = rowProduct.createCell(0);
            id.setCellValue(product.getId());

            Cell category = rowProduct.createCell(1);
            category.setCellValue(product.getCategory());

            Cell name = rowProduct.createCell(2);
            name.setCellValue(product.getName());

            Cell price = rowProduct.createCell(3);
            price.setCellValue(product.getPrice());

            Cell discount = rowProduct.createCell(4);
            discount.setCellValue(product.getDiscount());

            Cell actualPrice = rowProduct.createCell(5);
            actualPrice.setCellValue(product.getActualPrice());

            i++;
        }

        String filename = "productlist.xls";

        try (FileOutputStream out = new FileOutputStream(filename)) {
            workbook.write(out);
            File file = new File(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listProduct;
    }

    @Autowired
    public  void setProductService(ProductService productService){
        this.productService = productService;
    }
}
