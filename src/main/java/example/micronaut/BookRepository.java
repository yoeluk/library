package example.micronaut;


import example.micronaut.model.BookAvailability;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.GenericRepository;
import io.micronaut.data.repository.jpa.JpaSpecificationExecutor;
import io.micronaut.data.repository.jpa.criteria.PredicateSpecification;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
            @NonNull @NotBlank String author,
            @NonNull @NotBlank String isbn);
}
