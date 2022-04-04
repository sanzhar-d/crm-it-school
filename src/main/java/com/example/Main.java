package com.example;

import com.example.dao.CourseDao;
import com.example.dao.impl.CourseDaoImpl;
import com.example.dao.impl.CourseFormatDaoImpl;
import com.example.models.Branch;
import com.example.models.Course;
import com.example.models.CourseFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("test");

      CourseFormatDaoImpl courseFormatDao = new CourseFormatDaoImpl();
       CourseFormat courseFormat = new CourseFormat();
       courseFormat.setFormat("Regular");
       courseFormat.setOnline(true);
       courseFormat.setLessonsPerWeek(3);
       courseFormat.setLessonDuration(90);
       courseFormat.setDurationWeeks(28);
//       //сохранение объекта CourseFormat
//     CourseFormat courseFormatSaved = courseFormatDao.save(courseFormat);
//       //получение объекта по id
      CourseFormat fromDB = courseFormatDao.findById(2L);
//       fromDB.setLessonsPerWeek(3);
//       fromDB.setOnline(false);
//        //редактирование объекта
//       CourseFormat updatedCourseFormat = courseFormatDao.update(fromDB);
//        //получение списка
//       List<CourseFormat> findAll = courseFormatDao.getAll();
//      findAll.stream().forEach(x-> System.out.println("duration " + x.getLessonDuration()));


//        Branch branch = new Branch();
//        branch.setId(5L);
//        branch.setName("hjkjhghj");
//
//        Branch branch1 = new Branch(6L, "kjhjh", "766");
//        branch1.setAddress("fghgfghf");

//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            String json = objectMapper.writeValueAsString(fromDB);
//            System.out.println(json);
//            CourseFormat courseFormat = objectMapper.readValue(json, CourseFormat.class);
//
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }

        CourseDaoImpl courseDao = new CourseDaoImpl();
        Course course = new Course();
        course.setName("Java");
        course.setPrice(8000);
        course.setCourseFormat(fromDB);
        Course saved = courseDao.save(course);

        CourseFormat format = courseFormatDao.findById(1L);
        Course python = new Course();
        python.setName("Python");
        python.setPrice(9000);
        python.setCourseFormat(format);
        Course savedPython = courseDao.save(python);

    }
}
