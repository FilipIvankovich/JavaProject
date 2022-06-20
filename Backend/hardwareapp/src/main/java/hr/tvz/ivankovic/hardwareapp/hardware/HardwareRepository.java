package hr.tvz.ivankovic.hardwareapp.hardware;

import java.util.Optional;
import java.util.Set;

public interface HardwareRepository {
    Set<Hardware> findAll();
    Optional<Hardware> findByCode(String code);
    Optional<Hardware> save(Hardware hardware);
    void deleteByCode(String code);
    Optional<Hardware> update(String code, Hardware hardware);
}
