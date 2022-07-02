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

package example.micronaut.model;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.micronaut.core.annotation.*;
import javax.validation.constraints.*;

/**
 * Gets or Sets BookAvailability
 */
@Introspected
public enum BookAvailability {
    AVAILABLE("available"),
    NOT_AVAILABLE("not available"),
    RESERVED("reserved");

    private String value;

    BookAvailability(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static BookAvailability fromValue(String value) {
        for (BookAvailability b : BookAvailability.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
