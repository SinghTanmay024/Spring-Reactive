package com.reactivespring.controller;


import com.reactivespring.domain.MovieInfo;
import com.reactivespring.service.MovieInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
public class MoviesInfoController {

    private MovieInfoService movieInfoService;

    public MoviesInfoController(MovieInfoService movieInfoService) {
        this.movieInfoService = movieInfoService;
    }

    @GetMapping("/moviesinfo")
    @ResponseStatus(HttpStatus.OK)
    public Flux<MovieInfo> getAllMovieInfo(@RequestParam(value = "Year", required = false) Integer year){

        if(year != null){
            return movieInfoService.getAllMovieInfoByYear(year);
        }

        return movieInfoService.getAllMovieInfo();
    }

    @GetMapping("/moviesinfo/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  Mono<ResponseEntity<MovieInfo>> getMovieInfoById(@PathVariable String id){
        return movieInfoService.getAllMovieInfoById(id)
                .map(ResponseEntity.ok()::body)
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PostMapping("/moviesinfo")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ResponseEntity<MovieInfo>> addMovieInfo(@RequestBody @Valid MovieInfo movieinfo){

        return movieInfoService.addMovieInfo(movieinfo)
                .map(ResponseEntity.ok()::body)
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/moviesinfo/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<MovieInfo>> updateMovieInfo(@RequestBody @Valid MovieInfo updatedmovieinfo, @PathVariable String id){
        return movieInfoService.updateMovieInfo(updatedmovieinfo,id)
                .map(ResponseEntity.ok()::body)
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/moviesinfo/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteMovieInfo(@PathVariable String id){
        return movieInfoService.deleteMovieInfo(id);
    }




}
