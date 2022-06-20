package hr.tvz.ivankovic.hardwareapp.hardware;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MockHardwareRepository implements HardwareRepository {
    private final Set<Hardware> MOCK_HARDWARE = new HashSet(Arrays.asList(
            new Hardware(13L, "1434", "Geforce GTX 1060", 121.75 , "GPU", 12),
            new Hardware(22L, "2655", "Intel® Core™ i5-9400F", 170.99, "CPU", 13)
    ));

    @Override
    public Set<Hardware> findAll() {
        return MOCK_HARDWARE;
    }
    @Override
    public Optional<Hardware> findByCode(final String code) {
        return MOCK_HARDWARE.stream().filter(h -> Objects.equals(h.getCode(), code)).findAny();
    }
    @Override
    public Optional<Hardware> save(final Hardware hardware){
        if(MOCK_HARDWARE.stream().noneMatch(h -> h.getCode().equals(hardware.getCode()))){
            MOCK_HARDWARE.add(hardware);
            return Optional.of(hardware);
        }
        else{
            return Optional.empty();
        }
    }
    @Override
    public Optional<Hardware> update(String code, Hardware hardware){
        if(MOCK_HARDWARE.stream().noneMatch(h -> h.getCode().equals(hardware.getCode()))){
            return Optional.empty();
        }
        else{
            MOCK_HARDWARE.removeIf(h->h.getCode().equals(hardware.getCode()));
            MOCK_HARDWARE.add(hardware);
            return Optional.of(hardware);
        }
    }

    @Override
    public void deleteByCode(final String code) {
        MOCK_HARDWARE.removeIf(h -> h.getCode().equals(code));
    }
}
