package com.shakov.goodbuyproject.integrartion.databse.repository;

import com.shakov.goodbuyproject.database.entity.User;
import com.shakov.goodbuyproject.database.repository.UserRepository;
import com.shakov.goodbuyproject.integrartion.IntegrationTestBase;
import com.shakov.goodbuyproject.integrartion.annotation.IT;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;


import java.time.Instant;



import static org.assertj.core.api.Assertions.*;

@IT
@RequiredArgsConstructor
public class UserRepositoryTest extends IntegrationTestBase {

    private final UserRepository userRepository;
    private final EntityManager entityManager;

    @Test
    void checkAuditing() {

        User user = userRepository.findById(1L).get();
        user.setBirthDate(user.getBirthDate().plusYears(1L));
        entityManager.flush();

        Instant actualDate = user.getModifiedAt();
        String actualBy = user.getModifiedBy();


        assertThat(actualDate).isNotNull();
        assertThat(actualBy).isEqualTo("Shakov");



    }


}
