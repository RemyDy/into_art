package nl.remco.novi.backend.eindopdracht.into_art.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.awt.*;

@Entity
public class ArtPiece {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private double price;
    private String technique;
    private Dimension dimensions;
    private boolean hasFrame;
    private boolean hasPassepartout;
    private Dimension dimensionsInclFrame;
    private boolean isForSale;
    private boolean isSold;

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

    public String getTechnique() {
        return technique;
    }

    public Dimension getDimensions() {
        return dimensions;
    }

    public boolean isHasFrame() {
        return hasFrame;
    }

    public boolean isHasPassepartout() {
        return hasPassepartout;
    }

    public Dimension getDimensionsInclFrame() {
        return dimensionsInclFrame;
    }

    public boolean isForSale() {
        return isForSale;
    }

    public boolean isSold() {
        return isSold;
    }
    //endregion

    //region Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String name) {
        this.title = name;
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

    public void setDimensions(Dimension dimensions) {
        this.dimensions = dimensions;
    }

    public void setHasFrame(boolean frame) {
        this.hasFrame = frame;
    }

    public void setHasPassepartout(boolean passepartout) {
        this.hasPassepartout = passepartout;
    }

    public void setDimensionsInclFrame(Dimension dimensionsInclFrame) {
        this.dimensionsInclFrame = dimensionsInclFrame;
    }

    public void setIsForSale(boolean forSale) {
        this.isForSale = forSale;
    }

    public void setIsSold(boolean sold) {
        this.isSold = sold;
    }
    //endregion

}
