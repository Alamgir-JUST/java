package com.Alamgir.SPEL.SEPLProject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/Alamgir/SEPL/beans/beans.xml");

		NoticeDao noticeDao = (NoticeDao) context.getBean("noticeDao");
		try {
			
///Batch Insertion/ Multiple row insertion
			
			Notice n1 = new Notice(4, "aaaaaaaa","aaaaaaa@gmail.com","aaaaaa aa a a");
			Notice n2 = new Notice(2, "bbbbbbbb","bbbb@gmail.com","bbbbbbb aa a a");
			Notice n3 = new Notice(3, "cccccc","cccccc@gmail.com","cccccc aa a a");
			Notice n4 = new Notice(6, "ddddddd","ddddddd@gmail.com","ddddddd aa a a");
			
			List<Notice> noticeList = new ArrayList<Notice>();
			noticeList.add(n1);
			noticeList.add(n2);
			noticeList.add(n3);
			noticeList.add(n4);
			
			noticeDao.insertListNotices(noticeList);
			
			System.out.println("Deleting id: 10");
			///noticeDao.delete(10);
			
			///Now inserting into database
			
			Notice noticeAdd = new Notice("AlamgirCCSE","Just@gmail.com", "In Jashore");
			///noticeDao.insertNotices(noticeAdd);
			
			///Update query
			Notice noticeUpdate = new Notice(9,"xxxxx","xxxxxxx@gmail.com","xxx xx x x--");
			noticeDao.updateNotices(noticeUpdate);
			
			List<Notice> notices = noticeDao.getNotices();
			
			for (Notice notice : notices) {
				System.out.println(notice);

			}
			System.out.println("Single value from database: ");

			Notice notice1 = noticeDao.getNotice(3);
			System.out.println(notice1);
			
			
			
			
		} catch (CannotGetJdbcConnectionException e) {
			System.out.println(e.getMessage());
			System.out.println("Could not get JDBC Connection");

		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass());
		}

		((ClassPathXmlApplicationContext) context).close();
	}
}
