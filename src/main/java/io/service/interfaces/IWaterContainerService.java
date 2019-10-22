package io.service.interfaces;

import io.exception.InvalidInputException;

public interface IWaterContainerService {
    long findMaxVolume(int[] points) throws InvalidInputException;
}
