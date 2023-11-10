package com.rgbmovie.service.impl;

import com.rgbmovie.dto.*;
import com.rgbmovie.model.ReservationModel;
import com.rgbmovie.model.ReservedSeatModel;
import com.rgbmovie.model.ScreeningModel;
import com.rgbmovie.repository.*;
import com.rgbmovie.service.ReservationService;
import com.rgbmovie.service.TheaterService;
import net.minidev.json.annotate.JsonIgnore;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ScreeningRepository screeningRepository;
	@Autowired
	private ReservedSeatRepository reservedSeatRepository;
	@Autowired
	private TheaterRepository theaterRepository;
	@Autowired
	private AuditoriumRepository auditoriumRepository;
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private SeatRepository seatRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ReservationModel checkExistIfNotCreateNew(int screening) {
		ReservationModel checkReservation = reservationRepository.checkExistOrNot(screening);
		if (checkReservation == null) {
			ReservationModel reservationModel = new ReservationModel();
			reservationModel.setScreening(screening);
			return reservationRepository.saveAndFlush(reservationModel);
		}
		return checkReservation;
	}

	@Override
	public ReservationModel update(ReservationModel reservationModel) {
		return reservationRepository.saveAndFlush(reservationModel);
	}

	@Override
	public List<ReservationModel> getAll() {
		return reservationRepository.findAll();
	}

    @Override
    public ReservationModel getById(int id) {
        return reservationRepository.getReferenceById(id);
    }


    @Override
    public List<Map<String, Object>> getAllByUser(int id, String action) {
        List<Map<String, Object>> finalList = new ArrayList<>();
        List<ReservationModel> reservationModelList = new ArrayList<>();
        Map<String, Object> result = new HashMap<>();
        if (action.equals("cart")) {
            reservationModelList = reservationRepository.findByUserNotPay(id);
            System.out.println(reservationModelList);
        }
        if (action.equals("history")) {
            reservationModelList = reservationRepository.findByUserHistory(id);
            System.out.println(reservationModelList);
        }

        if (!reservationModelList.isEmpty()) {
            for (ReservationModel reservationModel : reservationModelList) {
                List<String> seatName = new ArrayList<>();
                result.put("Reservation", reservationModel);
                ScreeningDTO screeningDTO = modelMapper.map(screeningRepository.getReferenceById(reservationModel.getScreening()), ScreeningDTO.class);
                result.put("Screening", screeningDTO);
                System.out.println("result 1 " + result);
                List<ReservedSeatDTO> reservedSeatModelList = reservedSeatRepository.findByReservation(reservationModel.getPk()).stream().map(m -> modelMapper.map(m, ReservedSeatDTO.class)).toList();
                for (ReservedSeatDTO reservedSeatModel : reservedSeatModelList) {
                    seatName.add(seatRepository.getReferenceById(reservedSeatModel.getSeat()).getSeatName());
                }
                System.out.println("result 2 " + result);
                result.put("Seat", seatName);
                result.put("Theater", modelMapper.map(theaterRepository.getReferenceById(screeningDTO.getTheater()), TheaterDTO.class));
                result.put("Auditorium", modelMapper.map(auditoriumRepository.getReferenceById(screeningDTO.getAuditorium()), AuditoriumDTO.class));
                result.put("Movie", modelMapper.map(movieRepository.getReferenceById(screeningDTO.getMovie()), MovieDTO.class));
                System.out.println("result 3 " + result);
                finalList.add(result);
            }
            return finalList;
        }
        return null;

	}

    @Override
    public Map<String, Object> getDetailByUserId(int id) {
        ReservationModel reservationModel = reservationRepository.getReferenceById(id);
        Map<String, Object> result = new HashMap<>();
        List<String> seatName = new ArrayList<>();
        result.put("Reservation", reservationModel);
        ScreeningDTO screeningDTO = modelMapper.map(screeningRepository.getReferenceById(reservationModel.getScreening()), ScreeningDTO.class);
        result.put("Screening", screeningDTO);
        List<ReservedSeatDTO> reservedSeatModelList = reservedSeatRepository.findByReservation(reservationModel.getPk()).stream().map(m -> modelMapper.map(m, ReservedSeatDTO.class)).toList();
        for (ReservedSeatDTO reservedSeatModel : reservedSeatModelList) {
            seatName.add(seatRepository.getReferenceById(reservedSeatModel.getSeat()).getSeatName());
        }
        result.put("Seat", seatName);
        result.put("Theater", modelMapper.map(theaterRepository.getReferenceById(screeningDTO.getTheater()), TheaterDTO.class));
        result.put("Auditorium", modelMapper.map(auditoriumRepository.getReferenceById(screeningDTO.getAuditorium()), AuditoriumDTO.class));
        result.put("Movie", modelMapper.map(movieRepository.getReferenceById(screeningDTO.getMovie()), MovieDTO.class));
        return result;
    }

	@Override
	public void deleteReservation(int id) {
		List<ReservedSeatModel> listSeat = reservedSeatRepository.findByReservation(id);
		for(ReservedSeatModel seat: listSeat) {
			reservedSeatRepository.deleteById(seat.getPk());
		}
		reservationRepository.deleteById(id);
	}
}
