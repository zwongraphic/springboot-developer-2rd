package me.leejiwon.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.leejiwon.springbootdeveloper.domain.Article;
import me.leejiwon.springbootdeveloper.dto.AddArticleRequest;
import me.leejiwon.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드(blogRepository)의 생성자
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }
}
