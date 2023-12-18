package com.example.libraryonline.DAO.ReturnDAO;

import com.example.libraryonline.Model.Borrow.*;
import com.example.libraryonline.Model.User.Reader;

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
