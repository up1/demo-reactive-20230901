import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class OrderService {

    private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    void process() {
        System.out.println("Called");
        Future<String> result =  this.paymentService.pay();
        System.out.println("Done");
        try {
            System.out.println("Receive result = " + result.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);
        orderService.process();
        orderService.process();

        System.out.println("Total time : " + (System.currentTimeMillis() - start));
    }

}


interface A {
    void doSth(String result);
}

class Caller implements  A {
    @Override
    public void doSth(String result) {
        System.out.println("Received = " + result);
    }

    void process() {
        Target target = new Target();
        target.call(this);
    }

    public static void main(String[] args) {
        Caller caller = new Caller();
        caller.process();
    }
}

class Target {
    void call(A a) {
        // TODO
        a.doSth("Result from target");
    }
}
