package kg.itacademy.OnlineOrder.service.impl;

import kg.itacademy.OnlineOrder.entity.Image;
import kg.itacademy.OnlineOrder.entity.Menu;
import kg.itacademy.OnlineOrder.entity.Order;
import kg.itacademy.OnlineOrder.model.MenuModel;
import kg.itacademy.OnlineOrder.model.OrderModel;
import kg.itacademy.OnlineOrder.model.request.ImageModelRequest;
import kg.itacademy.OnlineOrder.model.respons.ImageModelResponse;
import kg.itacademy.OnlineOrder.repository.ImageRepository;
import kg.itacademy.OnlineOrder.repository.MenuRepository;
import kg.itacademy.OnlineOrder.repository.OrderRepository;
import kg.itacademy.OnlineOrder.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceimpl extends UserService {

    private final OrderRepository orderRepository;
    private final MenuRepository menuRepository;
    private final ImageRepository imageRepository;

    private final static String URL_PATH = "C:\\Users\\user\\Desktop";


    public MenuModel addNewFood(MenuModel menuModel) {
        Menu menu = new Menu();
        menu.setFoodName(menuModel.getNameFood());
        menu.setPrice(menuModel.getPrice());
        menu.setIngredients(menuModel.getIngredients());
        menuRepository.save(menu);
        return menuModel;
    }


    public ImageModelResponse saveImage(ImageModelRequest imageModelRequest) {
        Image image = null;

        try {
            File imageFile = new File(URL_PATH + imageModelRequest.getName() + ".png");
            imageModelRequest.getFile().transferTo(imageFile);

            image = imageRepository.save(Image.builder()
                    .NameFile(imageFile.getName())
                    .pathFile(imageFile.getName())
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ImageModelResponse.builder()
                .name(image.getNameFile())
                .path(image.getPathFile())
                .build();
    }

    @Override
    public List<ImageModelResponse> getAll(ImageModelResponse imageModelResponse) {
        List<ImageModelResponse> imageModelResponses = new ArrayList<>();

        imageRepository.findAll().forEach(x -> imageModelResponses.add(
                ImageModelResponse.builder()
                        .name(x.getNameFile())
                        .path(x.getPathFile())
                        .build()
        ));
        return imageModelResponses;
    }

//    @Override
//    public OrderModel getOrderById(Long id) {
//        Order order = orderRepository
//                .findById(id)
//                .orElseThrow(() -> new ChangeSetPersister.NotFoundException("Id: " + id + "не найден"));
//        return null;
//    }

    @Override
    public void deleteFoodById(Long id) {
        menuRepository.deleteById(id);
    }
}

