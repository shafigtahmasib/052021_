public class SaleItem {
    private long saleItemId;
    private static long idGenerator = 0;
    private Product saleItemProduct;
    private int saleItemCount;

    public SaleItem(){
        this.saleItemId = ++idGenerator;
    }
    public SaleItem(Product saleItemProduct, int saleItemCount) {
        this.saleItemId = ++idGenerator;
        this.saleItemProduct = saleItemProduct;
        this.saleItemCount = saleItemCount;
    }

    @Override
    public String toString() {
        return "SaleItem{" +
                "saleItemId=" + saleItemId +
                ", saleItemProduct=" + saleItemProduct +
                ", saleItemCount=" + saleItemCount +
                '}';
    }

    public long getSaleItemId() {
        return saleItemId;
    }

    public void setSaleItemId(long saleItemId) {
        this.saleItemId = saleItemId;
    }

    public Product getSaleItemProduct() {
        return saleItemProduct;
    }

    public void setSaleItemProduct(Product saleItemProduct) {
        this.saleItemProduct = saleItemProduct;
    }

    public int getSaleItemCount() {
        return saleItemCount;
    }

    public void setSaleItemCount(int saleItemCount) {
        this.saleItemCount = saleItemCount;
    }
}