import java.util.function.Consumer;

public class PaymentService {

    void pay(Consumer<String> consumer){
        // Non-Blocking
        new Thread( () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            consumer.accept("Done");
        }).start();
    }

}
