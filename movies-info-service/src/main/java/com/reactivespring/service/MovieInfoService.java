package com.reactivespring.service;

import com.reactivespring.domain.MovieInfo;
import com.reactivespring.repository.MovieInfoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieInfoService {

    private MovieInfoRepository movieInfoRepository;

    public MovieInfoService(MovieInfoRepository movieInfoRepository) {
        this.movieInfoRepository = movieInfoRepository;
    }

    public Mono<MovieInfo> addMovieInfo(MovieInfo movieinfo) {

        return  movieInfoRepository.save(movieinfo);
    }

    public Flux<MovieInfo> getAllMovieInfo() {
        return movieInfoRepository.findAll();
    }

    public Mono<MovieInfo> getAllMovieInfoById(String id) {
        return movieInfoRepository.findById(id);
    }

    public Mono<MovieInfo> updateMovieInfo(MovieInfo updatedmovieinfo, String id) {

        return movieInfoRepository.findById(id).
                flatMap(movieInfo -> {
                    movieInfo.setCast(updatedmovieinfo.getCast());
                    movieInfo.setName(updatedmovieinfo.getName());
                    movieInfo.setYear(updatedmovieinfo.getYear());
                    movieInfo.setRelease_date(updatedmovieinfo.getRelease_date());
                    return movieInfoRepository.save(movieInfo);
                });
    }

    public Mono<Void> deleteMovieInfo(String id) {
        return movieInfoRepository.deleteById(id);
    }

    public Flux<MovieInfo> getAllMovieInfoByYear(Integer year) {
        return movieInfoRepository.findByYear(year);
    }
}
