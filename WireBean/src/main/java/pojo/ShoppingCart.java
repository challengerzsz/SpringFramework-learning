package pojo;

public class ShoppingCart {
    private String username;
    private int nowContain;

    public ShoppingCart(String username, int nowContain) {
        this.username = username;
        this.nowContain = nowContain;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNowContain() {
        return nowContain;
    }

    public void setNowContain(int nowContain) {
        this.nowContain = nowContain;
    }

    public void print() {
        System.out.println(this.username + this.nowContain);
    }
}
