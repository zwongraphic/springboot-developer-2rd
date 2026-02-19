package me.leejiwon.springbootdeveloper.service;

import me.leejiwon.springbootdeveloper.dto.AddArticleRequest;
import me.leejiwon.springbootdeveloper.dto.UpdateArticleRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.leejiwon.springbootdeveloper.domain.Article;
import me.leejiwon.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void deleteById(long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
