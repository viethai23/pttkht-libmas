package com.example.libraryonline.DAO.FineDAO;

import com.example.libraryonline.DTO.FineResponse;
import com.example.libraryonline.Model.Borrow.Borrow;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class FineDAOImpl implements FineDAO {
    @Override
    public FineResponse calculateCost(Borrow borrow) {
        LocalDateTime localDateTime = LocalDateTime.now();
        Date curentTime = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        if(curentTime.after(borrow.getDue())) {
            long millisecondsDiff = Math.abs(curentTime.getTime() - borrow.getDue().getTime());
            long daysBetween = millisecondsDiff / (24 * 60 * 60 * 1000);
            FineResponse fine = new FineResponse();
            fine.setContent("Return late");
            fine.setAmount(daysBetween * 1000);
            return fine;
        }
        FineResponse fine = new FineResponse();
        fine.setContent("");
        fine.setAmount(0);
        return fine;
    }
}
