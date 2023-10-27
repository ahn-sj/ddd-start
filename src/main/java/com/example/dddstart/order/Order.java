package com.example.dddstart.order;

import com.example.dddstart.delivery.DeliveryInfo;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

public class Order {

    private OrderNo id;
    private List<ProductOrder> productOrders;
    private Money totalAmounts;
    private DeliveryInfo deliveryInfo;
    private OrderState state;

    public Order(final List<ProductOrder> productOrders, DeliveryInfo deliveryInfo) {
        setProductOrders(productOrders);
        setDeliveryInfo(deliveryInfo);
    }

    private void setDeliveryInfo(final DeliveryInfo deliveryInfo) {
        if(Objects.isNull(deliveryInfo)) {
            throw new IllegalArgumentException("배송지 정보는 필수입니다.");
        }
        this.deliveryInfo = deliveryInfo;
    }

    private void setProductOrders(final List<ProductOrder> productOrders) {
        verifyAtLeastOneOrMorProductOrders(productOrders);
        this.productOrders = productOrders;
        calculateTotalAmounts();
    }

    private void calculateTotalAmounts() {
        int sum = productOrders.stream().mapToInt(productOrders -> productOrders.getAmounts()).sum();
        this.totalAmounts = new Money(sum);
    }

    private void verifyAtLeastOneOrMorProductOrders(final List<ProductOrder> productOrders) {
        if(CollectionUtils.isEmpty(productOrders)) {
            throw new IllegalArgumentException("최소 한 종류 이상의 상품을 주문해야 합니다.");
        }
    }

    public void changeShipped(DeliveryInfo newDeliveryInfo) {
        verifyNotYetShipped();
        setDeliveryInfo(newDeliveryInfo);
    }

    public void cancel() {
        verifyNotYetShipped();
        this.state = OrderState.CANCELED;
    }

    private void verifyNotYetShipped() {
        if(state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING) {
            throw new IllegalStateException("배송지 변경이나 주문 취소는 출고전에만 가능합니다.");
        }
    }

    public void changeShippingInfo() {

    }

    public void completePayment() {

    }

    public OrderNo getId() {
        return id;
    }
}
