# 🚀 Mini S3 – Distributed Object Storage System

> A production-inspired distributed object storage system
> built to understand the fundamentals behind AWS S3.

---

## 📌 Overview

Mini S3 is a scalable metadata management service that mimics
core architectural principles of Amazon S3.

It handles:
- Object metadata storage
- Chunk mapping
- UUID-based object tracking
- Persistent storage via PostgreSQL
- REST-based object APIs

This project is built in phased milestones to simulate real-world
distributed system evolution.

---

## 🏗️ Architecture

### Phase 1 – Metadata Service

Client → Spring Boot Metadata Service → PostgreSQL

Responsibilities:
- Store object metadata
- Track file size
- Maintain creation timestamp
- Manage chunk mappings

---

## 🧱 Database Schema

### Object Table

| Field      | Type      |
|------------|----------|
| id         | UUID     |
| fileName   | String   |
| size       | Long     |
| createdAt  | Timestamp|

### Chunk Table

| Field         | Type    |
|---------------|--------|
| id            | UUID   |
| objectId      | UUID   |
| chunkIndex    | Integer|
| storageNodeId | String |

---

## 🛠 Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Hibernate
- Docker
- Maven

---

## 🌐 APIs

### Create Object

POST `/objects`

```json
{
  "fileName": "video.mp4",
  "size": 102400
}

                 ┌──────────────┐
                 │    Client    │
                 └──────┬───────┘
                        │ HTTP
                        ▼
               ┌─────────────────┐
               │  Metadata API   │
               │  (Spring Boot)  │
               └──────┬──────────┘
                      │ JPA
                      ▼
               ┌─────────────────┐
               │   PostgreSQL    │
               │  (Object +      │
               │   Chunk Tables) │
               └─────────────────┘
