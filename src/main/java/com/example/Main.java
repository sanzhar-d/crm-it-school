package com.example;

import com.example.dao.impl.CourseFormatDaoImpl;
import com.example.models.CourseFormat;

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
//       CourseFormat courseFormatSaved = courseFormatDao.save(courseFormat);
//       //получение объекта по id
//        CourseFormat fromDB = courseFormatDao.findById(2L);
//        fromDB.setLessonsPerWeek(5);
//        //редактирование объекта
//        CourseFormat updatedCourseFormat = courseFormatDao.update(fromDB);
//        //получение списка
//        List<CourseFormat> findAll = courseFormatDao.getAll();
//        findAll.stream().forEach(x-> System.out.println(x.getFormat()));
    }
}
