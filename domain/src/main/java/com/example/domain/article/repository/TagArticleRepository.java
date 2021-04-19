package com.example.domain.article.repository;

import com.example.domain.article.model.TagArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagArticleRepository extends JpaRepository<TagArticle, String> {
}
