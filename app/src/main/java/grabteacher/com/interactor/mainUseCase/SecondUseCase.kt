package grabteacher.com.interactor.mainUseCase;

import grabteacher.com.interactor.base.BaseUseCase
import grabteacher.com.interactor.repository.UserRepository
import grabteacher.com.interactor.schedulers.PostExecutionThread
import grabteacher.com.interactor.schedulers.ThreadExecutor
import io.reactivex.Observable

/**
 * Created by Huu Hoang on 15/12/2018
 */
open class SecondUseCase(
       val userRepository: UserRepository,
        threadExecutor: ThreadExecutor,
        postExecutionThread: PostExecutionThread):
        BaseUseCase<String, List<String>>(threadExecutor, postExecutionThread) {
    /**
     * Builds an [Observable] which will be used when executing the current [UseCase].
     * Any use-case must override this method to provide the entity of that use-case.
     */
    override fun buildUseCaseObservable(params: String): Observable< List<String>> {
        return userRepository.getUsers()
    }
    /**
     * Builds an [Observable] which will be used when executing the current [UseCase].
     * Any use-case must override this method to provide the entity of that use-case.
     */





}