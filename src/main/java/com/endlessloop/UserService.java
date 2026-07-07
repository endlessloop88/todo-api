package com.endlessloop; 

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // @Transactional: Bu metot içindeki tüm işlemler tek bir bütün (Atomic) olarak çalışır.
    // Metot bittiğinde kilit (Lock) otomatik olarak veri tabanı tarafından açılır.
    @Transactional
    public User updateEmailSecurely(Long userId, String newEmail) {
        
        // 1. Kullanıcıyı veri tabanından satır kilitleyerek çekiyoruz (Thread-Safe)
        User user = userRepository.findByIdWithLock(userId)
                .orElseThrow(() -> new IllegalArgumentException("Kullanıcı bulunamadı! ID: " + userId));

        // 2. Geçersiz Durum Kontrolü (Validation)
        // Eğer yeni e-posta eskisinin aynısıysa boşuna işlem yapma, hata fırlat (Merkezi hata yakalayıcımız bunu yakalayacak)
        if (user.getEPosta() != null && user.getEPosta().equals(newEmail)) {
            throw new IllegalArgumentException("Yeni e-posta adresi eskisinden farklı olmalıdır!");
        }

        logger.info("Kullanıcı veri kilitleme ile güncelleniyor. ID: {}, Eski E-Posta: {}, Yeni E-Posta: {}", 
                    userId, user.getEPosta(), newEmail);

        // 3. Durum Güncellemesi
        user.setEPosta(newEmail);
        
        // 4. Kaydet ve Döndür
        return userRepository.save(user);
    }
}