
public class PaymentDTO {
    private Integer pk;
    private String name;
    private Integer cardNumber;
    private String dateExpried;
    private String cvv;
    private Integer userId;

    public Integer getPk() {
        return this.pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getDateExpried() {
        return this.dateExpried;
    }

    public void setDateExpried(String dateExpried) {
        this.dateExpried = dateExpried;
    }

    public String getCvv() {
        return this.cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
