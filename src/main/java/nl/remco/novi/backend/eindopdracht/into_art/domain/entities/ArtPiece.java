package nl.remco.novi.backend.eindopdracht.into_art.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ArtPiece {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    protected ArtPiece() {
        // this no arg constructor only exists to make the class work with JPA annotations
        // initialization of the fields is done by the
    }

    ArtPiece(ArtPieceBuilder builder) {
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

    public static class ArtPieceBuilder {

        //region Mandatory fields and constructor
        private final Long id;
        private final String title;
        private final String dimensions;
        private final boolean isForSale;

        public ArtPieceBuilder(Long id, String title, String dimensions, boolean isForSale) {
            this.id = id;
            this.title = title;
            this.dimensions = dimensions;
            this.isForSale = isForSale;
        }
        //endregion

        //region Optional fields and methods
        double price;
        String description;
        String technique;
        boolean hasFrame;
        boolean hasPassepartout;
        String dimensionsInclFrame;
        boolean isSold;
        String fileName;

        public ArtPieceBuilder price(final double price) {
            this.price = price;
            return this;
        }

        public ArtPieceBuilder description(final String description) {
            this.description = description;
            return this;
        }

        public ArtPieceBuilder technique(final String technique) {
            this.technique = technique;
            return this;
        }

        public ArtPieceBuilder hasFrame(final boolean hasFrame) {
            this.hasFrame = hasFrame;
            return this;
        }

        public ArtPieceBuilder hasPassepartout(final boolean hasPassepartout) {
            this.hasPassepartout = hasPassepartout;
            return this;
        }

        public ArtPieceBuilder dimensionsInclFrame(final String dimensionsInclFrame) {
            this.dimensionsInclFrame = dimensionsInclFrame;
            return this;
        }

        public ArtPieceBuilder isSold(final boolean isSold) {
            this.isSold = isSold;
            return this;
        }

        public ArtPieceBuilder fileName(final String fileName) {
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
            System.out.printf("%s validate", piece);
        }
    }
}

