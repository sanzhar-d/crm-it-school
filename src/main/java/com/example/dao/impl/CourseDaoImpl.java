package com.example.dao.impl;

import com.example.dao.CourseDao;
import com.example.models.Course;
import com.example.models.CourseFormat;
import com.example.utils.Log;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

    public CourseDaoImpl(){
        Connection connection = null;
        Statement statement = null;

        try {
            Log.info(this.getClass().getSimpleName(), Connection.class.getSimpleName(), " establishing connection");
            connection = getConnection();
            Log.info(this.getClass().getSimpleName(), connection.getClass().getSimpleName(), " connection established");

            String ddlQuery = "CREATE TABLE IF NOT EXISTS tb_course(" +
                    "id                 BIGSERIAL, " +
                    "name             VARCHAR(50)  NOT NULL, " +
                    "price REAL NOT NULL, " +
                    "format_id    INTEGER        NOT NULL, " +
                    "CONSTRAINT pk_course_id PRIMARY KEY(id))";

            Log.info(this.getClass().getSimpleName(), Statement.class.getSimpleName(), " creating statement...");
            statement = connection.createStatement();
            Log.info(this.getClass().getSimpleName(), Statement.class.getSimpleName(), " executing create table statement...");
            statement.execute(ddlQuery);

        } catch (SQLException e) {
            Log.error(this.getClass().getSimpleName(), e.getStackTrace()[0].getClass().getSimpleName(), e.getMessage());
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
    }

    CourseFormatDaoImpl courseFormatDao = new CourseFormatDaoImpl();

    @Override
    public Course save(Course course) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Course savedCourse = null;

        try {
            Log.info(this.getClass().getSimpleName(), Connection.class.getSimpleName(), " connecting to database...");
            connection = getConnection();
            Log.info(this.getClass().getSimpleName(), Connection.class.getSimpleName(), " connection succeeded.");

            String createQuery = "INSERT INTO tb_course(" +
                    "name, price, format_id) " +

                    "VALUES(?, ?, ?)";

            preparedStatement = connection.prepareStatement(createQuery);
            preparedStatement.setString(1, course.getName());
            preparedStatement.setDouble(2, course.getPrice());
            preparedStatement.setLong(3, course.getCourseFormat().getId());

            preparedStatement.execute();
            close(preparedStatement);

            String readQuery = "SELECT * FROM tb_course ORDER BY id DESC LIMIT 1";

            preparedStatement = connection.prepareStatement(readQuery);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            savedCourse = new Course();
            savedCourse.setName(resultSet.getString("name"));
            savedCourse.setPrice(resultSet.getDouble("price"));
            savedCourse.setId(resultSet.getLong("id"));
            Long courseFormatId = resultSet.getLong("format_id");
            //CourseFormatDaoImpl courseFormatDao = new CourseFormatDaoImpl();
            CourseFormat courseFormat = courseFormatDao.findById(courseFormatId);
            savedCourse.setCourseFormat(courseFormat);

        } catch (SQLException e) {
            Log.error(this.getClass().getSimpleName(), e.getStackTrace()[0].getClass().getSimpleName(), e.getMessage());
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }


        return savedCourse;
    }

    @Override
    public Course findById(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Course course = null;

        try {
            Log.info(this.getClass().getSimpleName(), Connection.class.getSimpleName(), " connecting to database...");
            connection = getConnection();
            Log.info(this.getClass().getSimpleName(), Connection.class.getSimpleName(), " connection succeeded.");

            String readQuery = "SELECT * FROM tb_course WHERE id = ?";

            preparedStatement = connection.prepareStatement(readQuery);
            preparedStatement.setLong(1, id);

            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            course = new Course();
            course.setName(resultSet.getString("name"));
            course.setPrice(resultSet.getDouble("price"));
            course.setId(resultSet.getLong("id"));
            Long courseFormatId = resultSet.getLong("format_id");
            //CourseFormatDaoImpl courseFormatDao = new CourseFormatDaoImpl();
            CourseFormat courseFormat = courseFormatDao.findById(courseFormatId);
            course.setCourseFormat(courseFormat);


        } catch (SQLException e) {
            Log.error(this.getClass().getSimpleName(), e.getStackTrace()[0].getClass().getSimpleName(), e.getMessage());
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
        return course;    }

    @Override
    public List<Course> getAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Course> courseList = new ArrayList<>();

        try {
            Log.info(this.getClass().getSimpleName(), Connection.class.getSimpleName(), " connecting to database...");
            connection = getConnection();
            Log.info(this.getClass().getSimpleName(), Connection.class.getSimpleName(), " connection succeeded.");

            String readQuery = "SELECT * FROM tb_course";

            preparedStatement = connection.prepareStatement(readQuery);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Course course = new Course();
                course.setName(resultSet.getString("name"));
                course.setPrice(resultSet.getDouble("price"));
                course.setId(resultSet.getLong("id"));
                Long courseFormatId = resultSet.getLong("format_id");
               // CourseFormatDaoImpl courseFormatDao = new CourseFormatDaoImpl();
                CourseFormat courseFormat = courseFormatDao.findById(courseFormatId);
                course.setCourseFormat(courseFormat);

                courseList.add(course);

            }
        } catch (SQLException e) {
            Log.error(this.getClass().getSimpleName(), e.getStackTrace()[0].getClass().getSimpleName(), e.getMessage());
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
        return courseList;
    }

    @Override
    public Course update(Course course) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Course updatedCourse = null;

        try {
            Log.info(this.getClass().getSimpleName(), Connection.class.getSimpleName(), " connecting to database...");
            connection = getConnection();
            Log.info(this.getClass().getSimpleName(), Connection.class.getSimpleName(), " connection succeeded.");

            String createQuery = "UPDATE tb_course SET " +
                    "name = ?, price = ?, format_id = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(createQuery);
            preparedStatement.setString(1, course.getName());
            preparedStatement.setDouble(2, course.getPrice());
            preparedStatement.setLong(3, course.getCourseFormat().getId());
            preparedStatement.setLong(4, course.getId());

            preparedStatement.execute();
            close(preparedStatement);

            String readQuery = "SELECT * FROM tb_course where id = ?";

            preparedStatement = connection.prepareStatement(readQuery);
            preparedStatement.setLong(1, course.getId());
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {

                updatedCourse.setName(resultSet.getString("name"));
                updatedCourse.setPrice(resultSet.getDouble("price"));
                updatedCourse.setId(resultSet.getLong("id"));
                Long courseFormatId = resultSet.getLong("format_id");
                //CourseFormatDaoImpl courseFormatDao = new CourseFormatDaoImpl();
                CourseFormat courseFormat = courseFormatDao.findById(courseFormatId);
                updatedCourse.setCourseFormat(courseFormat);

            }

        } catch (SQLException e) {
            Log.error(this.getClass().getSimpleName(), e.getStackTrace()[0].getClass().getSimpleName(), e.getMessage());
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
        return updatedCourse;    }

    private void close(AutoCloseable closeable) {
        try {
            Log.info(this.getClass().getSimpleName(), closeable.getClass().getSimpleName(), " closing...");
            closeable.close();
            Log.info(this.getClass().getSimpleName(), closeable.getClass().getSimpleName(), " closed...");
        } catch (Exception e) {
            Log.error(this.getClass().getSimpleName(), e.getStackTrace()[0].getClass().getSimpleName(), e.getMessage());
            e.printStackTrace();
        }
    }
}
