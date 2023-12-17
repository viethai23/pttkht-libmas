package com.example.shoppingonline.DAO.CartDAO;

import com.example.shoppingonline.Model.Borrow.Cart;
import com.example.shoppingonline.Model.Borrow.Item;

import com.example.shoppingonline.Model.User.Reader;
import com.example.shoppingonline.Repository.CartRepository;
import com.example.shoppingonline.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartDAOImpl implements CartDAO {

	private CartRepository cartRepository;

	private ItemRepository itemRepository;

	public CartDAOImpl(CartRepository cartRepository, ItemRepository itemRepository) {
		this.cartRepository = cartRepository;
		this.itemRepository = itemRepository;
	}

	@Override
	public Cart clearCart(int cartId) {
		Cart cart = getCartById(cartId);
		if (cart != null) {
			cart.getItems().clear();
			cart.setTotalItem(0);
			cartRepository.save(cart);
			return cart;
		}
		return null;
	}

	@Override
	public Cart addCartItem(int cartId, Item item) {
		Cart cart = cartRepository.findById(cartId).orElse(null);
		Item itemExist = itemRepository.findByBook_IdAndCart_Id(item.getBook().getId(), cartId);

		if (cart != null && itemExist == null) {
			cart.getItems().add(item);
			cart.setTotalItem(cart.getTotalItem() + item.getQuantity());
			return cartRepository.save(cart);
		}
		else {
			return null;
		}

	}

	@Override
	public Cart removeCartItem(int cartId, int itemId) {
		Cart cart = cartRepository.findById(cartId).orElse(null);

		if (cart != null) {
			Item itemToRemove = cart.getItems().stream()
					.filter(item -> item.getId() == itemId)
					.findFirst()
					.orElse(null);

			if (itemToRemove != null) {

				cart.getItems().remove(itemToRemove);
				cart.setTotalItem(cart.getTotalItem() - itemToRemove.getQuantity());
				cartRepository.save(cart);
			}
		}
		return cart;

	}

	@Override
	public Cart getReaderCart(int readerId) {
		Cart cart = cartRepository.findByReader_IdAndStatus(readerId, "present");
		if(cart == null) {
			cart = createCart(readerId);
		}
		return cart;
	}

	@Override
	public Cart updateQuantity(int cartId, int itemId, int quantity) {
		Cart cart = cartRepository.findById(cartId).orElse(null);

		if (cart != null) {
			Item itemToUpdate = cart.getItems().stream()
					.filter(item -> item.getId() == itemId)
					.findFirst()
					.orElse(null);

			if (itemToUpdate != null) {
				cart.setTotalItem(cart.getTotalItem() + (quantity - itemToUpdate.getQuantity()));
				itemToUpdate.setQuantity(quantity);

				cartRepository.save(cart);
			}
		}

		return cart;
	}

	@Override
	public Cart createCart(int readerId) {
		Reader reader = new Reader();
		reader.setId(readerId);

		Cart cart = new Cart();
		cart.setReader(reader);
		cart.setStatus("present");

		return cartRepository.save(cart);
	}

	private Cart getCartById(int id) {
		return cartRepository.findById(id).orElse(null);
	}
}