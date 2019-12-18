package com.mrbjoern.cloudfitness.api.converter;

import com.mrbjoern.cloudfitness.api.domain.ActivityType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ActivityTypeConverter implements AttributeConverter<ActivityType, String> {

    @Override
    public String convertToDatabaseColumn(final ActivityType activityType) {
        if (activityType == null) {
            return null;
        }
        return activityType.getName();
    }

    @Override
    public ActivityType convertToEntityAttribute(final String name) {
        if (name == null) {
            return null;
        }

        return Stream.of(ActivityType.values())
                .filter(value -> value.getName().equals(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
