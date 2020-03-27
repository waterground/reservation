package com.sjh.web.reservation.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sjh.web.reservation.dto.ReservationDto;

@Repository
public class ReservationDao implements IReservationDao {
	private static final String NAMESPACE = "com.sjh.web.mappers.reservation.ReservationMapper";

	private final SqlSession sqlSession;
	
	@Inject
	public ReservationDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void insertReservation(final ReservationDto reservation){
		sqlSession.insert(NAMESPACE + ".insert", reservation);
	}
	
	@Override
	public ReservationDto selectReservation(final int id){
		return sqlSession.selectOne(NAMESPACE + ".select", id);
	}
	
	@Override
	public void updateReservation(final ReservationDto reservation){
		sqlSession.update(NAMESPACE + ".update", reservation);
	}
	
	@Override
	public void deleteReservation(final int id) {
		sqlSession.delete(NAMESPACE + ".delete", id);
	}
	
	@Override
	public List<ReservationDto> listUpReservation(ReservationDto reservation){
		return sqlSession.selectList(NAMESPACE + ".listUp", reservation);
	}
}
