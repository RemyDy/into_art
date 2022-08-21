package nl.remco.novi.backend.eindopdracht.into_art.service;

import nl.remco.novi.backend.eindopdracht.into_art.domain.entities.ArtPiece;
import nl.remco.novi.backend.eindopdracht.into_art.dto.ArtPieceDto;
import nl.remco.novi.backend.eindopdracht.into_art.dto.CreateArtPieceDto;
import nl.remco.novi.backend.eindopdracht.into_art.exception.RecordExistsException;
import nl.remco.novi.backend.eindopdracht.into_art.repository.ArtPieceRepository;
import org.springframework.stereotype.Service;

@Service
public record ArtPieceService(ArtPieceRepository artPieceRepository) {

    public ArtPieceDto uploadArtPiece(CreateArtPieceDto dto) {

        if (artPieceRepository.findArtPieceByTitle(dto.getTitle()).isPresent()) {
            throw new RecordExistsException("art piece with this title already exists");
        }

        final var artPieceRecord = artPieceRepository.save(relayToArtPiece(dto));

        return relayToDto(artPieceRecord);
    }

    private ArtPieceDto relayToDto(ArtPiece artPieceRecord) {

        var dto = new ArtPieceDto();
        dto.setTitle(artPieceRecord.getTitle());
        dto.setDimensions(artPieceRecord.getDimensions());
        dto.setForSale(artPieceRecord.isForSale());
        dto.setDescription(artPieceRecord.getDescription());
        dto.setPrice(artPieceRecord.getPrice());
        dto.setTechnique(artPieceRecord.getTechnique());
        dto.setHasFrame(artPieceRecord.isHasFrame());
        dto.setHasPassepartout(artPieceRecord.isHasPassepartout());
        dto.setDimensionsInclFrame(artPieceRecord.getDimensionsInclFrame());
        dto.setSold(artPieceRecord.isSold());
        dto.setFileName(artPieceRecord.getFileName());
        dto.setTitle(artPieceRecord.getTitle());

        return dto;
    }

    private ArtPiece relayToArtPiece(CreateArtPieceDto dto) {

        var artPiece = new ArtPiece.ArtPieceBuilder(
                dto.getId(),
                dto.getTitle(),
                dto.getDimensions(),
                dto.isForSale());

        artPiece.description(dto.getDescription());
        artPiece.price(dto.getPrice());
        artPiece.technique(dto.getTechnique());
        artPiece.hasFrame(dto.hasFrame());
        artPiece.hasPassepartout(dto.isHasPassepartout());
        artPiece.dimensionsInclFrame(dto.getDimensionsInclFrame());
        artPiece.isSold(dto.isSold());
        artPiece.fileName(dto.getFileName());

        return artPiece.build();
    }
}
