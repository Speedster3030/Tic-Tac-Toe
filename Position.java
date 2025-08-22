import java.util.*;
public class Position
{
    public final int Rows=3;
    public final int Cols=3;
    public boolean isCrossTurn;
    public Move lastMove;
    public int[][] board=new int[Rows][Cols];
    public List<Move> history=new ArrayList<>();

    public void makeMove(Move move)
    {
        board[move.Row-1][move.Col-1]=move.Value;
        isCrossTurn=!isCrossTurn;
        history.add(lastMove);
        lastMove=move;
    }

    public void undoMove()
    {
        board[lastMove.Row-1][lastMove.Col-1]=0;
        isCrossTurn=!isCrossTurn;
        lastMove=history.get(history.size()-1);
        history.remove(history.size()-1);
    }

    public List<Move> getMoves()
    {
        List<Move> moves=new ArrayList<>();
        int v=1;Search s=new Search();
        if(Search.eval(this)==100||Search.eval(this)==-100)
        {
            return moves;
        }
        if(isCrossTurn){v=-1;}
        for(int i=0;i<Rows;i++)
        {
            for(int j=0;j<Cols;j++)
            {
                if(board[i][j]==0)
                {
                    Move m=new Move(i+1,j+1,v);
                    moves.add(m);
                }
            }
        }
        return moves;
    }

    public void display()
    {
        for(int i=0;i<Rows;i++)
        {
            for(int j=0;j<Cols;j++)
            {
                int v=board[i][j];
                if(v==0)
                {
                    System.out.print("-  ");
                }
                if(v==1)
                {
                    System.out.print("O  ");
                }
                if(v==-1)
                {
                    System.out.print("X  ");
                }
            }
            System.out.println("");
            System.out.println("");
        }
        System.out.println("");
    }

 public boolean isGameOver()
 {
     if(!(this.getMoves().size()==0))
     {
         return false;
     }
     return true;
 }

 public Position(boolean turn)
 {
     for(int i=0;i<Rows;i++)
     {
         for(int j=0;j<Cols;j++)
         {
             board[i][j]=0;
         }
     }
     isCrossTurn=turn;
     lastMove=new Move(1,1,0);
 }

}
