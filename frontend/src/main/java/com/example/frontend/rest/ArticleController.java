package com.example.frontend.rest;

import com.example.domain.auth.model.Authorize;
import com.example.domain.auth.service.AuthorizeService;
import com.example.frontend.service.ArticleApplicationService;
import com.example.frontend.usecase.CreateArticleCase;
import com.example.frontend.usecase.GetArticleDetailCase;
import com.example.frontend.usecase.GetArticleTagsCase;
import com.example.frontend.usecase.GetArticlesCase;
import com.example.frontend.usecase.TagArticleCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleApplicationService applicationService;
    @Autowired
    private AuthorizeService authorizeService;

    @PostMapping
    @ResponseStatus(CREATED)
    public CreateArticleCase.Response createArticle(@RequestBody CreateArticleCase.Request request) {
        Authorize authorize = authorizeService.current();
        return applicationService.create(request, authorize);
    }

    @GetMapping("/{id}")
    public GetArticleDetailCase.Response getArticleDetail(@PathVariable("id") String id) {
        return applicationService.getDetail(id);
    }

    @GetMapping()
    public Page<GetArticlesCase.Response> getArticles(@PageableDefault(sort = "updatedAt") Pageable pageable) {
        return applicationService.getByPage(pageable);
    }

    @PostMapping("/{id}/tags")
    @ResponseStatus(CREATED)
    public TagArticleCase.Response AddArticleTag(@PathVariable("id") String id,
                                                 @RequestBody TagArticleCase.Request request) {
        Authorize authorize = authorizeService.current();
        return applicationService.tagArticle(id, request, authorize);
    }

    // TODO 合并到文章详情
    @GetMapping("/{id}/tags")
    public List<GetArticleTagsCase.Response> getTags(@PathVariable("id") String id) {
        return applicationService.getTags(id);
    }
}
