package com.bytehonor.sdk.server.spring.scheduler;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bytehonor.sdk.lang.spring.constant.TimeConstants;
import com.bytehonor.sdk.lang.spring.thread.Sleeping;
import com.bytehonor.sdk.server.spring.scheduler.plan.PrintTimePlan;

public class SpringSchedulerTest {

    private static final Logger LOG = LoggerFactory.getLogger(SpringSchedulerTest.class);

    @Test
    public void testStart() {
        SpringScheduler.start();

        SpringScheduler.add(new PrintTimePlan());

        Sleeping.sleep(TimeConstants.MINUTE * 1);

        String name = PrintTimePlan.class.getSimpleName();

        LOG.info("pause");
        SpringScheduler.pause(name);

        Sleeping.sleep(TimeConstants.MINUTE * 1);

        LOG.info("run");
        SpringScheduler.run(name);

        Sleeping.sleep(TimeConstants.MINUTE * 5);

        LOG.info("play");
        SpringScheduler.play(name);

        Sleeping.sleep(TimeConstants.MINUTE * 10);
    }

}
