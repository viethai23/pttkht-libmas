package com.example.shoppingonline.DAO.ReturnDAO;

import com.example.shoppingonline.Model.Borrow.*;
import com.example.shoppingonline.Model.User.Reader;

import java.util.List;

public interface ReturnDAO {
    Return confirmReturn(Return returnn);
    List<Return> getReaderReturn(Reader reader);
    Borrow getBorrow(int returnId);
    Shipping getShipping(int returnId);
    Payment getPayment(int returnId);
    Reader getReader(int returnId);
    Fine getFine(int returnId);
}
