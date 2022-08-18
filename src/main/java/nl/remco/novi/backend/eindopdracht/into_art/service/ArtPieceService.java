package nl.remco.novi.backend.eindopdracht.into_art.service;

import nl.remco.novi.backend.eindopdracht.into_art.domain.ArtPiece;
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

        return dto;
    }

    private ArtPiece relayToArtPiece(CreateArtPieceDto dto) {

        var artPiece = new ArtPiece.Builder(
                dto.getId(),
                dto.getTitle(),
                dto.getDimensions(),
                dto.isForSale());

        return artPiece.build();
    }

}
