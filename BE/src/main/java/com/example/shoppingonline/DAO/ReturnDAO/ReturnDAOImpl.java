package com.example.shoppingonline.DAO.ReturnDAO;

import com.example.shoppingonline.Model.Borrow.*;
import com.example.shoppingonline.Model.User.Reader;
import com.example.shoppingonline.Repository.ReturnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class ReturnDAOImpl implements ReturnDAO{
    @Autowired
    private ReturnRepository returnRepository;

    @Override
    public Return confirmReturn(Return returnn) {
        LocalDateTime localDateTime = LocalDateTime.now();
        Date curentTime = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        returnn.setReturnDate(curentTime);
        return returnRepository.save(returnn);
    }

    @Override
    public List<Return> getReaderReturn(Reader reader) {
        return returnRepository.findByReader(reader);
    }

    private Return getReturn(int returnId) {
        return returnRepository.findById(returnId).orElse(null);
    }

    @Override
    public Borrow getBorrow(int returnId) {
        return getReturn(returnId).getBorrow();
    }

    @Override
    public Shipping getShipping(int returnId) {
        return getReturn(returnId).getShipping();
    }

    @Override
    public Payment getPayment(int returnId) {
        return getReturn(returnId).getPayment();
    }

    @Override
    public Reader getReader(int returnId) {
        return getReturn(returnId).getReader();
    }

    @Override
    public Fine getFine(int returnId) {
        return getReturn(returnId).getFine();
    }
}
