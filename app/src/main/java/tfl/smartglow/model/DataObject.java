package tfl.smartglow.model;

public class DataObject {
    private int imageId;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageHeader() {
        return imageHeader;
    }

    public void setImageHeader(String imageHeader) {
        this.imageHeader = imageHeader;
    }

    private String imageHeader;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public DataObject(int imageId, String imageHeader, String description) {
        this.imageId = imageId;
        this.imageHeader = imageHeader;
        this.description = description;
    }


}