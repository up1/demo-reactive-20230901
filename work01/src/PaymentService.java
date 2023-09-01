import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class PaymentService {

    Future<String> pay(){
        // Non-Blocking
        FutureTask<String> future = new FutureTask<>(() -> {
            Thread.sleep(1000);
            return "Done";
        });
        new Thread(future).start();
        return future;
    }

}
