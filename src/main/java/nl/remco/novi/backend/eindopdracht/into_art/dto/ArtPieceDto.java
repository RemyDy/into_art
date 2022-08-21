package nl.remco.novi.backend.eindopdracht.into_art.dto;

public class ArtPieceDto {

    private Long id;
    private String title;
    private String description;
    private double price;
    private String technique;
    private String dimensions;
    private boolean hasFrame;
    private boolean hasPassepartout;
    private String dimensionsInclFrame;
    private boolean isForSale;
    private boolean isSold;
    private String fileName;

    //region Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getDimensions() {
        return dimensions;
    }

    public String getTechnique() {
        return technique;
    }

    public boolean isHasFrame() {
        return hasFrame;
    }

    public boolean isHasPassepartout() {
        return hasPassepartout;
    }

    public String getDimensionsInclFrame() {
        return dimensionsInclFrame;
    }

    public boolean isForSale(boolean forSale) {
        return isForSale;
    }

    public boolean isSold() {
        return isSold;
    }

    public String getFileName() {
        return fileName;
    }

    //endregion

    //region Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTechnique(String technique) {
        this.technique = technique;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public void setHasFrame(boolean hasFrame) {
        this.hasFrame = hasFrame;
    }

    public void setHasPassepartout(boolean hasPassepartout) {
        this.hasPassepartout = hasPassepartout;
    }

    public void setDimensionsInclFrame(String dimensionsInclFrame) {
        this.dimensionsInclFrame = dimensionsInclFrame;
    }

    public void setForSale(boolean forSale) {
        isForSale = forSale;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    //endregion


}
