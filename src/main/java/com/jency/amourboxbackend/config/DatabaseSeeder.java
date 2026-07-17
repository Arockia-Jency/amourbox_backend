package com.jency.amourboxbackend.config;

import com.jency.amourboxbackend.model.Capsule;
import com.jency.amourboxbackend.model.Coupon;
import com.jency.amourboxbackend.model.Memory;
import com.jency.amourboxbackend.repository.CapsuleRepository;
import com.jency.amourboxbackend.repository.CouponRepository;
import com.jency.amourboxbackend.repository.MemoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DatabaseSeeder {

    @Bean
    CommandLineRunner initDatabase(CapsuleRepository capsuleRepository, CouponRepository couponRepository, MemoryRepository memoryRepository) {
        return args -> {
            // Seed Capsules if empty
            if (capsuleRepository.count() == 0) {
                Capsule today = new Capsule();
                today.setMessage("Good morning handsome! Just a little reminder that I love you to the moon and back. ❤️");
                today.setMood("Romantic");
                today.setUnlockDate(LocalDate.now());
                capsuleRepository.save(today);
            }

            // Seed Coupons if empty
            if (couponRepository.count() == 0) {
                Coupon c1 = new Coupon();
                c1.setTitle("Free Back Massage 💆‍♂️");
                c1.setDescription("Good for one long relaxing back rub after a stressful work week.");
                c1.setRedeemed(false);
                couponRepository.save(c1);

                Coupon c2 = new Coupon();
                c2.setTitle("Breakfast in Bed 🍳");
                c2.setDescription("You get to sleep in while I cook your favorite breakfast pancakes.");
                c2.setRedeemed(false);
                couponRepository.save(c2);

                Coupon c3 = new Coupon();
                c3.setTitle("Movie Night Selector 🎬");
                c3.setDescription("Skip the arguing! You get absolute control over what we watch tonight.");
                c3.setRedeemed(false);
                couponRepository.save(c3);

                System.out.println("✅ Coupon seed data loaded into Docker PostgreSQL successfully!");
            }
            if (memoryRepository.count() == 0) {
                Memory m1 = new Memory();
                m1.setTitle("The Day We Met ☕");
                m1.setDescription("You wore that ridiculous green jacket and spilled half your coffee, but your smile completely caught me off guard.");
                m1.setMemoryDate(LocalDate.now().minusYears(2)); // 2 years ago
                m1.setImageUrl("https://example.com/photos/day-one.jpg");
                memoryRepository.save(m1);

                Memory m2 = new Memory();
                m2.setTitle("Our First Road Trip 🚗");
                m2.setDescription("Singing at the top of our lungs on the highway. We got completely lost, but it turned out to be the best weekend ever.");
                m2.setMemoryDate(LocalDate.now().minusMonths(6)); // 6 months ago
                m2.setImageUrl("https://example.com/photos/roadtrip.jpg");
                memoryRepository.save(m2);

                System.out.println("✅ Memory timeline data seeded successfully into PostgreSQL!");
            }

        };
    }
}
