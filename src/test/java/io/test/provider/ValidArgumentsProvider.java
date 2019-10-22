package io.test.provider;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class ValidArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(new int[] { 1, 5, 4, 3 }, 6),
                Arguments.of(new int[] { 1, Integer.MAX_VALUE }, 1),
                Arguments.of(new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE }, Integer.MAX_VALUE * 2l),
                Arguments.of(new int[] { 100, 200 }, 100),
                Arguments.of(new int[] { 0, 0, 0, 0 }, 0),
                Arguments.of(new int[] { 1000, 1000 }, 1000),
                Arguments.of(new int[] { 1000, 1000, 1000, 1000, 1000, 1000, 1000 }, 6000),
                Arguments.of(new int[] { 1, 2, 4, 3 }, 4));
    }
}
