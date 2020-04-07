package com.sjh.web;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sjh.web.file.dto.FileDto;
import com.sjh.web.review.dao.ReviewDao;
import com.sjh.web.review.dto.ReviewDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class test {

	@Inject
	private SqlSessionFactory sqlFactory;

	@Test
	public void testFactory() {
		System.out.println("===== sql session factory check start =====");
		System.out.println(sqlFactory);
		System.out.println("===== sql session factory check end =====");
	}

	@Test
	public void testSession() throws Exception {

		try (SqlSession session1 = sqlFactory.openSession(); SqlSession session2 = sqlFactory.openSession();) {

			System.out.println("===== mybatis sql session test start =====");
			System.out.println(session1);
			System.out.println(session2);
			System.out.println("===== mybatis sql session test end =====");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * @Test public void testReview() throws Exception {
	 * 
	 * SqlSession sqlSession = sqlFactory.openSession(); try { ReviewDao dao = new
	 * ReviewDao(sqlSession);
	 * 
	 * ReviewDto c = new ReviewDto();
	 * 
	 * //c.setId(1); c.setMemberId("b"); // r.setPeople(9); //c.setProductId(2);
	 * //c.setContent("최고!"); //c.setScore(5); // r.setDate(new java.sql.Date(new
	 * java.util.Date().getTime()));
	 * 
	 * 
	 * dao.deleteReview(1); //List<ReviewDto> list = dao.listUpReview(c);
	 * //ReviewDto t = dao.selectReview(2); for (ReviewDto t : list) {
	 * System.out.println("id: " + t.getId()); System.out.println("member id: " +
	 * t.getMemberId()); System.out.println("product id: " + t.getProductId());
	 * System.out.println("date: " + t.getDate()); System.out.println("score: " +
	 * t.getScore()); System.out.println("content: " + t.getContent());
	 * 
	 * System.out.println("===================="); }
	 * 
	 * 
	 * //logger.info(sqlSession.getConfiguration().getMappedStatement("listUp").
	 * getSqlSource().getBoundSql("parameter").getSql());
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } }
	 */
	
	@Test 
	public void testReservation() throws Exception {
	  
	  SqlSession sqlSession = sqlFactory.openSession(); 
	  try { 
		  ReviewDao dao = new ReviewDao(sqlSession);
	  
	  ReviewDto r = new ReviewDto();
	  
	  List<FileDto> list = new ArrayList<FileDto>();
	  FileDto f1 = new FileDto();
	  FileDto f2 = new FileDto();
	  f1.setId(21);
	  f1.setName("14_rw_33.png");
	  list.add(f1);
	  f2.setId(22);
	  f2.setName("14_rw_44.png");
	  list.add(f2);
	  
	  r.setProductId(3);
	  r.setMemberId("bbbbbbb");
	  r.setRating(5);
	  r.setReservationId(14);
	  r.setContent("5점!!!");
	  r.setImgList(list);
	  
	  ReviewDto rr = dao.insertReview(r);
	 
	  System.out.println(rr.getId());
	  System.out.println(rr.getMemberId());
	  System.out.println(rr.getRating());
	  System.out.println(rr.getContent());
	  for(FileDto ff:rr.getImgList()) {
		  System.out.println("file : " + ff.getName());
	  }
	  
	  /*
	  ReviewDto cc = dao.insertReview(c);
	  
	  //c = dao.selectReview(22);
	  System.out.println(cc.getId());
	  System.out.println(cc.getContent());
	  System.out.println(cc.getMemberId());
	  System.out.println(cc.getProductId());
	  System.out.println(cc.getScore());
	  */
	  
	  } catch (Exception e) { e.printStackTrace(); } 
	}
/*
	@Test 
	public void testReservation() throws Exception {
	  
	  SqlSession sqlSession = sqlFactory.openSession(); 
	  try { 
		  ReviewDao dao = new ReviewDao(sqlSession);
	  
	  ReviewDto c = new ReviewDto();
	  c.setProductId(5);
	  c.setMemberId("a");
	  c.setRating(5);
	  c.setReservationId(22);
	  c.setContent("5점!!!");
	  
	  //c.setId(45);
	  dao.insertReview(c);
	  for (ReservationDto t : list) {
		  System.out.println("id: " + t.getId()); System.out.println("member id: " + t.getMemberId()); 
		  System.out.println("product id: " + t.getProductId());
		  System.out.println("create date: " + t.getCreateDate());
		  System.out.println("people: " + t.getPeople());
		  System.out.println("ing:" + t.getImg().getName() + t.getImg().getType());
		  System.out.println("hasReview : " + t.isHasReview());
		  System.out.println("===================="); 
		 }
	  
	  ReviewDto cc = dao.insertReview(c);
	  
	  //c = dao.selectReview(22);
	  System.out.println(cc.getId());
	  System.out.println(cc.getContent());
	  System.out.println(cc.getMemberId());
	  System.out.println(cc.getProductId());
	  System.out.println(cc.getScore());
	  
	  } catch (Exception e) { e.printStackTrace(); } 
	}
	*/
/*
	@Test 
	public void testReservation() throws Exception {
	  
	  SqlSession sqlSession = sqlFactory.openSession(); 
	  try { 
		  ReservationDao dao = new ReservationDao(sqlSession);
	  
	  ReservationDto r = new ReservationDto();
	  
	  // r.setId(1); 
	  r.setMemberId("a"); 
	  // r.setPeople(9); 
	  //r.setProductId(2); 
	  //r.setDate(new java.sql.Date(new java.util.Date().getTime()));
	  
	  //List<ReservationDto> list = dao.listUpReservation(r); // ReservationDto t =
	 // dao.selectReservation(3); 
	  for (ReservationDto t : list) {
	  System.out.println("id: " + t.getId()); System.out.println("member id: " + t.getMemberId()); 
	  System.out.println("product id: " + t.getProductId());
	  System.out.println("create date: " + t.getCreateDate());
	  System.out.println("people: " + t.getPeople());
	  System.out.println("ing:" + t.getImg().getName() + t.getImg().getType());
	  System.out.println("===================="); }
	dao.deleteReservation(1);  
	  } catch (Exception e) { e.printStackTrace(); } 
	  }
	  */
	/*
	 * @Test public void testProductDto() throws Exception { try { ProductDao dao =
	 * new ProductDao(sqlFactory.openSession()); List<PromotionDto> list =
	 * dao.listUpPromotion();
	 * 
	 * //System.out.println(dao.cntProduct("뮤지컬")); System.out.println(p.getId());
	 * System.out.println(p.getName()); System.out.println(p.getDescription());
	 * System.out.println(p.getAddress()); //
	 * System.out.println(p.getMainImg().getName()); //
	 * System.out.println(p.getMainImg().getType());
	 * 
	 * 
	 * //System.out.println("크기는 " + p.getImgList().size()); int cnt = 1; for
	 * (PromotionDto p : list) { System.out.println(p.getId());
	 * System.out.println(p.getProductId());
	 * System.out.println(p.getImg().getName());
	 * System.out.println("-------------"); for (FileDto f : p.getImgList()) {
	 * System.out.println(cnt + "번째"); System.out.println(f.getName());
	 * System.out.println(f.getType()); } }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } }
	 */
	/*
	 * @Test public void testMember() throws Exception { try { IMemberDao dao = new
	 * MemberDao(sqlFactory.openSession()); MemberDto mm = new MemberDto();
	 * mm.setId("a"); mm.setPw("a");
	 * 
	 * MemberDto m = dao.checkMember(mm);
	 * 
	 * if (m != null) { System.out.println(m.getId());
	 * System.out.println(m.getPw()); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } }
	 */
}
