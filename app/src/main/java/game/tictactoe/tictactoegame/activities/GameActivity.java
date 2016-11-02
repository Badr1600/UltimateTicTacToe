package game.tictactoe.tictactoegame.activities;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import game.tictactoe.tictactoegame.R;
import game.tictactoe.tictactoegame.engine.BoardMain;
import game.tictactoe.tictactoegame.engine.PointPosition;
import game.tictactoe.tictactoegame.utils.Turns;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView playerOneName;
    private TextView playerTwoName;
    private boolean doubleBackToExitPressedOnce = false;


    private TableLayout table1;
    private TableLayout table2;
    private TableLayout table3;
    private TableLayout table4;
    private TableLayout table5;
    private TableLayout table6;
    private TableLayout table7;
    private TableLayout table8;
    private TableLayout table9;

    private ImageButton[][] board1;
    private ImageButton[][] board2;
    private ImageButton[][] board3;
    private ImageButton[][] board4;
    private ImageButton[][] board5;
    private ImageButton[][] board6;
    private ImageButton[][] board7;
    private ImageButton[][] board8;
    private ImageButton[][] board9;


    private static int[][] BOARD1_BUTTONS = {{R.id.button101, R.id.button102, R.id.button103},
            {R.id.button104, R.id.button105, R.id.button106},
            {R.id.button107, R.id.button108, R.id.button109}};

    private static int[][] BOARD2_BUTTONS = {{R.id.button201, R.id.button202, R.id.button203},
            {R.id.button204, R.id.button205, R.id.button206},
            {R.id.button207, R.id.button208, R.id.button209}};

    private static int[][] BOARD3_BUTTONS = {{R.id.button301, R.id.button302, R.id.button303},
            {R.id.button304, R.id.button305, R.id.button306},
            {R.id.button307, R.id.button308, R.id.button309}};

    private static int[][] BOARD4_BUTTONS = {{R.id.button401, R.id.button402, R.id.button403},
            {R.id.button404, R.id.button405, R.id.button406},
            {R.id.button407, R.id.button408, R.id.button409}};

    private static int[][] BOARD5_BUTTONS = {{R.id.button501, R.id.button502, R.id.button503},
            {R.id.button504, R.id.button505, R.id.button506},
            {R.id.button507, R.id.button508, R.id.button509}};

    private static int[][] BOARD6_BUTTONS = {{R.id.button601, R.id.button602, R.id.button603},
            {R.id.button604, R.id.button605, R.id.button606},
            {R.id.button607, R.id.button608, R.id.button609}};

    private static int[][] BOARD7_BUTTONS = {{R.id.button701, R.id.button702, R.id.button703},
            {R.id.button704, R.id.button705, R.id.button706},
            {R.id.button707, R.id.button708, R.id.button709}};

    private static int[][] BOARD8_BUTTONS = {{R.id.button801, R.id.button802, R.id.button803},
            {R.id.button804, R.id.button805, R.id.button806},
            {R.id.button807, R.id.button808, R.id.button809}};

    private static int[][] BOARD9_BUTTONS = {{R.id.button901, R.id.button902, R.id.button903},
            {R.id.button904, R.id.button905, R.id.button906},
            {R.id.button907, R.id.button908, R.id.button909}};

    private BoardMain mainBoard;
    private PointPosition point;
    private boolean playerOneTurn;
    private boolean playerTwoTurn;
    private boolean gameOver;
    private boolean playerOneWins;
    private boolean playerTwoWins;

    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mainBoard = new BoardMain();
        playerOneTurn = true;
        playerTwoTurn = false;
        gameOver = false;
        playerOneWins = false;
        playerTwoWins = false;

        playerOneName = (TextView) findViewById(R.id.player1_name);
        playerTwoName = (TextView) findViewById(R.id.player2_name);
        Typeface font = Typeface.createFromAsset(getAssets(), "Chantelli_Antiqua.ttf");
        playerOneName.setTypeface(font);
        playerTwoName.setTypeface(font);

        builder = new AlertDialog.Builder(this);

        table1 = (TableLayout) findViewById(R.id.table1);
        table2 = (TableLayout) findViewById(R.id.table2);
        table3 = (TableLayout) findViewById(R.id.table3);
        table4 = (TableLayout) findViewById(R.id.table4);
        table5 = (TableLayout) findViewById(R.id.table5);
        table6 = (TableLayout) findViewById(R.id.table6);
        table7 = (TableLayout) findViewById(R.id.table7);
        table8 = (TableLayout) findViewById(R.id.table8);
        table9 = (TableLayout) findViewById(R.id.table9);

        board1 = new ImageButton[3][3];
        board2 = new ImageButton[3][3];
        board3 = new ImageButton[3][3];
        board4 = new ImageButton[3][3];
        board5 = new ImageButton[3][3];
        board6 = new ImageButton[3][3];
        board7 = new ImageButton[3][3];
        board8 = new ImageButton[3][3];
        board9 = new ImageButton[3][3];

        for (int i = 0; i < board1.length; i++) {
            for (int j = 0; j < board1[i].length; j++) {
                board1[i][j] = (ImageButton) findViewById(BOARD1_BUTTONS[i][j]);
                board1[i][j].setOnClickListener(this);
            }
        }
        for (int i = 0; i < board2.length; i++) {
            for (int j = 0; j < board2[i].length; j++) {
                board2[i][j] = (ImageButton) findViewById(BOARD2_BUTTONS[i][j]);
                board2[i][j].setOnClickListener(this);
            }
        }
        for (int i = 0; i < board3.length; i++) {
            for (int j = 0; j < board3[i].length; j++) {
                board3[i][j] = (ImageButton) findViewById(BOARD3_BUTTONS[i][j]);
                board3[i][j].setOnClickListener(this);
            }
        }
        for (int i = 0; i < board4.length; i++) {
            for (int j = 0; j < board4[i].length; j++) {
                board4[i][j] = (ImageButton) findViewById(BOARD4_BUTTONS[i][j]);
                board4[i][j].setOnClickListener(this);
            }
        }
        for (int i = 0; i < board5.length; i++) {
            for (int j = 0; j < board5[i].length; j++) {
                board5[i][j] = (ImageButton) findViewById(BOARD5_BUTTONS[i][j]);
                board5[i][j].setOnClickListener(this);
            }
        }
        for (int i = 0; i < board5.length; i++) {
            for (int j = 0; j < board5[i].length; j++) {
                board5[i][j] = (ImageButton) findViewById(BOARD5_BUTTONS[i][j]);
                board5[i][j].setOnClickListener(this);
            }
        }
        for (int i = 0; i < board6.length; i++) {
            for (int j = 0; j < board6[i].length; j++) {
                board6[i][j] = (ImageButton) findViewById(BOARD6_BUTTONS[i][j]);
                board6[i][j].setOnClickListener(this);
            }
        }
        for (int i = 0; i < board7.length; i++) {
            for (int j = 0; j < board7[i].length; j++) {
                board7[i][j] = (ImageButton) findViewById(BOARD7_BUTTONS[i][j]);
                board7[i][j].setOnClickListener(this);
            }
        }
        for (int i = 0; i < board8.length; i++) {
            for (int j = 0; j < board8[i].length; j++) {
                board8[i][j] = (ImageButton) findViewById(BOARD8_BUTTONS[i][j]);
                board8[i][j].setOnClickListener(this);
            }
        }

        for (int i = 0; i < board9.length; i++) {
            for (int j = 0; j < board9[i].length; j++) {
                board9[i][j] = (ImageButton) findViewById(BOARD9_BUTTONS[i][j]);
                board9[i][j].setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View v) {

        if (!gameOver) {
            if (v == board1[0][0]) {
                playAction(board1[0][0], 0, 0, 1);
            }
            if (v == board1[0][1]) {
                playAction(board1[0][1], 0, 1, 1);
            }
            if (v == board1[0][2]) {
                playAction(board1[0][2], 0, 2, 1);
            }
            if (v == board1[1][0]) {
                playAction(board1[1][0], 1, 0, 1);
            }
            if (v == board1[1][1]) {
                playAction(board1[1][1], 1, 1, 1);
            }
            if (v == board1[1][2]) {
                playAction(board1[1][2], 1, 2, 1);
            }
            if (v == board1[2][0]) {
                playAction(board1[2][0], 2, 0, 1);
            }
            if (v == board1[2][1]) {
                playAction(board1[2][1], 2, 1, 1);
            }
            if (v == board1[2][2]) {
                playAction(board1[2][2], 2, 2, 1);
            }
        /*--------------Board 2--------------*/
            if (v == board2[0][0]) {
                playAction(board2[0][0], 0, 0, 2);
            }
            if (v == board2[0][1]) {
                playAction(board2[0][1], 0, 1, 2);
            }
            if (v == board2[0][2]) {
                playAction(board2[0][2], 0, 2, 2);
            }
            if (v == board2[1][0]) {
                playAction(board2[1][0], 1, 0, 2);
            }
            if (v == board2[1][1]) {
                playAction(board2[1][1], 1, 1, 2);
            }
            if (v == board2[1][2]) {
                playAction(board2[1][2], 1, 2, 2);
            }
            if (v == board2[2][0]) {
                playAction(board2[2][0], 2, 0, 2);
            }
            if (v == board2[2][1]) {
                playAction(board2[2][1], 2, 1, 2);
            }
            if (v == board2[2][2]) {
                playAction(board2[2][2], 2, 2, 2);
            }
        /*--------------Board 3--------------*/
            if (v == board3[0][0]) {
                playAction(board3[0][0], 0, 0, 3);
            }
            if (v == board3[0][1]) {
                playAction(board3[0][1], 0, 1, 3);
            }
            if (v == board3[0][2]) {
                playAction(board3[0][2], 0, 2, 3);
            }
            if (v == board3[1][0]) {
                playAction(board3[1][0], 1, 0, 3);
            }
            if (v == board3[1][1]) {
                playAction(board3[1][1], 1, 1, 3);
            }
            if (v == board3[1][2]) {
                playAction(board3[1][2], 1, 2, 3);
            }
            if (v == board3[2][0]) {
                playAction(board3[2][0], 2, 0, 3);
            }
            if (v == board3[2][1]) {
                playAction(board3[2][1], 2, 1, 3);
            }
            if (v == board3[2][2]) {
                playAction(board3[2][2], 2, 2, 3);
            }
        /*--------------Board 4--------------*/
            if (v == board4[0][0]) {
                playAction(board4[0][0], 0, 0, 4);
            }
            if (v == board4[0][1]) {
                playAction(board4[0][1], 0, 1, 4);
            }
            if (v == board4[0][2]) {
                playAction(board4[0][2], 0, 2, 4);
            }
            if (v == board4[1][0]) {
                playAction(board4[1][0], 1, 0, 4);
            }
            if (v == board4[1][1]) {
                playAction(board4[1][1], 1, 1, 4);
            }
            if (v == board4[1][2]) {
                playAction(board4[1][2], 1, 2, 4);
            }
            if (v == board4[2][0]) {
                playAction(board4[2][0], 2, 0, 4);
            }
            if (v == board4[2][1]) {
                playAction(board4[2][1], 2, 1, 4);
            }
            if (v == board4[2][2]) {
                playAction(board4[2][2], 2, 2, 4);
            }
        /*--------------Board 5--------------*/
            if (v == board5[0][0]) {
                playAction(board5[0][0], 0, 0, 5);
            }
            if (v == board5[0][1]) {
                playAction(board5[0][1], 0, 1, 5);
            }
            if (v == board5[0][2]) {
                playAction(board5[0][2], 0, 2, 5);
            }
            if (v == board5[1][0]) {
                playAction(board5[1][0], 1, 0, 5);
            }
            if (v == board5[1][1]) {
                playAction(board5[1][1], 1, 1, 5);
            }
            if (v == board5[1][2]) {
                playAction(board5[1][2], 1, 2, 5);
            }
            if (v == board5[2][0]) {
                playAction(board5[2][0], 2, 0, 5);
            }
            if (v == board5[2][1]) {
                playAction(board5[2][1], 2, 1, 5);
            }
            if (v == board5[2][2]) {
                playAction(board5[2][2], 2, 2, 5);
            }
        /*--------------Board 6--------------*/
            if (v == board6[0][0]) {
                playAction(board6[0][0], 0, 0, 6);
            }
            if (v == board6[0][1]) {
                playAction(board6[0][1], 0, 1, 6);
            }
            if (v == board6[0][2]) {
                playAction(board6[0][2], 0, 2, 6);
            }
            if (v == board6[1][0]) {
                playAction(board6[1][0], 1, 0, 6);
            }
            if (v == board6[1][1]) {
                playAction(board6[1][1], 1, 1, 6);
            }
            if (v == board6[1][2]) {
                playAction(board6[1][2], 1, 2, 6);
            }
            if (v == board6[2][0]) {
                playAction(board6[2][0], 2, 0, 6);
            }
            if (v == board6[2][1]) {
                playAction(board6[2][1], 2, 1, 6);
            }
            if (v == board6[2][2]) {
                playAction(board6[2][2], 2, 2, 6);
            }
        /*--------------Board 7--------------*/
            if (v == board7[0][0]) {
                playAction(board7[0][0], 0, 0, 7);
            }
            if (v == board7[0][1]) {
                playAction(board7[0][1], 0, 1, 7);
            }
            if (v == board7[0][2]) {
                playAction(board7[0][2], 0, 2, 7);
            }
            if (v == board7[1][0]) {
                playAction(board7[1][0], 1, 0, 7);
            }
            if (v == board7[1][1]) {
                playAction(board7[1][1], 1, 1, 7);
            }
            if (v == board7[1][2]) {
                playAction(board7[1][2], 1, 2, 7);
            }
            if (v == board7[2][0]) {
                playAction(board7[2][0], 2, 0, 7);
            }
            if (v == board7[2][1]) {
                playAction(board7[2][1], 2, 1, 7);
            }
            if (v == board7[2][2]) {
                playAction(board7[2][2], 2, 2, 7);
            }
        /*--------------Board 8--------------*/
            if (v == board8[0][0]) {
                playAction(board8[0][0], 0, 0, 8);
            }
            if (v == board8[0][1]) {
                playAction(board8[0][1], 0, 1, 8);
            }
            if (v == board8[0][2]) {
                playAction(board8[0][2], 0, 2, 8);
            }
            if (v == board8[1][0]) {
                playAction(board8[1][0], 1, 0, 8);
            }
            if (v == board8[1][1]) {
                playAction(board8[1][1], 1, 1, 8);
            }
            if (v == board8[1][2]) {
                playAction(board8[1][2], 1, 2, 8);
            }
            if (v == board8[2][0]) {
                playAction(board8[2][0], 2, 0, 8);
            }
            if (v == board8[2][1]) {
                playAction(board8[2][1], 2, 1, 8);
            }
            if (v == board8[2][2]) {
                playAction(board8[2][2], 2, 2, 8);
            }
        /*--------------Board 9--------------*/
            if (v == board9[0][0]) {
                playAction(board9[0][0], 0, 0, 9);
            }
            if (v == board9[0][1]) {
                playAction(board9[0][1], 0, 1, 9);
            }
            if (v == board9[0][2]) {
                playAction(board9[0][2], 0, 2, 9);
            }
            if (v == board9[1][0]) {
                playAction(board9[1][0], 1, 0, 9);
            }
            if (v == board9[1][1]) {
                playAction(board9[1][1], 1, 1, 9);
            }
            if (v == board9[1][2]) {
                playAction(board9[1][2], 1, 2, 9);
            }
            if (v == board9[2][0]) {
                playAction(board9[2][0], 2, 0, 9);
            }
            if (v == board9[2][1]) {
                playAction(board9[2][1], 2, 1, 9);
            }
            if (v == board9[2][2]) {
                playAction(board9[2][2], 2, 2, 9);
            }
        } else {
            String dialogTitle = "";
            if (playerOneWins) {
                dialogTitle = "X";
            }
            if (playerTwoWins) {
                dialogTitle = "O";
            }
            builder.setMessage("Want to Replay?!")
                    .setTitle("Player " + dialogTitle + " Wins");
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User clicked OK button
                }
            });
            builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User cancelled the dialog
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }


    public void startCellAnimation(ImageButton cell, Turns playerType) {
        if (playerType.equals(Turns.X)) {
            cell.setBackgroundResource(R.drawable.x_turn_action);
            cell.setImageResource(R.drawable.x_turn_action);
        } else {
            if (playerType.equals(Turns.O)) {
                cell.setBackgroundResource(R.drawable.o_turn_action);
                cell.setImageResource(R.drawable.o_turn_action);
            }
        }
        AnimationDrawable frameAnimation = (AnimationDrawable) cell.getDrawable();
        frameAnimation.setCallback(cell);
        frameAnimation.setVisible(true, false);
        frameAnimation.start();
    }

    public void startBoardAnimation(TableLayout board, int boardID) {

        board.setBackgroundResource(R.drawable.board_animation);
        AnimationDrawable frameAnimation = (AnimationDrawable) board.getBackground();
        frameAnimation.setCallback(board);
        frameAnimation.setVisible(true, false);
        frameAnimation.start();

    }


    public void changePlayerTurn() {
        if (playerOneTurn) {
            playerOneTurn = false;
            playerTwoTurn = true;
        } else if (playerTwoTurn) {
            playerOneTurn = true;
            playerTwoTurn = false;
        }
    }

    public void playAction(ImageButton cell, int x, int y, int boardNumber) {

        point = new PointPosition(x, y);
        int[] output = new int[2];
            if (mainBoard.isAllowedToPlay(point,boardNumber)) {
            if (playerOneTurn) {
                output = mainBoard.playAction(point, 'x', boardNumber);
                startCellAnimation(cell, Turns.X);
                changePlayerTurn();
                if(output[1] != 10)
                startBoardAnimation(getTableBoard(output[1]), 1);
                if (output[1] != boardNumber)
                    getTableBoard(boardNumber).setBackgroundResource(R.color.board_background);
                if (mainBoard.gameOver('x')) {
                    Toast.makeText(
                            getApplicationContext(), "Player 1 Wins!",
                            Toast.LENGTH_SHORT).show();
                    playerOneWins = true;
                    playerTwoWins = false;
                    gameOver = true;
                }
            } else {
                if (playerTwoTurn) {
                    output = mainBoard.playAction(point, 'o', boardNumber);
                    startCellAnimation(cell, Turns.O);
                    changePlayerTurn();
                    if(output[1] != 10)
                        startBoardAnimation(getTableBoard(output[1]), 1);
                    if (output[1] != boardNumber)
                        getTableBoard(boardNumber).setBackgroundResource(R.color.board_background);
                    if (mainBoard.gameOver('o')) {
                        Toast.makeText(
                                getApplicationContext(), "Player 2 Wins!",
                                Toast.LENGTH_SHORT).show();
                        playerOneWins = false;
                        playerTwoWins = true;
                        gameOver = true;
                    }
                }
            }
        } else {
                Toast.makeText(
                        getApplicationContext(), "Blocked Cell!",
                        Toast.LENGTH_SHORT).show();
            }

}

    public TableLayout getTableBoard(int tableID){
        switch(tableID){
            case 1:
                return table1;
            case 2:
                return table2;
            case 3:
                return table3;
            case 4:
                return table4;
            case 5:
                return table5;
            case 6:
                return table6;
            case 7:
                return table7;
            case 8:
                return table8;
            case 9:
                return table9;
            default:
                return null;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(this, "Please click BACK again to exit, Game state will reset!", Toast.LENGTH_SHORT).show();
            doubleBackToExitPressedOnce = true;
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        }
    }
}
