package com.metadata.repo;

import com.metadata.entity.ChunkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ChunkRepository extends JpaRepository<ChunkEntity, UUID> {

    List<ChunkEntity> findByObjectId(UUID objectId);
}
