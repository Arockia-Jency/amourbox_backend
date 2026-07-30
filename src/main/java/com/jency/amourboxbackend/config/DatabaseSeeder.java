package com.jency.amourboxbackend.config;

import com.jency.amourboxbackend.model.Capsule;
import com.jency.amourboxbackend.model.Coupon;
import com.jency.amourboxbackend.model.LoveLetter;
import com.jency.amourboxbackend.model.Memory;
import com.jency.amourboxbackend.model.ScratchCard;
import com.jency.amourboxbackend.repository.CapsuleRepository;
import com.jency.amourboxbackend.repository.CouponRepository;
import com.jency.amourboxbackend.repository.LoveLetterRepository;
import com.jency.amourboxbackend.repository.MemoryRepository;
import com.jency.amourboxbackend.repository.ScratchCardRepository;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DatabaseSeeder {

    @Bean
    CommandLineRunner initDatabase(
            CapsuleRepository capsuleRepository,
            CouponRepository couponRepository,
            MemoryRepository memoryRepository,
            ScratchCardRepository scratchCardRepository, // 👈 Added ScratchCardRepository here
            LoveLetterRepository loveLetterRepository // 💌 Love letters seeded by mood
    ) {
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

                System.out.println("✅ Coupon seed data loaded into PostgreSQL successfully!");
            }

            // Seed Memories if empty
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

            // 🌟 Seed Scratch Cards if empty
            if (scratchCardRepository.count() == 0) {
                ScratchCard s1 = new ScratchCard("Remember when we laughed so hard on our first date? I love you! ❤️", "MEMORY");
                ScratchCard s2 = new ScratchCard("One free giant hug valid anytime today! 🤗", "LOVE");
                ScratchCard s3 = new ScratchCard("Dinner date at your favorite spot on me! 🍕", "DATE");

                scratchCardRepository.save(s1);
                scratchCardRepository.save(s2);
                scratchCardRepository.save(s3);

                System.out.println("✅ ScratchCard pool data seeded successfully into PostgreSQL!");
            }

            // 💌 Seed Love Letters if empty (one per mood the app asks for: HAPPY, STRESSED, MISSING_ME, TIRED)
            if (loveLetterRepository.count() == 0) {
                loveLetterRepository.saveAll(List.of(
                        // ---------- HAPPY ----------
                        new LoveLetter("HAPPY",
                                "Keep smiling, my love ☀️",
                                "Seeing you happy is my favourite thing in the whole world. Hold on to this feeling and know that I'm smiling right along with you, wherever I am. You deserve every bit of this joy. I love you, always and unconditionally. ❤️"),
                        new LoveLetter("HAPPY",
                                "My favourite person 🥰",
                                "On your good days, remember how proud I am of the man you are. Your laugh is the sound my heart calls home. Stay bold, stay silly, stay you — I'm cheering for you today and every day. Yours, forever. 💛"),

                        // ---------- STRESSED ----------
                        new LoveLetter("STRESSED",
                                "Breathe, my love 🌿",
                                "I know today feels heavy. Put your shoulders down, take one slow breath, and remember: you have carried hard things before and you always come through. You are stronger than this moment. I'm right here with you, holding your hand through it. We've got this — together. ❤️"),
                        new LoveLetter("STRESSED",
                                "You are not alone 🤍",
                                "Whatever is pressing on you right now, you don't have to hold it by yourself. Stay calm, stay bold — this storm will pass and I'll still be right beside you when it does. Rest for a second. I believe in you completely. Always yours. 💫"),

                        // ---------- MISSING_ME ----------
                        new LoveLetter("MISSING_ME",
                                "I'm right here 💌",
                                "Missing me already? I'm just a room away, and even when the day pulls us apart for a few hours, my heart never leaves your side. Hold this thought until you can hold me — I'm counting down to the moment I see your face again. ❤️"),
                        new LoveLetter("MISSING_ME",
                                "Always yours 🌙",
                                "Even the little time we spend apart makes me realise how lucky I am to come home to you. I'm yours, completely — and tonight I'll be right beside you again. Save me a hug; I'm already on my way back to you. 💛"),

                        // ---------- TIRED ----------
                        new LoveLetter("TIRED",
                                "Rest now, my love 🌛",
                                "You've done so much today — more than enough. Let your shoulders drop and let yourself rest without guilt. You don't have to be strong every single minute; I've got you. Close your eyes, breathe slow, and let tomorrow wait. I'm so proud of you. Sleep well, my heart. ❤️"),
                        new LoveLetter("TIRED",
                                "Lean on me 🤗",
                                "When you're running on empty, lean on me — that's what I'm here for. Rest is not giving up, it's how you come back stronger. Take the night off in your heart and know that you are deeply, endlessly loved. I'll be right here in the morning. Always. 💫")
                ));

                System.out.println("✅ LoveLetter data seeded successfully into PostgreSQL! 💌");
            }

        };
    }
}