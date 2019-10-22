package io.test.provider;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class InvalidArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(new int[] {}),
                Arguments.of(new int[] { 1, 2, 3, -5000 }),
                Arguments.of(new int[] { 1 }));
    }
}
