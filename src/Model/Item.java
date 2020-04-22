package Model;

public class Item {
    protected int id;
    protected String name;
    protected String price;
    protected String quatity;
    protected String color;
    protected String mota;
    protected String category;
    public Item(){
    }
    public Item(int id,String name,String price,String quatity,String color,String mota,String category){
        super();
        this.id =id;
        this.name = name;
        this.price = price;
        this.quatity = quatity;
        this.color = color;
        this.mota = mota;
        this.category = category;
    }
    public Item (String name,String price,String quatity,String color,String mota,String category){
        super();
        this.name = name;
        this.price = price;
        this.mota = mota;
        this.quatity = quatity;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuatity() {
        return quatity;
    }

    public void setQuatity(String quatity) {
        this.quatity = quatity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
