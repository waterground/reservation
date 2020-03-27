package com.sjh.web.reservation.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sjh.web.reservation.dao.IReservationDao;
import com.sjh.web.reservation.dto.ReservationDto;

@Service
public class ReservationService implements IReservationService {

	@Inject
	IReservationDao dao;
	
	@Override
	public void addReservation(ReservationDto r) {
		dao.insertReservation(r);
	}
	
	@Override
	public ReservationDto findReservation(int id) {
		return dao.selectReservation(id);
	}
	
	@Override
	public List<ReservationDto> listUpReservation(ReservationDto r){
		return dao.listUpReservation(r);
	}
	
	@Override
	public void updateReservation(ReservationDto r) {
		dao.updateReservation(r);
	}
	
	@Override
	public void removeReservation(int id) {
		dao.deleteReservation(id);
	}
}
