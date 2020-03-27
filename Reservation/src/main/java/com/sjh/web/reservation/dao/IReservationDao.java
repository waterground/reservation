package com.sjh.web.reservation.dao;

import java.util.List;

import com.sjh.web.reservation.dto.ReservationDto;

public interface IReservationDao {

	void insertReservation(ReservationDto reservation);

	ReservationDto selectReservation(int id);

	void updateReservation(ReservationDto reservation);

	void deleteReservation(int id);

	List<ReservationDto> listUpReservation(ReservationDto reservation);

}