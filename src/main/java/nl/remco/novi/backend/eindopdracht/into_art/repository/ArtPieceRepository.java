package nl.remco.novi.backend.eindopdracht.into_art.repository;

import nl.remco.novi.backend.eindopdracht.into_art.domain.entities.ArtPiece;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtPieceRepository extends JpaRepository<ArtPiece, Long> {

    Optional<ArtPiece> findArtPieceByTitle(String title);

}
