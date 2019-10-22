package io.service;

import java.util.Arrays;

import io.exception.InvalidInputException;
import io.model.Point;
import io.model.WaterContainer;
import io.service.interfaces.IWaterContainerService;

public class WaterContainerService implements IWaterContainerService {

    @Override
    public long findMaxVolume(int[] points) throws InvalidInputException {

        validatePointsList(points);

        long maxVolume = 0;
        int pointsCount = points.length;

        for (int i = 0; i < pointsCount - 1; i++) {
            for (int j = i + 1; j < pointsCount; j++) {
                WaterContainer waterContainer = new WaterContainer(new Point(i + 1, points[i]), new Point(j + 1, points[j]));
                maxVolume = Math.max(maxVolume, waterContainer.getVolume());
            }
        }

        return maxVolume;

    }

    private void validatePointsList(int[] points) throws InvalidInputException {
        if (points == null || points.length < 2 || Arrays.stream(points).boxed().anyMatch(y -> y < 0)) {
            throw new InvalidInputException();
        }
    }

}
