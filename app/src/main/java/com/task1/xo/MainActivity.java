package com.task1.xo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button clickedButton;
    ArrayList<String> boardState;
    ConstraintLayout myRootElement;
    TextView winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRootElement = findViewById(R.id.rootElement);
        winner = findViewById(R.id.winner);
        initBoard();

    }

    int counterToDefineX_or_O_Play = 0;
    String sympolOfPlayer = "";

    public void playerClikedButton(View view) {

        clickedButton = ((Button) view);

        if (clickedButton.getText().toString().isEmpty()) {

            //X Play
            if (counterToDefineX_or_O_Play % 2 == 0) {
                clickedButton.setText("X");
                sympolOfPlayer = "X";
            }

            //O Play
            else {
                clickedButton.setText("O");
                sympolOfPlayer = "O";
            }
            counterToDefineX_or_O_Play++;
            stateOfButton(clickedButton.getId(), sympolOfPlayer);

            if (checkWinner("X")) {

                winner.setText("X Win!!!");
                counterToDefineX_or_O_Play = 0;
                initBoard();
            }

            if (checkWinner("O")) {

                winner.setText("O Win!!!");
                counterToDefineX_or_O_Play = 0;
                initBoard();
            } else if (counterToDefineX_or_O_Play == 9) {
                winner.setText("Draw");
                counterToDefineX_or_O_Play = 0;
                initBoard();
            }

        } else {
            return;
        }

    }

    public void initBoard() {

        boardState = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            boardState.add("");
        }

        for (int i = 0; i < myRootElement.getChildCount(); i++) {

            View view = myRootElement.getChildAt(i);

            if (view instanceof Button) {
                ((Button) view).setText("");
            }
        }

    }

    public void stateOfButton(int id, String sympol) {

        if (id == R.id.button1) {
            boardState.set(0, sympol);
        } else if (id == R.id.button2) {
            boardState.set(1, sympol);
        } else if (id == R.id.button3) {
            boardState.set(2, sympol);
        } else if (id == R.id.button4) {
            boardState.set(3, sympol);
        } else if (id == R.id.button5) {
            boardState.set(4, sympol);
        } else if (id == R.id.button6) {
            boardState.set(5, sympol);
        } else if (id == R.id.button7) {
            boardState.set(6, sympol);
        } else if (id == R.id.button8) {
            boardState.set(7, sympol);
        } else if (id == R.id.button9) {
            boardState.set(8, sympol);
        }

    }

    public boolean checkWinner(String sympol) {


        //Check Rows
        for (int i = 0; i < 9; i += 3) {

            if (boardState.get(i).equals(sympol) &&
                    boardState.get(i + 1).equals(sympol) &&
                    boardState.get(i + 2).equals(sympol)) {
                return true;
            }
        }

        //Check Columns
        for (int i = 0; i < 3; i += 1) {

            if (boardState.get(i).equals(sympol) &&
                    boardState.get(i + 3).equals(sympol) &&
                    boardState.get(i + 6).equals(sympol)) {
                return true;
            }
        }

        //Check diagonals
        if (boardState.get(0).equals(sympol) &&
                boardState.get(4).equals(sympol) &&
                boardState.get(8).equals(sympol)) {
            return true;
        }
        //Check diagonals
        if (boardState.get(2).equals(sympol) &&
                boardState.get(4).equals(sympol) &&
                boardState.get(6).equals(sympol)) {
            return true;
        }

        return false;
    }


}