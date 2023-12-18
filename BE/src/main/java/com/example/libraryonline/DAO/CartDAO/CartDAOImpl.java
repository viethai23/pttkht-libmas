package com.example.libraryonline.DAO.CartDAO;

import com.example.libraryonline.Model.Book.Book;
import com.example.libraryonline.Model.Borrow.Cart;
import com.example.libraryonline.Model.Borrow.Item;

import com.example.libraryonline.Model.User.Reader;
import com.example.libraryonline.Repository.CartRepository;
import com.example.libraryonline.Repository.ItemRepository;
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
			cart.setTotal(0);
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
			Book book = item.getBook();
			int quantity = item.getQuantity();
			if(quantity > book.getStockQuantity() || quantity < 0) {
				return null;
			}
			double itemAmount = book.getFee() * quantity;

			item.setCart(cart);
			item.setAmount(itemAmount);

			cart.getItems().add(item);
			cart.setTotalItem(cart.getTotalItem() + 1);
			cart.setTotal(cart.getTotal() + itemAmount);
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

				double itemAmount = itemToRemove.getAmount();

				cart.getItems().remove(itemToRemove);
				cart.setTotalItem(cart.getTotalItem() - 1);
				cart.setTotal(cart.getTotal() - itemAmount);
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
				double originalItemAmount = itemToUpdate.getAmount();

				if(quantity > itemToUpdate.getBook().getStockQuantity() || quantity < 0) {
					return null;
				}

				itemToUpdate.setQuantity(quantity);
				itemToUpdate.setAmount(itemToUpdate.getBook().getFee() * quantity);

				double newItemAmount = itemToUpdate.getAmount();
				cart.setTotal(cart.getTotal() - originalItemAmount + newItemAmount);

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