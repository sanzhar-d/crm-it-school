package com.example;

import com.example.dao.CourseDao;
import com.example.dao.impl.CourseDaoImpl;
import com.example.dao.impl.CourseFormatDaoImpl;
import com.example.models.Branch;
import com.example.models.Course;
import com.example.models.CourseFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import okhttp3.*;


import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("test");

      CourseFormatDaoImpl courseFormatDao = new CourseFormatDaoImpl();
//       CourseFormat courseFormat = new CourseFormat();
//       courseFormat.setFormat("Regular");
//       courseFormat.setOnline(true);
//       courseFormat.setLessonsPerWeek(3);
//       courseFormat.setLessonDuration(90);
//       courseFormat.setDurationWeeks(28);
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

        CourseDaoImpl courseDao = new CourseDaoImpl();

        Course course = courseDao.findById(1L);

//        ObjectMapper objectMapper = new ObjectMapper();
//        Gson gson = new Gson();

//        try {
//            String json = objectMapper.writeValueAsString(course);
//            System.out.println(json);
//            Course course1 = objectMapper.readValue(json, Course.class);
//            System.out.println();
//
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }

//        String json  = gson.toJson(course);
//        System.out.println(json);
//        Course course1 = gson.fromJson(json, Course.class);


//        Course course = new Course();
//        course.setName("Java");
//        course.setPrice(8000);
//        course.setCourseFormat(fromDB);
//        Course saved = courseDao.save(course);
//
//       CourseFormat format = courseFormatDao.findById(1L);
//        Course python = new Course();
//        python.setName("Python");
//        python.setPrice(9000);
//        python.setCourseFormat(format);
//        Course savedPython = courseDao.save(python);

        String url = "http://localhost:8080/v1/home/page";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
