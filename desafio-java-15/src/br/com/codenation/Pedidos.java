package br.com.codenation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.codenation.model.OrderItem;
import br.com.codenation.service.OrderService;
import br.com.codenation.service.OrderServiceImpl;

public class Pedidos {

	static OrderService orderService = new OrderServiceImpl();
	
	public static void main(String[] args) {
		List<OrderItem> items = new ArrayList<>();
		items.add(new OrderItem(1l, 3l));
		items.add(new OrderItem(2l, 2l));
		System.out.println(orderService.calculateOrderValue(items));
		
		System.out.println(orderService.findProductsById(Arrays.asList(1l, 2l, 3l, 4l, 5l)).size());
		
		List<OrderItem> items1 = new ArrayList<>();
		items1.add(new OrderItem(1l, 3l));
		items1.add(new OrderItem(2l, 2l));
		List<OrderItem> items2 = new ArrayList<>();
		items1.add(new OrderItem(1l, 3l));
		items1.add(new OrderItem(2l, 2l));
		List<OrderItem> items3 = new ArrayList<>();
		items1.add(new OrderItem(1l, 3l));
		items1.add(new OrderItem(2l, 2l));
		System.out.println(orderService.calculateMultipleOrders(Arrays.asList(items1, items2, items3)));
	}

}
