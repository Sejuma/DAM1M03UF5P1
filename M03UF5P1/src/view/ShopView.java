package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import main.Shop;
import model.Product;
import utils.Constants;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

public class ShopView extends JFrame implements ActionListener, KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JButton showCash;
    private JButton addProduct;
    private JButton addStock;
    private JButton viewInventory;
    private JButton deleteProduct;
    ArrayList<Product> inventory;

	/**
	 * Create the frame.
	 */
	public ShopView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel textTitle = new JLabel("Seleccione o pulse una opcion:");
		textTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textTitle.setBounds(117, 32, 193, 17);
		contentPane.add(textTitle);
		
		showCash = new JButton("1. CONTAR CAJA");
		showCash.addActionListener(this);
		showCash.setBounds(135, 73, 147, 23);
		showCash.setBackground(new Color(255, 255, 255));
		contentPane.add(showCash);
		
		addProduct = new JButton("2. AÑADIR PRODUCTO");
		addProduct.setBackground(new Color(255, 255, 255));
		addProduct.setBounds(135, 109, 147, 23);
		contentPane.add(addProduct);
		
		addStock = new JButton("3. AÑADIR STOCK");
		addStock.setBackground(new Color(255, 255, 255));
		addStock.setBounds(135, 143, 147, 23);
		contentPane.add(addStock);
		
		viewInventory = new JButton("5. VER INVENTARIO");
		viewInventory.setBackground(new Color(255, 255, 255));
		viewInventory.setBounds(135, 177, 147, 23);
		contentPane.add(viewInventory);
		
		deleteProduct = new JButton("9. ELIMINAR PRODUCTO");
		deleteProduct.setBackground(new Color(255, 255, 255));
		deleteProduct.setBounds(135, 211, 147, 23);
		contentPane.add(deleteProduct);
			
		showCash.addActionListener(this);
		addProduct.addActionListener(this);
		addStock.addActionListener(this);
		viewInventory.addActionListener(this);
		deleteProduct.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
    	Shop shop = new Shop();
        
    	try {
			inventory = shop.loadInventory();
		} catch (IOException e1) {
			
		}
		
		if (e.getSource() == showCash) {
			
			shop.openCashView(shop);
		} 
		if (e.getSource() == addProduct) {
			int option = Constants.OPTION_ADD_PRODUCT;
			shop.openProductView(shop, option);
		} 
		
		if (e.getSource() == addStock) {
			int option = Constants.OPTION_ADD_STOCK;
			shop.openProductView(shop, option);
		}
		
		if (e.getSource() == viewInventory) {
			shop.openInventoryView(shop);
		}
		
		if (e.getSource() == deleteProduct) {
			int option = Constants.OPTION_REMOVE_PRODUCT;
			shop.openProductView(shop, option);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}