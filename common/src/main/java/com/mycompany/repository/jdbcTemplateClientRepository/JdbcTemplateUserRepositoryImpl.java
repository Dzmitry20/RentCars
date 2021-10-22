package com.mycompany.repository.jdbcTemplateClientRepository;


import com.mycompany.domain.Role;
import com.mycompany.domain.User;
import com.mycompany.domain.status.Gender;
import com.mycompany.repository.UserColumn;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class JdbcTemplateUserRepositoryImpl implements UserRepository{

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;



    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from users", this::getUserRowMapper);
    }

    private User getUserRowMapper(ResultSet rs, int i) throws SQLException {
        User user = new User();
        user.setId(rs.getLong(UserColumn.ID));
        user.setName(rs.getString(UserColumn.NAME));
        user.setSurname(rs.getString(UserColumn.SURNAME));
        user.setPhone(rs.getLong(UserColumn.PHONE));
        user.setPassportSeries(rs.getString(UserColumn.PASSPORT_SERIES));
        user.setPassportNumber(rs.getInt(UserColumn.PASSPORT_NUMBER));
        user.setEmail(rs.getString(UserColumn.EMAIL));
        user.setDriverLicenseNumber(rs.getInt(UserColumn.DRIVER_LICENSE_NUMBER));
        user.setLogin(rs.getString(UserColumn.LOGIN));
        user.setPassword(rs.getString(UserColumn.PASSWORD));
        user.setGender(Gender.valueOf(rs.getString(UserColumn.GENDER)));
        return user;
    }

    @Override
    public List<User> findUsersByQuery(Integer limit, String query) {
        return null;
    }

    @Override
    public Double getUserExpensiveCarPrice(Integer userId) {
        return null;
    }
//
//    @Override
//    public void batchInsert(List<User> users) {
//
//    }



        @Override
        public void saveUserRoles(User user, List<Role> userRoles) {
            final String createQuery = "insert into user_roles (role_id, users_id) " +
                    "values (:roleId, :userId);";

            List<MapSqlParameterSource> batchParams = new ArrayList<>();

            for (Role role : userRoles) {

                MapSqlParameterSource params = new MapSqlParameterSource();
                params.addValue("roleId", role.getId());
                params.addValue("userId", user.getId());

                batchParams.add(params);
            }

            namedParameterJdbcTemplate.batchUpdate(createQuery, batchParams.toArray(new MapSqlParameterSource[0]));
        }




    @Override
    public User findByLoginAndPassword(String login, String password) {
        final String searchQuery = "select * from users where login = :login and password = :password";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("password", password);
        params.addValue("login", login);

        return namedParameterJdbcTemplate.queryForObject(searchQuery, params, this::getUserRowMapper);
    }

    @Override
    public User findByLogin(String login) {
        final String searchQuery = "select * from users where login = :login";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("login", login);

        return namedParameterJdbcTemplate.queryForObject(searchQuery, params, this::getUserRowMapper);
    }



//    @Override
//    public void addOne(User entity) {
//
//    }

    @Override
    public void save(List<User> entities) {

    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    //
    @Override
    public User findOne(Long id) {
        //final String findOneWithWildcard = "select * from users where id = ?";
        //return jdbcTemplate.queryForObject(findOneWithWildcard, new Object[]{id}, this::getUserRowMapper);
        //return jdbcTemplate.queryForObject(findOneWithWildcard, this::getUserRowMapper, id);

        final String findOneWithNameParam = "select * from users where id = :qweqwe";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("qweqwe", id);

        return namedParameterJdbcTemplate.queryForObject(findOneWithNameParam, params, this::getUserRowMapper);
    }

    @Override
    public User save(User entity) {
        final String createQuery = "insert into users (name, surname, phone, passport_series, passport_number, email, driver_license_number, login, password, gender  ) " +
                "values (:name, :surname, :phone, :passportSeries, :passportNumber, :email, :driverLicenseNumber, :login, :password, :gender );";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource params = generateUserParamsMap(entity);

        namedParameterJdbcTemplate.update(createQuery, params, keyHolder, new String[]{"id"});

        long createdUserId = Objects.requireNonNull(keyHolder.getKey()).longValue();

        return findOne(createdUserId);
    }


    private MapSqlParameterSource generateUserParamsMap(User entity) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", entity.getName());
        params.addValue("surname", entity.getSurname());
        params.addValue("phone", entity.getPhone());
        params.addValue("passportSeries", entity.getPassportSeries());
        params.addValue("passportNumber", entity.getPassportNumber());
        params.addValue("email", entity.getEmail());
        params.addValue("driverLicenseNumber", entity.getDriverLicenseNumber());
        params.addValue("login", entity.getLogin());
        params.addValue("password", entity.getPassword());
        params.addValue("gender", entity.getGender().name());

        return params;
    }

    @Override
    public void addOne(User entity) {
        final String createQuery = "insert into users (name, surname, birth_date, login, weight) " +
                "values (:name, :surname, :birthDate, :login, :weight);";

        MapSqlParameterSource params = generateUserParamsMap(entity);
        namedParameterJdbcTemplate.update(createQuery, params);
    }

//    @Override
//    public void save(List<User> entities) {
//        for (User entity : entities) {
//            addOne(entity);
//        }
//    }

//    private MapSqlParameterSource generateUserParamsMap(User entity) {
//        MapSqlParameterSource params = new MapSqlParameterSource();
//        params.addValue("name", entity.getName());
//        params.addValue("surname", entity.getSurname());
//        params.addValue("birthDate", entity.getBirthDate());
//        params.addValue("login", entity.getLogin());
//        params.addValue("weight", entity.getWeight());
//
//        return params;
//    }

//    @Override
//    public User update(User entity) {
//        return null;
//    }
//
//    @Override
//    public void delete(Long id) {
//
//    }

    //Specification
    //Criteria API
    //Search Criteria object
    //like '%query%' and like '%query%' and like '%query%'
    //ElasticSearch
    //PostgresFTS
//    @Override
//    public List<User> findUsersByQuery(String query) {
//        return null;
//    }

//    @Override
//    public Double getUserExpensiveCarPrice(Integer userId) {
//        return null;
//    }

    @Override
    public void batchInsert(List<User> users) {
        final String createQuery = "insert into users (name, surname, birth_date, login, weight) " +
                "values (:name, :surname, :birthDate, :login, :weight);";

        List<MapSqlParameterSource> batchParams = new ArrayList<>();

        for (User user : users) {
            batchParams.add(generateUserParamsMap(user));
        }

        namedParameterJdbcTemplate.batchUpdate(createQuery, batchParams.toArray(new MapSqlParameterSource[0]));

    }
}


