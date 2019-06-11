package org.takehome.exercise.resource;

import com.codahale.metrics.health.HealthCheck;

public class HealthCheckResource extends HealthCheck {

    protected Result check() {
        return Result.healthy();
    }
}
