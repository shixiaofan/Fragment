package comr.example.administrator.fragmentdemo.bean;

/**
 * Created by Administrator on 2017/11/24 0024.
 */

public class Goods {
    private int id;
    private String name;
    private int price;
    private int imageId;
    private String content;

    public Goods(int id, String name, int price, int imageId, String content) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageId = imageId;
        this.content = content;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", imageId=" + imageId +
                ", content='" + content + '\'' +
                '}';
    }
}
