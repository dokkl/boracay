package com.hoon.boracay.service;


import com.hoon.boracay.model.Story2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@Service
public class StoryService {
    private List<Story2> list = new ArrayList<>();

    @PostConstruct
    public void initData() {
        log.info("initData");
        list.add(new Story2(1, "I'm a boy", "hoon1",2, true));
        list.add(new Story2(2, "have a nice day", "hoon2",0, true));
        list.add(new Story2(3, "this is a mylife", "hoon3",10, false));
        list.add(new Story2(4, "my dream is a actor", "hoon4",5, true));
    }

    public List<Story2> getAll() {
        log.info("getAllStory");
        return list;
    }

    public void update(Story2 story2) {
        Stream<Story2> ss = list.stream()
                .filter(s -> s.getId() == story2.getId());
        ss.findFirst().ifPresent(s -> {
            s.setUpvotes(story2.getUpvotes());
            s.setPlot(story2.getPlot());
            s.setWriter(story2.getWriter());
        });
        log.info("list :{}", list);
    }

    public void delete(long id) {
        list.removeIf(s -> s.getId() == id);
    }

    public Story2 insert(Story2 story2) {
        story2.setId(list.size() +1);
        log.info("story id : {}", story2.getId());
        list.add(story2);
        return story2;
    }
}
