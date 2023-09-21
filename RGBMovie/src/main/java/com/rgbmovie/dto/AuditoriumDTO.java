
public class AuditoriumDTO {
    private Integer pk;
    private String name;
    private Integer seatsNo;
    private Integer theater;

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

    public Integer getSeatsNo() {
        return this.seatsNo;
    }

    public void setSeatsNo(Integer seatsNo) {
        this.seatsNo = seatsNo;
    }

    public Integer getTheater() {
        return this.theater;
    }

    public void setTheater(Integer theater) {
        this.theater = theater;
    }
}
