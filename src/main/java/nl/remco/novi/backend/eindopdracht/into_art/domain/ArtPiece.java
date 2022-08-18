package nl.remco.novi.backend.eindopdracht.into_art.domain;

import javax.persistence.*;

@Entity
public
class ArtPiece { // To Do: check why this gives an error

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    private final String title;
    private final String description;
    private final double price;
    private final String technique;
    private final String dimensions;
    private final boolean hasFrame;
    private final boolean hasPassepartout;
    private final String dimensionsInclFrame;
    private final boolean isForSale;
    private final boolean isSold;
    private final String fileName;

    private ArtPiece(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.price = builder.price;
        this.technique = builder.technique;
        this.dimensions = builder.dimensions;
        this.hasFrame = builder.hasFrame;
        this.hasPassepartout = builder.hasPassepartout;
        this.dimensionsInclFrame = builder.dimensionsInclFrame;
        this.isForSale = builder.isForSale;
        this.isSold = builder.isSold;
        this.fileName = builder.fileName;
    }

    //region Getters (no setters to provide immutability)
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

    public String getDimensions() {
        return dimensions;
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

    public boolean isForSale() {
        return isForSale;
    }

    public boolean isSold() {
        return isSold;
    }

    public String getFileName() {
        return fileName;
    }

    //endregion

    public static class Builder {

        //region Mandatory Fields
        private final Long id;
        private final String title;
        private final String dimensions;
        private final boolean isForSale;

        public Builder(Long id, String title, String dimensions, boolean isForSale) {
            this.id = id;
            this.title = title;
            this.dimensions = dimensions;
            this.isForSale = isForSale;
        }
        //endregion

        //region Optional fields
        double price;
        String description;
        String technique;
        boolean hasFrame;
        boolean hasPassepartout;
        String dimensionsInclFrame;
        boolean isSold;
        String fileName;

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder technique(String technique) {
            this.technique = technique;
            return this;
        }

        public Builder hasFrame(boolean hasFrame) {
            this.hasFrame = hasFrame;
            return this;
        }

        public Builder hasPassepartout(boolean hasPassepartout) {
            this.hasPassepartout = hasPassepartout;
            return this;
        }

        public Builder dimensionsInclFrame(String dimensionsInclFrame) {
            this.dimensionsInclFrame = dimensionsInclFrame;
            return this;
        }

        public Builder isSold(boolean isSold) {
            this.isSold = isSold;
            return this;
        }

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }
        //endregion

        public ArtPiece build() {
            var artPiece = new ArtPiece(this);
            validatePiece(artPiece);
            return artPiece;
        }

        private void validatePiece(ArtPiece piece) {
            // placeholder for now
            System.out.printf("%s validate", piece.title);
        }
    }
}

