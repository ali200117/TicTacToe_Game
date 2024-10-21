package javaFiler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {
    //Choose who begins first randomly
    Random random = new Random();

    //Create a Jframe
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    //label to display a message if needede
    JLabel textfield = new JLabel();
    //9 buttons needed == 9 X-O boxes
    JButton[] buttons = new JButton[9];
    //true if player1 turn, else player2
    boolean player1_turn;

    //Constructor
    TicTacToe(){
        //exit to close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //size of frame
        frame.setSize(800,800);
        //Background
        frame.getContentPane().setBackground(new Color(70,70,70));
        //Organise components_position
        frame.setLayout(new BorderLayout());
        //make the border visible
        frame.setVisible(true);
        //--------------
        //Textfield'
        textfield.setBackground(new Color(30,30,30));
        textfield.setForeground(Color.green);
        textfield.setFont(new Font("Ink Free", Font.BOLD, 60));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);
        //-----
        //let the layout stick to north of the frame
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        //total of 9 buttons
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(180,180,180));

        for (int i = 0; i < 9; i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 100));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++){
            if (e.getSource() == buttons[i]){
                if (player1_turn){
                    if (buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(75,75,75));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn!");
                    }
                }
            }
        }

    }

    public void firstTurn(){
        //Little delay before showing turn
        try{
            Thread.sleep(2000);
            textfield.setText("This round starts with....");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //0 or 1, if  random ==0:
        if (random.nextInt(2) ==0){
            player1_turn = true;

            textfield.setText("X, Your turn!");
        }
        else {
            player1_turn = false;
            textfield.setText("O, Your turn!");
        }
    }

    public void check(){

    }

    //X winner
    public void xWinner(int a, int b, int c){

    }

    //O winner
    public void oWinner(int a, int b, int c) {

    }


}
