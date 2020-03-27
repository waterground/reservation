package com.sjh.web.reservation.service;

import java.util.List;

import com.sjh.web.reservation.dto.ReservationDto;

public interface IReservationService {

	void addReservation(ReservationDto r);

	ReservationDto findReservation(int id);

	List<ReservationDto> listUpReservation(ReservationDto r);

	void updateReservation(ReservationDto r);

	void removeReservation(int id);

}