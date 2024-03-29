/*
 * Library
 * This is a library API
 *
 * The version of the OpenAPI document: 1.0.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package example.micronaut.domain.model;


import io.micronaut.core.annotation.Introspected;
import javax.annotation.Nullable;

/**
 * Object containg all the info about a book
 */
@Introspected
public record BookInfo(String name, BookAvailability availability, @Nullable String author, @Nullable String ISBN) {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BookInfo {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    availability: ").append(toIndentedString(availability)).append("\n");
        sb.append("    author: ").append(toIndentedString(author)).append("\n");
        sb.append("    ISBN: ").append(toIndentedString(ISBN)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
