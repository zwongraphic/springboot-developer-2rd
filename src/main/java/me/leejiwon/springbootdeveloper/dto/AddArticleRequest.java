package me.leejiwon.springbootdeveloper.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.leejiwon.springbootdeveloper.domain.Article;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddArticleRequest {
    @NotNull
    @Size(min = 1, max = 10)
    private String title;

    @NotNull
    private String content;

    // JSON -> 객체 : 스프링부트가 알아서 해줌
    // toEntity() 함수는 DTO 객체를 Entity 객체로 변환해줌
    public Article toEntity(String author) {
        return Article.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
