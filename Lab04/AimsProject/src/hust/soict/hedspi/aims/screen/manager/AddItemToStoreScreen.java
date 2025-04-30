package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;

    protected JTextField tfTitle = new JTextField(30);
    protected JTextField tfCategory = new JTextField(30);
    protected JTextField tfCost = new JTextField(10);

    public AddItemToStoreScreen(Store store) {
        this.store = store;

        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(tfTitle);
        inputPanel.add(new JLabel("Category:"));
        inputPanel.add(tfCategory);
        inputPanel.add(new JLabel("Cost:"));
        inputPanel.add(tfCost);

        JButton btnAdd = new JButton("Add to Store");
        btnAdd.addActionListener(e -> addItem());

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(inputPanel, BorderLayout.CENTER);
        cp.add(btnAdd, BorderLayout.SOUTH);

        setTitle("Add Item");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    protected abstract void addItem(); 
}
