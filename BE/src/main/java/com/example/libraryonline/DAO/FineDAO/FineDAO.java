package com.example.libraryonline.DAO.FineDAO;

import com.example.libraryonline.DTO.FineResponse;
import com.example.libraryonline.Model.Borrow.Borrow;

public interface FineDAO {
    FineResponse calculateCost(Borrow borrow);
}
