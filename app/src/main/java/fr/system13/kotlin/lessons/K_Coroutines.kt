package fr.system13.kotlin.lessons

import fr.system13.kotlin.Logger
import kotlinx.coroutines.* // Permet d'utiliser des coroutines
import kotlin.coroutines.CoroutineContext

class K_Coroutines {

    fun callALl() {

        callSynchronous()
        callBasic()
        callCoroutineScope()
        callDeferred()
        callDeferredWithReturn()
        callJob()
        callJobWithCoroutineContext()
        callJobWithCoroutineContextName()
        callJobWithCoroutineContextDispatcher()
        callJobWithCoroutineContextJob()
        callJobWithCoroutineContextExceptionHandler()
    }

    // runBlocking est une coroutine qui bloque le thread courant
    // jusqu'à ce que la coroutine qu'elle lance soit terminée.
    // Elle est très utile pour les tests ou les cas d'utilisation
    fun callSynchronous() {
        runBlocking {
            Logger.debug("callSynchronous", "AVANT délai de 100 ms pour runBlocking")
            delay(100L)
            Logger.debug("callSynchronous", "APRÈS délai de 100 ms pour runBlocking")
        }
    }

    // Une "suspend fun" est une fonction qui peut contenir des appels à d'autres "suspend fun".
    // Elle est elle-même bloquante et ne peut être appelée que depuis une coroutine.
    suspend fun showOutput(method: String, output: String, delay: Long) {
        Logger.debug(method, "AVANT délai de $delay ms pour $output")
        delay(delay)
        Logger.debug(method, "APRÈS délai de $delay ms pour $output")
    }

    // launch est une coroutine qui ne bloque pas le thread courant
    // et qui peut donc s'exécuter en parallèle
    fun callBasic() {
        runBlocking {
            // ici, on lance 2 coroutines en parallèle, mais launchBasic-2 finira AVANT launchBasic-1
            launch { showOutput("launchBasic", "launch-basic-1", 200L) }
            launch { showOutput("launchBasic", "launch-basic-2", 100L) }
        }
    }

    // Un coroutineScope est un scope qui permet de lancer des coroutines en parallèle.
    // Les coroutines lancées dans un coroutineScope sont attendues pour leur terminaison.
    // Cela signifie que si une coroutine lance une exception, elle sera propagée au coroutineScope
    // et que les autres coroutines du scope seront annulées.
    fun callCoroutineScope() {
        runBlocking {
            coroutineScope {
                // ici, on lance 2 coroutines en parallèle, mais launchBasic-2 finira AVANT launchBasic-1
                launch { showOutput("callCoroutineScope", "launch-coroutineScope-1", 200L) }
                launch { showOutput("callCoroutineScope", "launch-coroutineScope-2", 100L) }
            }
        }
    }

    // Deferred est une coroutine qui ne bloque pas le thread courant
    // et qui peut donc s'exécuter en parallèle
    // (en C#, l'équivalent de Deferred est Task)
    fun callDeferred() {
        runBlocking {
            // ici, on lance 2 coroutines en parallèle, mais launchBasic-2 finira AVANT launchBasic-1
            val deferred1: Deferred<Unit> = async { showOutput("launchDeferred", "launch-deferred-1", 200L) }
            val deferred2: Deferred<Unit> = async { showOutput("launchDeferred", "launch-deferred-2", 100L) }
            deferred1.await()
            deferred2.await()
        }
    }

    // Deferred avec une valeur de retour (au lieu de Unit)
    fun callDeferredWithReturn() {
        runBlocking {
            val deferred1: Deferred<String> = async { showOutput("launchDeferredWithReturn", "launch-deferred-1 + return", 200L); "RESULT 1" }
            val deferred2: Deferred<String> = async { showOutput("launchDeferredWithReturn", "launch-deferred-2 + return", 100L); "RESULT 2" }
            val result1: String = deferred1.await()
            val result2: String = deferred2.await()
            Logger.debug("launchDeferredWithReturn", "result1 : $result1, result2 : $result2")
        }
    }

    // Un Job est une coroutine qui peut être annulée.
    // Avec join(), on attend la fin d'une coroutine.
    // Si un Job est annulé, toutes les coroutines qu'il lance sont également annulées.
    fun callJob() {
        runBlocking {
            // ici, on lance 2 coroutines en parallèle, mais launchBasic-2 finira AVANT launchBasic-1
            val job1: Job = launch { showOutput("launchJob", "launch-job-1 ", 200L) }
            val job2: Job = launch { showOutput("launchJob", "launch-job-2 ", 400L) }
            val job3: Job = launch { showOutput("launchJob", "launch-job-3 ANNULÉ", 1000L) }
            // On attend la fin des 2 coroutines
            job1.join()
            job2.join()
            job3.cancel()
        }
    }

    fun callJobWithCoroutineContext() {
        runBlocking {
            // déclaration du coroutineContext dans le constructor du launch
            // Paramètres de configuration de la coroutine séparés par un +
            val job1: Job = launch { showOutput("launchCoroutineContext", "launch-job-1 SANS CoroutineContext", 200L) }
            // ou déclaration du coroutineContext dans le block du launch
            val job2: Job = launch {
                withContext(Dispatchers.Default + job1 + CoroutineName("customCoroutine")) {
                    showOutput("launchCoroutineContext", "launch-job-2 AVEC CoroutineContext", 300L)
                }
            }

            job1.join()
            job2.join()
        }
    }

    // Le nom de la coroutine est un paramètre de configuration de la coroutine.
    // Il permet de mieux comprendre le comportement des coroutines.
    // - si le nom de la coroutine est le même que le nom de la coroutine parente, alors la coroutine est considérée comme une coroutine fille
    fun callJobWithCoroutineContextName() {
        runBlocking {
            val firstJob: Job = launch(CoroutineName("One")) { showOutput("callJobWithCoroutineContextName", "launch-job-1 NAME : ${this.coroutineContext[CoroutineName.Key]}", 100L) }
            val secondJob: Job = launch(CoroutineName("Two")) { showOutput("callJobWithCoroutineContextName", "launch-job-2 NAME : ${this.coroutineContext[CoroutineName.Key]}", 100L) }
            // → AVANT délai de 1s pour launch-job-1 NAME : CoroutineName(One)
            firstJob.join()
            secondJob.join()
        }
    }

    // Le Dispatcher est un paramètre de configuration de la coroutine,
    // il permet de choisir le thread sur lequel la coroutine sera lancée
    // Dispatchers :
    //      Default : le plus souvent utilisé, mais pas toujours
    //      IO : pour les tâches IO (lecture et ecriture de fichiers, base de données, etc.)
    //      Main : pour les tâches UI (Principale)
    //      Unconfined.
    @OptIn(ExperimentalStdlibApi::class)
    fun callJobWithCoroutineContextDispatcher() {
        runBlocking {
            val job: Job = launch(Dispatchers.Default) { showOutput("callJobWithCoroutineContextDispatcher", "launch-job-1 DISPATCHER : ${this.coroutineContext[CoroutineDispatcher.Key]}", 200L) }
            job.join()
        }
    }

    // Le Job est un paramètre de configuration de la coroutine,
    // cela signifie que la coroutine qui est lancée est une coroutine fille
    // de la coroutine qui lance (Job)
    fun callJobWithCoroutineContextJob() {
        runBlocking {

            val mainJob: Job = launch { showOutput("callJobWithCoroutineContextJob", "launch-job-MAIN JOB : ${this.coroutineContext[Job.Key]}", 200L) }

            val jobSub: Job = launch(mainJob) {
                showOutput("callJobWithCoroutineContextJob", "launch-job-SUB JOB : ${this.coroutineContext[Job.Key]}", 200L)
            }
            mainJob.join()  // Attend que mainJob et tous ses enfants (dont subJob) soient terminés
            jobSub.join()   // Cette ligne est redondante, car subJob sera déjà terminé
        }
    }

    fun callJobWithCoroutineContextExceptionHandler() {
        runBlocking {
            // Pour une meilleure gestion des ressources, il est préférable de placer
            // les déclarations à l'intérieur de runBlocking :
            val exceptionHandler = CoroutineExceptionHandler { c, e -> handleException(c, e) }

            // Le scope est lié à la durée de vie de runBlocking (donc dans runBlocking)
            val scope = CoroutineScope(SupervisorJob() + exceptionHandler)

            try {
                val job: Job = scope.launch(CoroutineName("One")) {
                    showOutput("callJobWithCoroutineContextExceptionHandler", "launch-job NAME : ${this.coroutineContext[CoroutineName.Key]}", 1000L)
                    throw Exception("DUMMY EXCEPTION")
                }
                job.join()
            } catch (e: Exception) {
                Logger.debug("exceptionHandler", "Exception : ${e.message}")
            } finally {
                scope.cancel() // Nettoyage explicite
            }
        }
    }

    private fun handleException(coroutineContext: CoroutineContext, exception: Throwable) {
        runBlocking {
            val job: Job = launch {

                Logger.debug(
                    "exceptionHandler",
                    "NAME : ${coroutineContext[CoroutineName.Key]} " +
                            "JOB : ${coroutineContext[Job.Key]} " +
                            "IsActive : ${coroutineContext[Job.Key]?.isActive} " +
                            "Exception : ${exception.message}"
                )

                coroutineContext[Job.Key]?.cancel()
            }
            job.join()
            Logger.debug("exceptionHandler", "JOB IsActive : ${coroutineContext[Job.Key]?.isActive} ")
        }
    }
}
