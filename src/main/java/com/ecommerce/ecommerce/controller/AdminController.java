package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.dto.APIResponseDTO;
import com.ecommerce.ecommerce.dto.DetailedUserDTO;
import com.ecommerce.ecommerce.dto.UserDTO;
import com.ecommerce.ecommerce.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    //User Management
    //GET /admin/users: List all users (with optional filters like search by username/email).
    //GET /admin/users/{userId}: View details of a specific user.
    //DELETE /admin/users/{userId}: Delete a user account.
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUser(@RequestParam(required = false) String searchTerm,
                                                 @RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "50") int size)
    {
        Page<UserDTO> users = adminService.searchUsers(searchTerm, page, size);
        return ResponseEntity.ok(users.getContent());
    }
   @DeleteMapping("/users")
    public ResponseEntity<APIResponseDTO> deleteUser(@RequestParam() Long userID) {
       APIResponseDTO apiResponseDTO = adminService.deleteUser(userID);

       if (apiResponseDTO.isSuccess()) {
           return ResponseEntity.ok(apiResponseDTO);
       } else {
           HttpStatus status = apiResponseDTO.getMessage().equals("User not found")
                   ? HttpStatus.NOT_FOUND
                   : HttpStatus.INTERNAL_SERVER_ERROR;

           return ResponseEntity.status(status).body(apiResponseDTO);
       }
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<DetailedUserDTO> getUserDetailed(@PathVariable Long userId){


    }



    //Product Management
    //POST /admin/products: Add a new product.
    //PUT /admin/products/{productId}: Update a product.
    //DELETE /admin/products/{productId}: Delete a product.
    //Category Management

    //POST /admin/categories: Create a new category.
    //PUT /admin/categories/{categoryId}: Update a category.
    //DELETE /admin/categories/{categoryId}: Delete a category.
    //Order Management

    //GET /admin/orders: View all orders across the platform.
    //GET /admin/orders/{orderId}: View details of a specific order.
    //PUT /admin/orders/{orderId}: Update the status of an order.

    //Review Management
    //DELETE /admin/reviews/{reviewId}: Delete a review that violates guidelines.

    //Reporting and Analytics
    //GET /admin/reports/sales: View sales reports.
    //GET /admin/reports/user-activity: Get user activity reports.

    //System and Security Management
    //GET /admin/system/status: Check system health and status.
    //POST /admin/system/notifications: Send system-wide notifications or alerts.


}
