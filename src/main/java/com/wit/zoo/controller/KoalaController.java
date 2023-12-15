package com.wit.zoo.controller;

import com.wit.zoo.entity.Koala;
import com.wit.zoo.entity.KoalaResponse;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
public class KoalaController {
    private Map<Integer, Koala> koalas;

    @PostConstruct
    public void init(){
        koalas=new HashMap<>();
        System.out.println("koalas says hi");
    }

    @PostMapping("/")
    public KoalaResponse post(@RequestBody Koala koala){
        koalas.put(koala.getId(),koala);
        return new KoalaResponse(koala,"Susccess",200);
    }

    @GetMapping("/")
    public List<Koala> get(){
        return koalas.values().stream().toList();
    }

    @GetMapping("/{id}")
    public KoalaResponse getById(@PathVariable int id){
        return new KoalaResponse(koalas.get(id),"success",200);
    }

    @PutMapping("/{id}")
    public KoalaResponse getById(@PathVariable int id,@RequestBody Koala koala){
        koalas.put(id,new Koala(koala.getId(),koala.getName(),koala.getGender(),koala.getWeight(), koala.getSleepHour()));
        return new KoalaResponse(koala,"success",200);
    }

    @DeleteMapping("/{id}")
    public KoalaResponse delete(@PathVariable int id){
        return new KoalaResponse(koalas.remove(id),"success",200);
    }

}
