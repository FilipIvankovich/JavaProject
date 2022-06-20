package hr.tvz.ivankovic.hardwareapp.hardware;

import org.springframework.context.annotation.Primary;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Repository;

import javax.annotation.security.RolesAllowed;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Primary
@Repository
public class JdbcHardwareRepository implements HardwareRepository{
    private static final String SELECT_ALL =
            "SELECT id, code, name, price, type, availability FROM HARDWARE";

    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert inserter;


    public JdbcHardwareRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
        this.inserter = new SimpleJdbcInsert(jdbc)
                .withTableName("HARDWARE")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Set<Hardware> findAll() {return Set.copyOf(jdbc.query(SELECT_ALL, this::mapRowToHardware));}

    @Override
    public Optional<Hardware> findByCode(final String code) {
        try {
            return Optional.ofNullable(
                jdbc.queryForObject(SELECT_ALL + " WHERE code = ?", this::mapRowToHardware, code)
            );
        } catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }
    @Override
    @RolesAllowed("ADMIN")
    public Optional<Hardware> save(Hardware hardware){
        try {
            hardware.setId(saveHardwareDetail(hardware));
            return Optional.of(hardware);
        } catch(DuplicateKeyException e){
            return Optional.empty();
        }
    }
    private Long saveHardwareDetail(Hardware hardware){
        Map<String, Object> values = new HashMap<>();

        values.put("code", hardware.getCode());
        values.put("name", hardware.getName());
        values.put("price", hardware.getPrice());
        values.put("type", hardware.getType());
        values.put("availability", hardware.getAvailability());

        return inserter.executeAndReturnKey(values).longValue();
    }
    @Override
    @RolesAllowed("ADMIN")
    public Optional<Hardware> update(String code, Hardware updatedHardware){
        int executed = jdbc.update("UPDATE HARDWARE SET " +
            "name = ?," +
            "price = ?," +
            "type = ?," +
            "availability = ?" +
            " WHERE code = ?",
            updatedHardware.getName(),
            updatedHardware.getPrice(),
            updatedHardware.getType(),
            updatedHardware.getAvailability(),
            code
        );
        if(executed > 0)
            return Optional.of(updatedHardware);
        else
            return Optional.empty();
    }

    @Override
    @RolesAllowed("ADMIN")
    public void deleteByCode(final String code) {
        jdbc.update("DELETE FROM HARDWARE WHERE code = ?", code);
    }

    private Hardware mapRowToHardware(ResultSet rs, int rowNum) throws SQLException {
        return new Hardware(
                rs.getLong("id"),
                rs.getString("code"),
                rs.getString("name"),
                rs.getDouble("price"),
                rs.getString("type"),
                rs.getInt("availability")
        );
    }
}
