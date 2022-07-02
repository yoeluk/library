package example.micronaut.service;


import example.micronaut.domain.entity.BookEntity;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.repository.jpa.criteria.*;

public class BookSpecifications {
    public static PredicateSpecification<BookEntity> nameLike(@NonNull String name) {
        return (root, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }

    public static PredicateSpecification<BookEntity> authorLike(@NonNull String author) {
        return (root, criteriaBuilder) -> criteriaBuilder.like(root.get("author"), "%" + author + "%");
    }
}
