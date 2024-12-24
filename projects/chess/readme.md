8*8 chess board game between two players


APIs required:

1) createNewGame()
2) startTheGame(gameId)
3) move(Piece, Destination)
4) remove(Piece)
5) checkWin()



class game{
    user1.initialize(color);
    board boardObj;
    boardObj.initialize();
}

class user{
    string userID;
    string Color;

}

class pieces{
    stirng currPosition
    string color;
    string type;
    bool isActive;

    +checkMove(peice);{
        //if else for different pieces and logic to check if destination is possible
    }
}

interface MoveStartegy()
{
    +checkMove(destination)
}

class user{
    List<pieces> activepieces;

    +move(piece, destination)
    {
        if(piece.checkmove(destination)==true) 
        {
        if(board[destination]==NULL) 
        {
            piece.currentPos = destination; board[desination] = piece;
        }
        else
        {
            board[destination].isActive = false; if(checkWin()==true) {//end the game, declare the result} 
            piece.currentPos = destination; board[desination] = piece;
        }
        board[destination] = null;
    }
}

class board{

    vector<vector<string>> mat[8][8];
    +initialize();
    {
        //arrange mat as by default position

    }
}

class game{
    new user1
    new user2
    new gameboard
    int cnt=0;
    int gameID;

    gameNew = new game;
    gameNew.initialize();
    gameNew.start();

    intialize();
    {
        user1 - user.initialize();
        user2 = user.initialize();
        gameboard = board.intialize();  gameId = randomString();
    }
    start()
    {
        while(gameboard.checkWin()==false)
        {
            if(cnt%2==0) user1.move(piece,destination);
            else user2.move(piece, destination);
        }

        if(cnt%2==0) cout<<"user2 is winner"; else cout<<"user1 is winner";
    }

    +checkWin()
    {
        //winCondition
    }
}