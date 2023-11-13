package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.Users;
import com.ecommerce.ecommerce.service.AdminService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<List<Users>> getUser(@RequestParam(required = false) String username,
                                               @RequestParam(required = false) String email,
                                               @RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "50") int size)
    {
        if (username == null && email == null ) //username == null || username.isEmpty() && email == null || email.isEmpty()
        {
            return ResponseEntity.ok((adminService.searchAllUsers(page,size)));
        }
        else
        {
            return  ResponseEntity.ok(adminService.searchUserByFilter(username,email));
        }
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
