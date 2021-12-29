package com.tmax.bjk.springboot.web;

import com.tmax.bjk.springboot.config.auth.LoginUser;
import com.tmax.bjk.springboot.config.auth.dto.SessionUser;
import com.tmax.bjk.springboot.service.posts.PostsService;
import com.tmax.bjk.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    // @LoginUser SessionUser user: 어느 컨트롤러라든지 @LoginUser만 사용하면 세션 정보를 가져올 수 있게 됨
    public String index(Model model, @LoginUser SessionUser user) { // Model: 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있음
        model.addAttribute("posts",  postsService.findAllDesc());
        if(user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
