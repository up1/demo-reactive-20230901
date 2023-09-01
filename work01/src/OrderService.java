public class OrderService {

    private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    void process() {
        this.paymentService.pay();
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
