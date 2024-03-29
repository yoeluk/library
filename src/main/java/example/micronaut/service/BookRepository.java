package example.micronaut.service;


import example.micronaut.domain.entity.BookEntity;
import example.micronaut.domain.model.BookAvailability;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.GenericRepository;
import io.micronaut.data.repository.jpa.JpaSpecificationExecutor;
import io.micronaut.data.repository.jpa.criteria.PredicateSpecification;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Repository("default")
@JdbcRepository(dialect = Dialect.MYSQL)
public interface BookRepository extends GenericRepository<BookEntity, Long>, JpaSpecificationExecutor<BookEntity> {

    @NonNull
    List<BookEntity> findAll(PredicateSpecification<BookEntity> spec);

    @NonNull
    List<BookEntity> findAll();

    @NonNull
    BookEntity save(
            @NonNull @NotBlank String name,
            @NonNull @NotNull BookAvailability availability,
            @Nullable String author,
            @Nullable String isbn);
}
