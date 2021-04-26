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
import java.sql.SQLException;
import java.util.List;

@Service
public class ExportToExcel {

    private ExportToExcel() {
    }

    private ProductService productService;

    // сервис для экспорта всего списка продуктов в excel
    public static List<Product> exportAllList(List<Product> listProduct) {
        exportList(listProduct);
        return listProduct;
    }

    // сервис на экспорт списка продуктов одной категории в excel
    public List<Product> exportCategoryList(String category) throws SQLException {
        return exportList(productService.fineCategoryForRead(category));
    }

    // формирование таблицы excel и добавление данных из List
    public static List<Product> exportList(List<Product> listProduct) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("List products"); //название вкладки
        sheet.setDefaultColumnWidth(25); // высота строк

        // даем название колонок таблицы
        Row row = sheet.createRow(0); // первая строка

        Cell idTop = row.createCell(0);
        idTop.setCellValue("id"); // название первого столбца

        Cell categoryTop = row.createCell(1);
        categoryTop.setCellValue("Category");// название второго столбца

        Cell nameTop = row.createCell(2);
        nameTop.setCellValue("Name");// название третьего столбца

        Cell priceTop = row.createCell(3);
        priceTop.setCellValue("Price, BYN");// название четвертого столбца

        Cell discountTop = row.createCell(4);
        discountTop.setCellValue("Discount, %");// название пятого столбца

        Cell totalVolumeTop = row.createCell(5);
        totalVolumeTop.setCellValue("Count, kg()");// название пятого столбца

        Cell actualPriceTop = row.createCell(6);
        actualPriceTop.setCellValue("Total, BYN");// название шестого столбца

        // добавляем данные из List
        int i = 1;
        for (Product product : listProduct) {
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

            Cell totalVolume = rowProduct.createCell(5);
            totalVolume.setCellValue(product.getTotalVolume());

            Cell actualPrice = rowProduct.createCell(6);
            actualPrice.setCellValue(product.getActualPrice());

            i++;
        }
        // название и путь для нашего файла (по умолчанию в корне проекта)
        String filename = "src/main/webapp/WEB-INF/downloads/xls/productlist.xls";

        try (FileOutputStream out = new FileOutputStream(filename)) {
            workbook.write(out);
            File file = new File(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listProduct;
    }

    // формирование таблицы excel и добавление данных из List
    public List<Product> check(List<Product> listProduct) throws SQLException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("check"); //название вкладки
        sheet.setDefaultColumnWidth(25); // высота строк

        // даем название колонок таблицы
        Row row = sheet.createRow(0); // первая строка

        Cell idTop = row.createCell(0);
        idTop.setCellValue("id"); // название первого столбца

        Cell nameTop = row.createCell(1);
        nameTop.setCellValue("Name");

        Cell actualPriceTop = row.createCell(2);
        actualPriceTop.setCellValue("Price, BYN");// название шестого столбца

        Cell quantityTop = row.createCell(3);
        quantityTop.setCellValue("Count");// название пятого столбца

        Cell totalPriceTop = row.createCell(4);
        totalPriceTop.setCellValue("Total, BYN");// название шестого столбца

        // добавляем данные из List
        int i = 1;
        for (Product product : listProduct) {
            Row rowProduct = sheet.createRow(i);
            Cell id = rowProduct.createCell(0);
            id.setCellValue(product.getId());

            Cell name = rowProduct.createCell(1);
            name.setCellValue(product.getName());

            Cell actualPrice = rowProduct.createCell(2);
            actualPrice.setCellValue(product.getActualPrice());

            Cell quantity = rowProduct.createCell(3);
            quantity.setCellValue(product.getQuantity());

            Cell totalPrice = rowProduct.createCell(4);
            totalPrice.setCellValue(product.getActualPrice());

            i++;
        }
        Row rowProduct = sheet.createRow(i);

        Cell quantity = rowProduct.createCell(3);
        quantity.setCellValue("TOTAL:");

        Cell totalPrice = rowProduct.createCell(4);
        totalPrice.setCellValue(productService.totalPrise());

        // название и путь для нашего файла (по умолчанию в корне проекта)
        String filename = "src/main/webapp/WEB-INF/downloads/xls/check.xls";

        try (FileOutputStream out = new FileOutputStream(filename)) {
            workbook.write(out);
            File file = new File(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listProduct;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}