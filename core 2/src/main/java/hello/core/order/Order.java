package hello.core.order;

public class Order {

    private Long memberId;
    private String iterName;
    private int itemPrice;
    private int dicountPrice;

    public Order(Long memberId, String iterName, int itemPrice, int dicountPrice) {
        this.memberId = memberId;
        this.iterName = iterName;
        this.itemPrice = itemPrice;
        this.dicountPrice = dicountPrice;
    }

    public int calculatePrice(){
        return itemPrice-dicountPrice;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getIterName() {
        return iterName;
    }

    public void setIterName(String iterName) {
        this.iterName = iterName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDicountPrice() {
        return dicountPrice;
    }

    public void setDicountPrice(int dicountPrice) {
        this.dicountPrice = dicountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", iterName='" + iterName + '\'' +
                ", itemPrice=" + itemPrice +
                ", dicountPrice=" + dicountPrice +
                '}';
    }
}
