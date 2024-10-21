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
                        buttons[i].setForeground(new Color(75,100,75));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn!");
                        check();
                    }
                }
                else {
                    if (buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(255,50,50));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X turn!");
                        check();
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

    //Check if O / X wins
    public void check() {
        //Check if O wins
        if (
                        (buttons[0].getText() == "O") &&
                        (buttons[1].getText() == "O") &&
                        (buttons[2].getText() == "O")
        ) {
            oWinner(0, 1, 2);

        }
        if (
                        (buttons[3].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[5].getText() == "O")
        ) {
            oWinner(3, 4, 5);
        }
        if (
                        (buttons[6].getText() == "O") &&
                        (buttons[7].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWinner(6, 7, 8);

        }
        if (
                        (buttons[0].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWinner(0, 4, 8);

        }
        if (
                        (buttons[0].getText() == "O")&&
                        (buttons[3].getText() == "O")&&
                        (buttons[6].getText() == "O")
        ) {
            oWinner(0, 3, 6);
        }
        if (
                        (buttons[1].getText() == "O")&&
                        (buttons[4].getText() == "O")&&
                        (buttons[7].getText() == "O")
        ) {
            oWinner(1, 4, 7);
        }
        if (
                        (buttons[2].getText() == "O")&&
                        (buttons[4].getText() == "O")&&
                        (buttons[6].getText() == "O")
        ) {
            oWinner(2, 4, 6);
        }
        if (
                        (buttons[2].getText() == "O")&&
                        (buttons[5].getText() == "O")&&
                        (buttons[8].getText() == "O")
        ) {
            oWinner(2, 5, 8);
        }

        //------------------------------
        //Check if X wins
        if (
                        (buttons[0].getText() == "X") &&
                        (buttons[1].getText() == "X") &&
                        (buttons[2].getText() == "X")
        ) {
            xWinner(0, 1, 2);

        }
        if (
                        (buttons[3].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[5].getText() == "X")
        ) {
            xWinner(3, 4, 5);
        }
        if (
                        (buttons[6].getText() == "X") &&
                        (buttons[7].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWinner(6, 7, 8);

        }
        if (
                        (buttons[0].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWinner(0, 4, 8);

        }
        if (
                        (buttons[0].getText() == "X")&&
                        (buttons[3].getText() == "X")&&
                        (buttons[6].getText() == "X")
        ) {
            xWinner(0, 3, 6);
        }
        if (
                        (buttons[1].getText() == "X")&&
                        (buttons[4].getText() == "X")&&
                        (buttons[7].getText() == "X")
        ) {
            xWinner(1, 4, 7);
        }
        if (
                        (buttons[2].getText() == "X")&&
                        (buttons[4].getText() == "X")&&
                        (buttons[6].getText() == "X")
        ) {
            xWinner(2, 4, 6);
        }
        if (
                        (buttons[2].getText() == "X")&&
                        (buttons[5].getText() == "X")&&
                        (buttons[8].getText() == "X")
        ) {
            xWinner(2, 5, 8);
        }
        else {
            textfield.setText("Draw, No winners :(");

        }
    }

    //X winner
    public void xWinner(int a, int b, int c){

        buttons[a].setBackground(Color.CYAN);
        buttons[b].setBackground(Color.CYAN);
        buttons[c].setBackground(Color.CYAN);

        for (int i = 0;i < 9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("X is the winner!");
    }

    //O winner
    public void oWinner(int a, int b, int c) {

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0;i < 9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("O is the winner!");
    }



}
