package org.takehome.exercise.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;



public class AverageSdInMemoryDaoTest {


    @Test
    public void test() throws Exception{


        AverageSdInMemoryDao dao = new AverageSdInMemoryDao();

        dao.update(4d);
        Assert.assertEquals(4d, dao.getAverage(), 0.01d);
        Assert.assertEquals(0d, dao.getSd(), 0.01d);

        dao.update(7d);
        Assert.assertEquals(5.5d, dao.getAverage(), 0.01d);
        Assert.assertEquals(1.5d, dao.getSd(), 0.01d);

        dao.update(6d);
        Assert.assertEquals(5.667d, dao.getAverage(), 0.01d);
        Assert.assertEquals(1.247d, dao.getSd(), 0.01d);

        dao.update(9d);
        Assert.assertEquals(6.5d, dao.getAverage(), 0.01d);
        Assert.assertEquals(1.802d, dao.getSd(), 0.01d);

        dao.update(1d);
        Assert.assertEquals(5.4d, dao.getAverage(), 0.01d);
        Assert.assertEquals(2.728d, dao.getSd(), 0.01d);

    }
}
