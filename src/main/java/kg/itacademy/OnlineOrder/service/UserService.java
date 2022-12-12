package kg.itacademy.OnlineOrder.service;

import kg.itacademy.OnlineOrder.model.MenuModel;
import kg.itacademy.OnlineOrder.model.OrderModel;
import kg.itacademy.OnlineOrder.model.respons.ImageModelResponse;

import java.util.List;

public abstract class UserService {

    public MenuModel addNewFood(MenuModel menuModel) {
        return null;
    }

    public OrderModel getOrderById(Long id) {
        return null;
    }

    public abstract List<ImageModelResponse> getAll(ImageModelResponse imageModelResponse);

    public void deleteFoodById(Long id) {

    }
}
