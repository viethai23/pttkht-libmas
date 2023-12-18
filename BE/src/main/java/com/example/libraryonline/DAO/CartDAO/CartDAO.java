package com.example.libraryonline.DAO.CartDAO;

import com.example.libraryonline.Model.Borrow.Cart;
import com.example.libraryonline.Model.Borrow.Item;

public interface CartDAO {

	Cart clearCart(int cartId);

	Cart addCartItem(int cartId, Item i);

	Cart removeCartItem(int cartId, int itemId);

	Cart getReaderCart(int readerId);

	Cart updateQuantity(int cartId, int itemId, int quantity);

	Cart createCart(int readerId);
}