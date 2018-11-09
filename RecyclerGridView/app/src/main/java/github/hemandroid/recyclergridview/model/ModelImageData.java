package github.hemandroid.recyclergridview.model;

public class ModelImageData {

    private int img_data;
    private String str_count;

    public ModelImageData(int img_data, String str_count) {
        this.img_data = img_data;
        this.str_count = str_count;
    }

    public int getImg_data() {
        return img_data;
    }

    public void setImg_data(int img_data) {
        this.img_data = img_data;
    }

    public String getStr_count() {
        return str_count;
    }

    public void setStr_count(String str_count) {
        this.str_count = str_count;
    }
}
