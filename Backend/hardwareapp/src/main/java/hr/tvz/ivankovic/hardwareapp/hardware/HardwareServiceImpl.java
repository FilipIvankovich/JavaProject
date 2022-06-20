package hr.tvz.ivankovic.hardwareapp.hardware;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HardwareServiceImpl implements HardwareService {
    private final JdbcHardwareRepository hardwareRepository;

    public HardwareServiceImpl(JdbcHardwareRepository hardwareRepository) {
        this.hardwareRepository = hardwareRepository;
    }

    @Override
    public List<HardwareDTO> findAll() {
        return hardwareRepository.findAll().stream().map(this::mapHardwareToDTO).collect(Collectors.toList());
    }
    @Override
    public Optional<HardwareDTO> findByCode(final String code) {
        return hardwareRepository.findByCode(code).map(this::mapHardwareToDTO);
    }
    @Override
    public Optional <HardwareDTO> save(final HardwareCommand hardwareCommand){
        return hardwareRepository.save(mapCommandToHardware(hardwareCommand)).map(this::mapHardwareToDTO);
    }
    @Override
    public void deleteByCode(final String code){ hardwareRepository.deleteByCode(code); }
    @Override
    public Optional<HardwareDTO> update(final String code, final HardwareCommand newHardwareCommand){
        return hardwareRepository.update(code, mapCommandToHardware(newHardwareCommand)).map(this::mapHardwareToDTO);
    }

    private HardwareDTO mapHardwareToDTO(final Hardware hardware){
        return new HardwareDTO(hardware.getName(), hardware.getPrice(), hardware.getCode(), hardware.getAvailability());
    }
    private static Hardware mapCommandToHardware(final HardwareCommand hardwareCommand){
        return new Hardware(hardwareCommand.getId(), hardwareCommand.getName(), hardwareCommand.getCode(), hardwareCommand.getPrice(), hardwareCommand.getType(), hardwareCommand.getStock());
    }
}
