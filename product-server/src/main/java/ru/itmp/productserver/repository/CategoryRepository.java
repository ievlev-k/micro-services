package ru.itmp.productserver.repository;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
import ru.itmp.productserver.model.Category;


@Repository
public interface CategoryRepository extends ReactiveCrudRepository<Category, Long> {

}
