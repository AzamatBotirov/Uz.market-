package Uz.market.UzMarket.repository;

import Uz.market.UzMarket.domain.FileStorage;
import Uz.market.UzMarket.domain.enurmation.FileStorageStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileStorageRepository extends JpaRepository<FileStorage, Long> {

    FileStorage findByHashId(String hashId);

    List<FileStorage> findAllByFileStorageStatus(FileStorageStatus status);
}
