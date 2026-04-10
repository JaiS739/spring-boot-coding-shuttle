package com.module4.production_ready_feature.production_ready_feature.repositories;

import com.module4.production_ready_feature.production_ready_feature.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
