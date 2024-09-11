package com.lgdx.chooroom.controller.user.index;

import com.lgdx.chooroom.domain.reservation.Reservation;
import com.lgdx.chooroom.domain.room.Rooms;
import com.lgdx.chooroom.repository.user.ReservationRepository;
import com.lgdx.chooroom.repository.user.RoomsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserIndexViewController {
    @GetMapping("/")
    public String userIndex() {
        return "user/userRoomInfo";
    }


}
