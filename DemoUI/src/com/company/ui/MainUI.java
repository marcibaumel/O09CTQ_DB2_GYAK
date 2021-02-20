package com.company.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class MainUI {
    private JPanel rootPanel;
    private JTable showTable;
    private JComboBox genreCombo;
    private JComboBox typeCombo;
    private JTextField minVotesField;
    private JButton episodeButton;
    private JButton imdbButton;


    public MainUI(){
        createTable();
        creareGenreCombo();
        createTypeCombo();
    }

    private void  creareGenreCombo(){
        genreCombo.setModel(new DefaultComboBoxModel(new String[]{"Action", "Fantasy"}));
    }

    private void createTypeCombo(){
        typeCombo.setModel(new DefaultComboBoxModel(new String[]{"Movie", "TvSeries", "Short"}));
    }

    public JPanel getRootPanel(){
        return rootPanel;
    }

    public void createTable(){

        Object[][] data={
                {"The Dark Knight", 2008, 9.0, 1886938},
                {"Star Wars", 2001, 8.1, 1313},
                {"Inception", 1990, 10, 3131344}

        };

        showTable.setModel(new DefaultTableModel(
                data,
                new String[]{"Title", "Year", "Rating", "Num Votes"}
        ));
        TableColumnModel columns= showTable.getColumnModel();
        columns.getColumn(0).setMaxWidth(250);

        DefaultTableCellRenderer ceneterRender=new DefaultTableCellRenderer();
        ceneterRender.setHorizontalAlignment(JLabel.CENTER);
        columns.getColumn(1).setCellRenderer(ceneterRender);
        columns.getColumn(2).setCellRenderer(ceneterRender);
        columns.getColumn(3).setCellRenderer(ceneterRender);

    }
}
