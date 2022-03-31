package com.example.dao.impl;

import com.example.dao.CourseFormatDao;
import com.example.models.CourseFormat;
import com.example.utils.Log;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseFormatDaoImpl implements CourseFormatDao {

    public CourseFormatDaoImpl(){
        Connection connection = null;
        Statement statement = null;

        try {
            Log.info(this.getClass().getSimpleName(), Connection.class.getSimpleName(), " establishing connection");
            connection = getConnection();
            Log.info(this.getClass().getSimpleName(), connection.getClass().getSimpleName(), " connection established");

            String ddlQuery = "CREATE TABLE IF NOT EXISTS tb_course_format(" +
                    "id                 BIGSERIAL, " +
                    "format             VARCHAR(50)  NOT NULL, " +
                    "duration_weeks INTEGER NOT NULL, " +
                    "lesson_duration    INTEGER        NOT NULL, " +
                    "lessons_per_week    INTEGER         NOT NULL, " +
                    "is_online          BOOLEAN NOT NULL DEFAULT FALSE, " +
                    "" +
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
    };
    @Override
    public CourseFormat save(CourseFormat courseFormat) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        CourseFormat savedCourseFormat = null;

        try {
            Log.info(this.getClass().getSimpleName(), Connection.class.getSimpleName(), " connecting to database...");
            connection = getConnection();
            Log.info(this.getClass().getSimpleName(), Connection.class.getSimpleName(), " connection succeeded.");

            String createQuery = "INSERT INTO tb_course_format(" +
                    "format, duration_weeks, lesson_duration, lessons_per_week, is_online) " +

                    "VALUES(?, ?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(createQuery);
            preparedStatement.setString(1, courseFormat.getFormat());
            preparedStatement.setInt(2, courseFormat.getDurationWeeks());
            preparedStatement.setInt(3, courseFormat.getLessonDuration());
            preparedStatement.setInt(4, courseFormat.getLessonsPerWeek());
            preparedStatement.setBoolean(5, courseFormat.isOnline());

            preparedStatement.execute();
            close(preparedStatement);

            String readQuery = "SELECT * FROM tb_course_format ORDER BY id DESC LIMIT 1";

            preparedStatement = connection.prepareStatement(readQuery);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            savedCourseFormat = new CourseFormat();
            savedCourseFormat.setFormat(resultSet.getString("format"));
            savedCourseFormat.setDurationWeeks(resultSet.getInt("duration_weeks"));
            savedCourseFormat.setId(resultSet.getLong("id"));
            savedCourseFormat.setLessonDuration(resultSet.getInt("lesson_duration"));
            savedCourseFormat.setLessonsPerWeek(resultSet.getInt("lessons_per_week"));
            savedCourseFormat.setOnline(resultSet.getBoolean("is_online"));

        } catch (SQLException e) {
            Log.error(this.getClass().getSimpleName(), e.getStackTrace()[0].getClass().getSimpleName(), e.getMessage());
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }


        return savedCourseFormat;
    }

    @Override
    public CourseFormat findById(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        CourseFormat courseFormat = null;

        try {
            Log.info(this.getClass().getSimpleName(), Connection.class.getSimpleName(), " connecting to database...");
            connection = getConnection();
            Log.info(this.getClass().getSimpleName(), Connection.class.getSimpleName(), " connection succeeded.");

            String readQuery = "SELECT * FROM tb_course_format WHERE id = ?";

            preparedStatement = connection.prepareStatement(readQuery);
            preparedStatement.setLong(1, id);

            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            courseFormat = new CourseFormat();
            courseFormat.setFormat(resultSet.getString("format"));
            courseFormat.setDurationWeeks(resultSet.getInt("duration_weeks"));
            courseFormat.setId(resultSet.getLong("id"));
            courseFormat.setLessonDuration(resultSet.getInt("lesson_duration"));
            courseFormat.setLessonsPerWeek(resultSet.getInt("lessons_per_week"));
            courseFormat.setOnline(resultSet.getBoolean("is_online"));


        } catch (SQLException e) {
            Log.error(this.getClass().getSimpleName(), e.getStackTrace()[0].getClass().getSimpleName(), e.getMessage());
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
        return courseFormat;
    }

    @Override
    public List<CourseFormat> getAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<CourseFormat> courseFormatList = new ArrayList<>();

        try {
            Log.info(this.getClass().getSimpleName(), Connection.class.getSimpleName(), " connecting to database...");
            connection = getConnection();
            Log.info(this.getClass().getSimpleName(), Connection.class.getSimpleName(), " connection succeeded.");

            String readQuery = "SELECT * FROM tb_course_format";

            preparedStatement = connection.prepareStatement(readQuery);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                CourseFormat courseFormat = new CourseFormat();
                courseFormat.setFormat(resultSet.getString("format"));
                courseFormat.setDurationWeeks(resultSet.getInt("duration_weeks"));
                courseFormat.setId(resultSet.getLong("id"));
                courseFormat.setLessonDuration(resultSet.getInt("lesson_duration"));
                courseFormat.setLessonsPerWeek(resultSet.getInt("lessons_per_week"));
                courseFormat.setOnline(resultSet.getBoolean("is_online"));

                courseFormatList.add(courseFormat);

            }
        } catch (SQLException e) {
            Log.error(this.getClass().getSimpleName(), e.getStackTrace()[0].getClass().getSimpleName(), e.getMessage());
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
        return courseFormatList;
    }

    @Override
    public CourseFormat update(CourseFormat courseFormat) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        CourseFormat updatedCourseFormat = null;

        try {
            Log.info(this.getClass().getSimpleName(), Connection.class.getSimpleName(), " connecting to database...");
            connection = getConnection();
            Log.info(this.getClass().getSimpleName(), Connection.class.getSimpleName(), " connection succeeded.");

            String createQuery = "UPDATE tb_course_format SET " +
                    "format = ?, duration_weeks = ?, lesson_duration = ?, lessons_per_week = ?, is_online = ? WHERE id = ?";
            System.out.println(createQuery);
            preparedStatement = connection.prepareStatement(createQuery);
            preparedStatement.setString(1, courseFormat.getFormat());
            preparedStatement.setInt(2, courseFormat.getDurationWeeks());
            preparedStatement.setInt(3, courseFormat.getLessonDuration());
            preparedStatement.setInt(4, courseFormat.getLessonsPerWeek());
            preparedStatement.setBoolean(5, courseFormat.isOnline());
            preparedStatement.setLong(6, courseFormat.getId());

            System.out.println(preparedStatement.toString());

            preparedStatement.execute();
            close(preparedStatement);

            String readQuery = "SELECT * FROM tb_course_format ORDER BY id DESC LIMIT 1";

            preparedStatement = connection.prepareStatement(readQuery);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {

                updatedCourseFormat = new CourseFormat();
                updatedCourseFormat.setFormat(resultSet.getString("format"));
                updatedCourseFormat.setDurationWeeks(resultSet.getInt("duration_weeks"));
                updatedCourseFormat.setId(resultSet.getLong("id"));
                updatedCourseFormat.setLessonDuration(resultSet.getInt("lesson_duration"));
                updatedCourseFormat.setLessonsPerWeek(resultSet.getInt("lessons_per_week"));
                updatedCourseFormat.setOnline(resultSet.getBoolean("is_online"));

            }

        } catch (SQLException e) {
            Log.error(this.getClass().getSimpleName(), e.getStackTrace()[0].getClass().getSimpleName(), e.getMessage());
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
        return updatedCourseFormat;
    }

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
