package ebore.model;


public class LineNovel {

    private Novel novel;
    private int quantity;

    public LineNovel() {
    }

    public Novel getNovel() {
        return novel;
    }

    public void setNovel(Novel novel) {
        this.novel = novel;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return novel.getNovelPrice() * quantity;
    }

    @Override
    public String toString() {
        return "LineItem [novel=" + novel + ", quantity=" + quantity + "]";
    }

}
