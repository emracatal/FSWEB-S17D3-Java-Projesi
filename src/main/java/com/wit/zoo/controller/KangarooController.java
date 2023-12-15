package com.wit.zoo.controller;

import com.wit.zoo.entity.Kangaroo;
import com.wit.zoo.entity.KangarooResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kangaroos")
public class KangarooController {
    private Map<Integer, Kangaroo> kangaroos;

    @PostConstruct
    public void init() {
        kangaroos = new HashMap<>();
        System.out.println("kangaroos says hi");
    }

    @PostMapping("/")
    public KangarooResponse post(@RequestBody Kangaroo kangaroo) {
        kangaroos.put(kangaroo.getId(), kangaroo);
        return new KangarooResponse(kangaroo, "Success", 200);
    }

    @GetMapping("/")
    public List<Kangaroo> get() {
        return kangaroos.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Kangaroo getById(@PathVariable int id) {
        return kangaroos.get(id);
    }

    @PutMapping("/{id}")
    public KangarooResponse update(@PathVariable int id, @RequestBody Kangaroo kangaroo) {
        kangaroos.put(id,
                new Kangaroo(id, kangaroo.getName(), kangaroo.getGender(), kangaroo.getWeight(), kangaroo.getHeight(), kangaroo.isAggressive()));
        return new KangarooResponse(kangaroo, "Success", 200);
    }

    @DeleteMapping("/{id}")
    public Kangaroo delete(@PathVariable int id) {
        return kangaroos.remove(id);
    }
}

