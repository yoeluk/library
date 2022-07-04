package example.micronaut.controller;


import example.micronaut.domain.model.BookAvailability;
import example.micronaut.domain.model.BookInfo;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.uri.UriTemplate;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * API tests for BooksController
 */
@MicronautTest(environments = "test")
public class BooksControllerTest {

    @Inject
    EmbeddedServer server;

    @Inject
    @Client
    HttpClient client;

    @Inject
    BooksController controller;

    /**
     * This test is used to validate the implementation of addBook() method
     *
     * The method should: Add a new book
     *
     * TODO fill in the parameters and test return value.
     */
    @Test
    void addBookMethodTest() {
        // given
        BookInfo bookInfo = new BookInfo(
                "Twenty Thousand Leagues Under the Seas", BookAvailability.fromValue("available"), null, null);

        // when
        controller.addBook(bookInfo);

        // then
        List<BookInfo> result = controller.search("Twenty", null);
        Assertions.assertTrue(result.size() > 0);
    }

    /**
     * This test is used to check that the api available to client through
     * '/add' to the features of addBook() works as desired.
     *
     * TODO fill in the request parameters and test response.
     */
    @Test
    void addBookClientApiTest() throws IOException {
        // given
        var host = server.getHost();
        var port = server.getPort();
        BookInfo body = new BookInfo("example", BookAvailability.fromValue("available"), null, null);
        String uri = UriTemplate.of("http://" + host + ":" + port + "/add").expand(new HashMap<>());
        var request = HttpRequest.POST(uri, body).accept("application/json");

        // when
        var response = client.toBlocking().exchange(request);

        // then
        Assertions.assertEquals(HttpStatus.OK, response.status());
    }

    /**
     * This test is used to validate the implementation of search() method
     *
     * The method should: Search for a book
     *
     * TODO fill in the parameters and test return value.
     */
    @Test
    void searchMethodTest() {
        // given
        String bookName = "Guide";
        String authorName = "example";

        // when
        List<BookInfo> result = controller.search(bookName, authorName);

        // then
        Assertions.assertTrue(true);
    }

    /**
     * This test is used to check that the api available to client through
     * '/search' to the features of search() works as desired.
     *
     * TODO fill in the request parameters and test response.
     */
    @Test
    void searchClientApiTest() throws IOException {
        // given
      var host = server.getHost();
      var port = server.getPort();
        String uri = UriTemplate.of("http://" + host + ":" + port + "/search").expand(new HashMap<>());
        MutableHttpRequest<?> request = HttpRequest.GET(uri).accept("application/json");
        request.getParameters()
                .add("book-name", "Wonderland") // The query parameter format should be
                .add("author-name", "Caroll"); // The query parameter format should be

        // when
        HttpResponse<?> response = client.toBlocking().exchange(request, Argument.of(List.class, BookInfo.class));

        // then
        Assertions.assertEquals(HttpStatus.OK, response.status());
    }
}
