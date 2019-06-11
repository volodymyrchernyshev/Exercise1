package org.takehome.exercise;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.takehome.exercise.dao.AverageSdInMemoryDao;
import org.takehome.exercise.resource.HealthCheckResource;
import org.takehome.exercise.resource.MainResource;
import org.takehome.exercise.service.CalculationService;
import org.takehome.exercise.service.EncryptionService;

public class ExerciseApplication extends Application<ExerciseConfiguration> {


    public static void main(String[] args) throws Exception {
        new ExerciseApplication().run(args);
    }


    public void run(ExerciseConfiguration exerciseConfiguration, Environment environment) throws Exception {
        final AverageSdInMemoryDao dao = new AverageSdInMemoryDao();

        final CalculationService calculationService = new CalculationService(dao);
        final EncryptionService encryptionService = new EncryptionService(exerciseConfiguration.getPassword());

        final MainResource resource = new MainResource(calculationService, encryptionService);
        final HealthCheckResource healthCheck = new HealthCheckResource();
        environment.healthChecks().register("healthCheck", healthCheck);
        environment.jersey().register(resource);

    }


}
