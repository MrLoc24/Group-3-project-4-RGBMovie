
public class SeatDTO {
    private Integer pk;
    private Integer row;
    private Integer number;
    private Integer auditorium;
    private String seatName;

    public Integer getPk() {
        return this.pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public Integer getRow() {
        return this.row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getAuditorium() {
        return this.auditorium;
    }

    public void setAuditorium(Integer auditorium) {
        this.auditorium = auditorium;
    }

    public String getSeatName() {
        return this.seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }
}
