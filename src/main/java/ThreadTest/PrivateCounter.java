package ThreadTest;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Callable;

@Slf4j
public class PrivateCounter implements Callable<Integer> {

    long operatingTime;


    public PrivateCounter(long operatingTime) {
        super();
        this.operatingTime = operatingTime;
    }

    public Integer call() throws Exception {
        //sleep单位毫秒
        log.info("这里是子线程，开始工作，工作需要大约{}秒钟", this.operatingTime);
        Thread.sleep(this.operatingTime * 1000);
        Integer totalTime = new Random().nextInt(10000);
        log.info("这里是子线程,工作完成");
        return totalTime;
    }
}
