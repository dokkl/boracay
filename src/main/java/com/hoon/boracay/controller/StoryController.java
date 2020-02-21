package com.hoon.boracay.controller;

import com.hoon.boracay.model.Story2;
import com.hoon.boracay.service.StoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/api/stories")
@RestController
public class StoryController {
    @Autowired
    private StoryService storyService;

    @GetMapping
    public List<Story2> getAll() {
        return storyService.getAll();
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable long id,
                            @RequestBody Story2 story2) {
        storyService.update(story2);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        storyService.delete(id);
    }

    @PostMapping
    public Story2 insert(@RequestBody Story2 story2) {
        return storyService.insert(story2);
    }
}
