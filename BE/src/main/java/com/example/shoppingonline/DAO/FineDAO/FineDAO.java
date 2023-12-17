package com.example.shoppingonline.DAO.FineDAO;

import com.example.shoppingonline.DTO.FineResponse;
import com.example.shoppingonline.Model.Borrow.Borrow;

public interface FineDAO {
    FineResponse calculateCost(Borrow borrow);
}
