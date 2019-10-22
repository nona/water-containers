package io.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import io.exception.InvalidInputException;
import io.test.provider.InvalidArgumentsProvider;
import io.test.provider.ValidArgumentsProvider;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.WARN)
public class WaterContainterServiceUnitTest {

    WaterContainerService waterContainerService = new WaterContainerService();

    @ParameterizedTest
    @ArgumentsSource(ValidArgumentsProvider.class)
    public void shouldCalculateMaxVolume(int[] points, long expectedResult) throws InvalidInputException {

        // when
        long maxVolume = waterContainerService.findMaxVolume(points);

        // then
        assertEquals(expectedResult, maxVolume);

    }

    @ParameterizedTest
    @ArgumentsSource(InvalidArgumentsProvider.class)
    public void shouldThrowExceptionWhenInputIsInvalid(int[] points) throws InvalidInputException {

        // when
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> waterContainerService.findMaxVolume(points));

        // then
        assertEquals("Please, provide a valid list of integers!", exception.getMessage());
    }

}
