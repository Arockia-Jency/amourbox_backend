package com.jency.amourboxbackend.service;


import com.jency.amourboxbackend.dto.CouponResponseDto;
import com.jency.amourboxbackend.model.Coupon;
import com.jency.amourboxbackend.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;


//get all coupons
    public List<CouponResponseDto> getAllCoupons() {
        return couponRepository.findAll().stream()
                .map(coupon -> new CouponResponseDto(
                        coupon.getId(),
                        coupon.getTitle(),
                        coupon.getDescription(),
                        coupon.isRedeemed()))
                .collect(Collectors.toList());
    }

    //  Business Logic to redeem a coupon
    public CouponResponseDto redeemCoupon(Long id) {
        Coupon coupon = couponRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coupon not found!"));

        if (coupon.isRedeemed()) {
            throw new RuntimeException("This coupon has already been claimed! ❤️");
        }

        coupon.setRedeemed(true);
        Coupon updatedCoupon = couponRepository.save(coupon);

        return new CouponResponseDto(
                updatedCoupon.getId(),
                updatedCoupon.getTitle(),
                updatedCoupon.getDescription(),
                updatedCoupon.isRedeemed());
    }


}
