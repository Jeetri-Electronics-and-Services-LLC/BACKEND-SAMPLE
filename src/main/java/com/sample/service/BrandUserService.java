package com.sample.service;



import com.sample.entity.Brand;
import com.sample.entity.User;
import com.sample.repository.BrandRepository;
import com.sample.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandUserService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public boolean addBrandUser(Long brandId, Long userId) {
        Brand brand = brandRepository.findById(brandId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);

        if (brand != null && user != null) {
            entityManager.createNativeQuery("INSERT INTO Brand_User (brand_id, user_id) VALUES (?, ?)")
                    .setParameter(1, brandId)
                    .setParameter(2, userId)
                    .executeUpdate();
            return true;
        }
        return false;
    }
}
