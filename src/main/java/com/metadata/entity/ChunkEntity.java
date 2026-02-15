package com.metadata.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "chunks")
public class ChunkEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private UUID objectId;

    private Integer chunkIndex;

    private String storageNodeId;

}
