import java.util.*;
public class Search
{

    public static int minimax(Position p,int depth,boolean isMax)
    {
        if(eval(p)==100||eval(p)==-100||depth==0)
        {
            return eval(p);
        }
        if(p.getMoves().size()==0)
        {
            return 0;
        }
        if(isMax)
        {
            int eval,maxeval=-500;
            List<Move> moves=p.getMoves();
            for(Move move:moves)
            {
                p.makeMove(move);
                eval=minimax(p,depth-1,false);
                p.undoMove();
                if(maxeval<eval){maxeval=eval;}
            }
            return maxeval;
        }
        else
        {
            int eval,mineval=500;
            List<Move> moves=p.getMoves();
            for(Move move:moves)
            {
                p.makeMove(move);
                eval=minimax(p,depth-1,true);
                p.undoMove();
                if(mineval>eval){mineval=eval;}
            }
            return mineval;
        }
    }

    public static int eval(Position p)
    {
        int v=p.board[1][1];
        if(v!=0 && v==p.board[0][0] && v==p.board[2][2])
        {
            if(v>0){return 100;}
            return -100;
        }
        if(v!=0 && v==p.board[0][2] && v==p.board[2][0])
        {
            if(v>0){return 100;}
            return -100;
        }
        if(v!=0 && v==p.board[0][1] && v==p.board[2][1])
        {
            if(v>0){return 100;}
            return -100;
        }
        if(v!=0 && v==p.board[1][0] && v==p.board[1][2])
        {
            if(v>0){return 100;}
            return -100;
        }
        v=p.board[0][0];
        if(v!=0 && v==p.board[0][1] && v==p.board[0][2])
        {
            if(v>0){return 100;}
            return -100;
        }
        if(v!=0 && v==p.board[1][0] && v==p.board[2][0])
        {
            if(v>0){return 100;}
            return -100;
        }
        v=p.board[2][2];
        if(v!=0 && v==p.board[0][2] && v==p.board[1][2])
        {
            if(v>0){return 100;}
            return -100;
        }
        if(v!=0 && v==p.board[2][0] && v==p.board[2][1])
        {
            if(v>0){return 100;}
            return -100;
        }
        return 0;
    }

}
