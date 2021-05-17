import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Market implements IMarketable{
    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Sale> sales = new ArrayList<>();
    public static void main(String[] args) throws ParseException {

        Market market = new Market();

        market.addNewProduct("Water", 0.3, Category.DRINK,1);
        market.addNewProduct("WaterZz", 0.4, Category.DRINK,2);
        market.addNewProduct( "WaterZZ", 0.3, Category.DRINK,2);
        market.addNewProduct( "WaterZZzz", 0.3, Category.DRINK,2);
        market.addNewProduct( "Bread", 0.5, Category.FOOD,10);
        market.addNewProduct( "Cheese", 0.7, Category.FOOD,15);
        market.addNewProduct( "Soap", 0.4, Category.SELFCARE,100);
        //market.getAllProducts();
        //market.getProductsByCategory();
        //market.searchProductByPriceInterval(0.4,0.5);
        //market.searchProductByName("tEr");
        //market.addNewSale();
        //market.getSaleById(21);
        //market.returnProductFromSale();
        //market.getSaleById(21);
        Market.menu();

    }

    static void menu() throws ParseException {
        Market market = new Market();
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose the operation: 1 for Products, 2 for Sales, 3 to Exit \n");
        int operation = scan.nextInt();
        while(operation < 1 || operation > 3){
            System.out.println("Not such an operation, enter valid number: \n");
            operation = scan.nextInt();
        }

        if(operation == 1) {
            System.out.println("Choose one of the product operations: \n 1: Add new product \n 2: Edit product \n 3: Remove product \n 4: Show all products \n 5: Show products by category \n 6: Show products by price interval \n 7: Search product by name \n");
            int productOperation = scan.nextInt();
            while (productOperation < 1 || productOperation > 7) {
                System.out.println("Not such an operation, enter valid number: \n");
                productOperation = scan.nextInt();
            }
            switch (productOperation){
                case 1:
                    market.addNewProduct();
                    break;
                case 2:
                    market.editProduct();
                    break;
                case 3:
                    market.deleteProduct();
                    break;
                case 4:
                    market.getAllProducts();
                    break;
                case 5:
                    market.getProductsByCategory();
                    break;
                case 6:
                    market.searchProductByPriceInterval();
                    break;
                case 7:
                    market.searchProductByName();
                    break;
            }
        }

        if(operation == 2){
            System.out.println("Choose one of the sale operations: \n 1: Add new sale \n 2: Return product from sale \n 3: Remove the sale \n 4: Show all the sales \n 5: Show sales by date interval \n 6: Show sales by price interval \n 7: Show sales by date \n 8: Show sale by id \n");
            int saleOperation = scan.nextInt();
            while (saleOperation < 1 || saleOperation > 8) {
                System.out.println("Not such an operation, enter valid number: \n");
                saleOperation = scan.nextInt();
            }
            switch (saleOperation){
                case 1:
                    market.addNewSale();
                    break;
                case 2:
                    market.returnProductFromSale();
                    break;
                case 3:
                    market.removeSale();
                    break;
                case 4:
                    market.getAllSales();
                    break;
                case 5:
                    market.getSalesByDateInterval();
                    break;
                case 6:
                    market.getSalesByPriceInterval();
                    break;
                case 7:
                    market.getSalesByDate();
                    break;
                case 8:
                    market.getSaleById();
                    break;
            }
        }

        if(operation==3){
            System.exit(0);
        }
    }

    Category categorySelecter(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Select category of product: \n 1 for Food \n 2 for Drink \n 3 for Self care \n 4 for Cigarette \n");
        int categoryInt = scan.nextInt();
        while (categoryInt < 1 || categoryInt > 4) {
            System.out.println("Not such an operation, enter valid number: \n");
            categoryInt = scan.nextInt();
        }
        Category category = null;
        if(categoryInt ==1) return Category.FOOD;
        if(categoryInt ==2) return Category.DRINK;
        if(categoryInt ==3) return Category.SELFCARE;
        if(categoryInt ==4) return Category.CIGARETTE;
        return null;
    }



    /**
     * Eger eyni mehsuldan varsa sadece hemin mehsulun sayi artirilir.
     */
    @Override
    public String addNewProduct() throws ParseException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name of product: \n");
        String name = scan.nextLine();
        System.out.println("Enter price of product: \n");
        double price = scan.nextDouble();
        while(price <= 0){
            System.out.println("Enter valid price: ");
            price  = scan.nextLong();
        }
        System.out.println("Enter quantity of product: \n");
        long count  = scan.nextLong();
        while(count <= 0){
            System.out.println("Enter valid quantity: ");
            count  = scan.nextLong();
        }
        for(Product x: Market.products){
            if(x.getName().toLowerCase().equals(name.toLowerCase())) {
                x.setCount(x.getCount() + count);
                return null;
            }
        }
        Product product = new Product(name, price, categorySelecter(), count);
        products.add(product);
        menu();
        return Long.toString(product.getCode()) ;
    }

    /**
     * Console'dan kenarda melumatlar daxil etmek overload versiya da var.
     */

    public String addNewProduct(String name, double price, Category category, long count) {


        for(Product x: products){
            if(x.getName().toLowerCase().equals(name.toLowerCase())) {
                x.setCount(x.getCount() + count);
                return null;
            }
        }
        Product product = new Product(name, price, category, count);
        products.add(product);
        return Long.toString(product.getCode()) ;
    }

    @Override
    public void getAllProducts() throws ParseException {
        for(Product x: products){
            System.out.println(x);
        }
        menu();
    }

    /**
     * editProduct methodu product'in deyishilecek uzvunu sechir ve ona uyghun method'u chaghirir.
     */

    @Override
    public void editProduct() throws ParseException {
        System.out.println("Select the operation: \n 1 to Edit name \n 2 to Edit category \n 3 to Edit price \n 4 to Edit quantity \n");
        Scanner scan = new Scanner(System.in);
        int editOperation = scan.nextInt();
        while (editOperation < 1 || editOperation > 4) {
            System.out.println("Not such an operation, select valid operation: \n");
            editOperation = scan.nextInt();
        }
        if(editOperation == 1){
            System.out.println("Enter the code of product: \n");
            long code = scan.nextLong();
            System.out.println("Enter new name of product: \n");
            String name = scan.nextLine();
            editProduct(code, name);
            menu();
        };

        if(editOperation == 2){
            System.out.println("Enter the code of product: \n");
            long code = scan.nextLong();
            System.out.println("Enter new category of product: \n");

            String name = scan.nextLine();
            editProduct(code,categorySelecter());
            menu();
        };

        if(editOperation == 3){
            System.out.println("Enter the code of product: \n");
            long code = scan.nextLong();
            System.out.println("Enter new price of product: \n");
            double price = scan.nextDouble();
            while(price <= 0){
                System.out.println("Enter valid price: ");
                price  = scan.nextLong();
            }
            editProduct(code,price);
            menu();
        };

        if(editOperation == 4){
            System.out.println("Enter the code of product: \n");
            long code = scan.nextLong();
            System.out.println("Enter new quantity of product: \n");
            long count = scan.nextLong();
            while(count <= 0){
                System.out.println("Enter valid quantity: ");
                count  = scan.nextLong();
            }
            editProduct(code, count);
            menu();
        };
    }

    public void editProduct(long code, double price) {
        for(Product x: products){
            if(x.getCode()==code){
                x.setPrice(price);
            }
        }
    }

    public void editProduct(long code, String name) {
        for(Product x: products){
            if(x.getCode()==code){
                x.setName(name);
            }
        }
    }

    public void editProduct(long code, Category category) {
        for(Product x: products){
            if(x.getCode()==code){
                x.setCategory(category);
            }
        }
    }

    public void editProduct(long code, long count) {
        for(Product x: products){
            if(x.getCode()==code){
                x.setCount(count);
            }
        }

    }

    /***
     * Bu zaman listden product silinmir, isRemoved true'ya chevrilir
     */
    @Override
    public void deleteProduct() throws ParseException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the code of product to delete: \n");
        long code = scan.nextLong();
        for(Product x: products){
            if(x.getCode()==code){
                x.setRemoved(true);
            }
        }
        menu();
    }

    @Override
    public void getProductsByCategory() throws ParseException {
        for(Category x: Category.values()){
            System.out.println(x);
        }
        Category category = categorySelecter();

        for(Product x: products){
            if(x.getCategory()==category){
                System.out.println(x);
            }
        }
        menu();
    }

    @Override
    public void searchProductByPriceInterval() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the price interval (first minimum, second maximum)");
        double minPrice = scan.nextDouble();
        while(minPrice <= 0){
            System.out.println("Enter valid price: ");
            minPrice  = scan.nextLong();
        }
        double maxPrice = scan.nextDouble();
        while(maxPrice <= 0){
            System.out.println("Enter valid price: ");
            maxPrice = scan.nextLong();
        }
        for(Product x: products){
            if((x.getPrice()>=minPrice && x.getPrice()<=maxPrice))
                System.out.println(x);
        }
    }

    @Override
    public void searchProductByName() throws ParseException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of product to search:");
        String text = scan.nextLine();
        for(Product x: products){
            if(x.getName().toLowerCase().contains(text.toLowerCase()))
                System.out.println(x);
        }
        menu();
    }

    @Override
    public void addNewSale() throws ParseException {
        long id;
        int count;
        Sale sale = new Sale();
        while(true){
            Scanner scan = new Scanner(System.in);
            SaleItem saleItem = new SaleItem();
            System.out.println("Enter the code of product: (0 to exit)\n");

            id = scan.nextLong();
            if(id==0) break;
            //Product product1 = new Product();
            while(id>Product.codeGenerator || id<10001) {
                System.out.println("There is no such a product in the list, enter correct code: \n");
                id = scan.nextLong();
            }
            System.out.println("Enter count of product: \n");
            count = scan.nextInt();
            while(count <= 0){
                System.out.println("Enter valid count: ");
                count  = scan.nextInt();
            }
            for(Product x: products){
                if(x.getCode()==id){
                    saleItem.setSaleItemProduct(x);
                    while(count > x.getCount()){
                        System.out.println("Not available such amount of product in stock enter less \n");
                        count = scan.nextInt();
                    }
                }
            }
            saleItem.setSaleItemCount(count);
            Product product = new Product();
            for(Product x: products){
                if(id==x.getCode() && x.getCount()==0) {
                    System.out.println("\nNo left of this product in stock\n");
                }
                if(id==x.getCode() && x.getCount()!=0){
                    product = x;
                    x.setCount(x.getCount()-count);
                }

            }
            saleItem.setSaleItemProduct(product);
            sale.setSalePrice((sale.getSalePrice() + (count * product.getPrice())));
            sale.getSaleItems().add(saleItem);
        }
        sales.add(sale);
        menu();
    }

    @Override
    public void getSaleById() throws ParseException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the id of sale: \n");
        long saleId = scan.nextLong();
        while(saleId <= 0){
            System.out.println("Enter valid price: ");
            saleId = scan.nextLong();
        }
        for(Sale x: sales){
            if(x.getSaleId()==saleId) {
                System.out.println(x);
            }
        }
        menu();
    }

    @Override
    public void returnProductFromSale() throws ParseException {
        DecimalFormat df = new DecimalFormat("###.##");
        Scanner scan =  new Scanner(System.in);
        System.out.println("Id of the sale: \n");
        long id = scan.nextLong();
        System.out.println("Product code and count: \n");
        long productCode = scan.nextLong();
        int productCount = scan.nextInt();
        for(Sale x: sales){
            if(x.getSaleId() == id){
                for(SaleItem j: x.getSaleItems()){
                    if(j.getSaleItemProduct().getCode() == productCode) {

                        if (j.getSaleItemCount() < productCount)
                            System.out.println("No such quantity of product in this sale");
                        if (j.getSaleItemCount() >= productCount) {
                            j.setSaleItemCount((j.getSaleItemCount()) - productCount);
                            x.setSalePrice(Double.parseDouble(df.format(x.getSalePrice()-(j.getSaleItemProduct().getPrice()*productCount))));
                        }
                    }
                    //else continue;
                }
            }
        }
        menu();
    }

    /***
     * Bu zaman listden sale silinmir, isRemoved true'ya chevrilir
     */
    @Override
    public void removeSale() throws ParseException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the id of sale to be removed: \n");
        long saleId = scan.nextLong();
        for(Sale x: sales){
            if(saleId == x.getSaleId()) {
                for(SaleItem y: x.getSaleItems()){
                    for(Product z: products){
                        if(z.getCode() == y.getSaleItemProduct().getCode()) {
                            z.setCount(z.getCount() + (y.getSaleItemCount()));
                        }
                    }
                }
                x.setRemoved(true);
            }
        }
        menu();
    }

    @Override
    public void getAllSales() throws ParseException {
        for(Sale x: sales){
            //System.out.println("Sale Id: "+x.getSaleId()+"Price: "+x.getSalePrice()+"Product count: "+x.getSaleItems().get(products.indexOf(x)).getSaleItemCount()+"Date: "+x.getSaleDate());
            System.out.println(x);
        }
        menu();
    }

    @Override
    public void getSalesByDateInterval() throws ParseException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the date interval (first minimum, second maximum) \n");
        String minDateStr = scan.nextLine();
        String maxDateStr = scan.nextLine();
        Date min =new SimpleDateFormat("dd/MM/yyyy").parse(minDateStr);
        Date max =new SimpleDateFormat("dd/MM/yyyy").parse(maxDateStr);

        for(Sale x: sales){
            if(x.getSaleDate().after(min) && x.getSaleDate().before(max)){
                System.out.println("Sale Id: "+x.getSaleId()+"Price: "+x.getSalePrice()+"Product count: "+x.getSaleItems().get(products.indexOf(x)).getSaleItemCount()+"Date: "+x.getSaleDate());
            }
        }
        menu();
    }

    @Override
    public void getSalesByPriceInterval() throws ParseException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter minimum price \n");
        double minPrice = scan.nextDouble();
        while(minPrice < 0){
            System.out.println("Enter valid price: ");
            minPrice  = scan.nextLong();
        }
        System.out.println("Enter maximum price \n");
        double maxPrice = scan.nextDouble();
        while(maxPrice < 0){
            System.out.println("Enter valid price: ");
            maxPrice  = scan.nextLong();
        }
        for(Sale x: sales){
            if(x.getSalePrice() >= minPrice && x.getSalePrice() <= maxPrice){
                System.out.println(x);            }
        }
        menu();
    }

    @Override
    public void getSalesByDate() throws ParseException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the sale date: \n");
        String saleDate = scan.nextLine();
        Date date =new SimpleDateFormat("dd/MM/yyyy").parse(saleDate);

        for(Sale x: sales){
            if(x.getSaleDate()==date){
                System.out.println("Sale Id: "+x.getSaleId()+"Price: "+x.getSalePrice()+"Product count: "+x.getSaleItems().get(products.indexOf(x)).getSaleItemCount()+"Date: "+x.getSaleDate());
            }
        }
        menu();
    }
}