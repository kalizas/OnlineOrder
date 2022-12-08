package kg.itacademy.OnlineOrder.controller;

import kg.itacademy.OnlineOrder.model.MenuModel;
import kg.itacademy.OnlineOrder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 3600, origins = "*")
@RestController
@RequestMapping("api/admin")
public class UserController {

    @Autowired
    private UserService adminServise;

    @PostMapping("/create/new/food")
    public ResponseEntity<?> addNewFood(@RequestBody MenuModel postModel) {
        try {
            return new ResponseEntity(adminServise.addNewFood(postModel), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-post/{id}")
    public ResponseEntity<?> getOrederById(@PathVariable Long id) {
        try {
            return new ResponseEntity(adminServise.getOrderById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-food/{id}")
    public ResponseEntity<?> deleteFoodById(Long id) {
        adminServise.deleteFoodById(id);
        return ResponseEntity.ok(true);
    }

}

