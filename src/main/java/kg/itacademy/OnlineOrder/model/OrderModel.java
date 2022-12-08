package kg.itacademy.OnlineOrder.model;

import lombok.*;

import java.time.LocalDateTime;

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public class OrderModel {

        private Long id;

        private LocalDateTime scheduleTime;

        private MenuModel menu;
}
