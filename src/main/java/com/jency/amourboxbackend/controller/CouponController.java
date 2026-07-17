package com.jency.amourboxbackend.controller;


import com.jency.amourboxbackend.dto.CouponResponseDto;
import com.jency.amourboxbackend.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coupons")
@CrossOrigin(origins = "*")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @GetMapping
    public ResponseEntity<List<CouponResponseDto>> getCoupons() {
        return ResponseEntity.ok(couponService.getAllCoupons());
    }

    @PutMapping("/{id}/redeem")
    public ResponseEntity<CouponResponseDto> redeem(@PathVariable Long id) {
        return ResponseEntity.ok(couponService.redeemCoupon(id));
    }
}
