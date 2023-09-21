
public class MainContainerDTO {
    private Integer pk;
    private String eventName;
    private LocalDateTime postingStart;
    private LocalDateTime postingEnd;
    private String containerImg;
    private String containerLink;
    private Boolean isActive;

    public Integer getPk() {
        return this.pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public String getEventName() {
        return this.eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDateTime getPostingStart() {
        return this.postingStart;
    }

    public void setPostingStart(LocalDateTime postingStart) {
        this.postingStart = postingStart;
    }

    public LocalDateTime getPostingEnd() {
        return this.postingEnd;
    }

    public void setPostingEnd(LocalDateTime postingEnd) {
        this.postingEnd = postingEnd;
    }

    public String getContainerImg() {
        return this.containerImg;
    }

    public void setContainerImg(String containerImg) {
        this.containerImg = containerImg;
    }

    public String getContainerLink() {
        return this.containerLink;
    }

    public void setContainerLink(String containerLink) {
        this.containerLink = containerLink;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
