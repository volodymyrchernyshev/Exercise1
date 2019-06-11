package org.takehome.exercise.service;

import org.takehome.exercise.dao.AverageSdInMemoryDao;

public class CalculationService {

    final AverageSdInMemoryDao dao;

    public CalculationService(AverageSdInMemoryDao dao) {
        this.dao = dao;
    }

    public void update(Double value) {
        dao.update(value);
    }

    public String getAverage() {
        return String.valueOf(dao.getAverage());
    }

    public String getSd() {
        return String.valueOf(dao.getSd());
    }
}
