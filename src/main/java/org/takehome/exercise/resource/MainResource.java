package org.takehome.exercise.resource;

import org.takehome.exercise.service.CalculationService;
import org.takehome.exercise.service.EncryptionService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/")
@Produces(MediaType.TEXT_PLAIN)
@Consumes
public class MainResource {

    final CalculationService calculationService;
    final EncryptionService encryptionService;

    public MainResource(CalculationService calculationService, EncryptionService encryptionService) {
        this.calculationService = calculationService;
        this.encryptionService = encryptionService;
    }

    @POST
    @Path("/PushAndRecalculate")
    public String pushAndRecalculate(Double value) {
        calculationService.update(value);
        String average = calculationService.getAverage();
        String sd = calculationService.getSd();
        return String.format("{%s, %s}", average, sd);
    }


    @POST
    @Path("/PushRecalculateAndEncrypt")
    public String pushRecalculateAndEncrypt(Double value) throws Exception{
        calculationService.update(value);
        String average = encryptionService.encrypt(calculationService.getAverage());
        String sd = encryptionService.encrypt(calculationService.getSd());
        return String.format("{%s, %s}", average, sd);

    }

    @POST
    @Path("/Decrypt")
    public String decrypt(String value) throws Exception{
        return String.format("{%s}", encryptionService.decrypt(value));
    }


}
