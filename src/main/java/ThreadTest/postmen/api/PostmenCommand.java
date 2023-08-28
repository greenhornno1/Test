package ThreadTest.postmen.api;

import java.util.concurrent.Callable;

public abstract class PostmenCommand<T> implements Callable<T> {





    public abstract T call() throws Exception;
}
