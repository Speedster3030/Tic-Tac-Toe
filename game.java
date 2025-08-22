import java.io.*;
import java.util.*;
public class game
{
    public static void main(String[] args)throws IOException
    {
        Search s=new Search();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Position p=new Position(true);
        p.display();

        while(true)
        {
            if(!p.isCrossTurn)
            {
                List<Move> moves=p.getMoves();
                if(moves.size()==0){break;}int x=0;
                for(Move move:moves)
                {
                    x++;
                    System.out.println(x+": row"+move.Row+" col:"+move.Col);
                }
                int n=Integer.parseInt(br.readLine());
                p.makeMove(moves.get(n-1));
            }
            if(p.isCrossTurn)
            {
                int ev=500;Move m=new Move(1,1,0);
                List<Move> moves=p.getMoves();
                if(moves.size()==0)
                {
                    break;
                }
                for(Move move:moves)
                {
                    //Search s =new Search();
                    p.makeMove(move);
                    int eval=s.minimax(p,8,true);
                    //depth value doesnt matter;
                    if(ev>=eval)
                    {
                        ev=eval;m=move.copy();
                    }
                    p.undoMove();
                }
                p.makeMove(m);
            }
            p.display();
            System.out.println("");
        }
        p.display();
    }
}
