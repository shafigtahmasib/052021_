import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sale {
    private long saleId;
    private double salePrice;
    private List<SaleItem> saleItems;
    private Date saleDate;
    private static long codeGenerator = 20;
    private boolean isRemoved = false;

    Sale(){
        this.saleId = ++codeGenerator;
        this.saleDate = new Date();
        saleItems =  new ArrayList<>();
        salePrice = 0;
    }

    public long getSaleId() {
        return saleId;
    }

    public void setSaleId(long saleId) {
        this.saleId = saleId;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public List<SaleItem> getSaleItems() {
        return saleItems;
    }

    public void setSaleItems(List<SaleItem> saleItems) {
        this.saleItems = saleItems;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public boolean isRemoved() {
        return isRemoved;
    }

    public void setRemoved(boolean removed) {
        isRemoved = removed;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleId=" + saleId +
                ", isRemoved= " +isRemoved +
                ", salePrice=" + salePrice +
                ", saleItems=" + saleItems +
                ", saleDate=" + saleDate +
                '}';
    }
}