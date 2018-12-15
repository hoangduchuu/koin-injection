package grabteacher.com.interactor.schedulers;


import java.util.concurrent.Executor;


/**
 * Executor implementation can be based on different frameworks or techniques of asynchronous
 * execution, but every implementation will execute the
 * {@link grabteacher.com.interactor.base.BaseUseCase} out of the UI thread.
 */
public interface ThreadExecutor extends Executor {
}
