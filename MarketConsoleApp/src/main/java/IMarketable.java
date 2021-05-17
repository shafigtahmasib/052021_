import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

public interface IMarketable {
    String addNewProduct() throws ParseException;
    void getAllProducts() throws ParseException;
    void editProduct() throws ParseException;
    void deleteProduct() throws ParseException;
    void getProductsByCategory() throws ParseException;
    void searchProductByPriceInterval();
    void searchProductByName() throws ParseException;
    void addNewSale() throws ParseException;
    void getSaleById() throws ParseException;
    void returnProductFromSale() throws ParseException;
    void removeSale() throws ParseException;
    void getAllSales() throws ParseException;
    void getSalesByDate() throws ParseException;
    void getSalesByDateInterval() throws ParseException;
    void getSalesByPriceInterval() throws ParseException;
}
