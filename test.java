import java.util.*;
public class test
{
    public static void main(String[] args)
    {
        Search s=new Search();
        Position p=new Position(true);
        while(true)
        {
            Scanner sc=new Scanner(System.in);
            List<Move> moves=p.getMoves();
            p.display();

            for(int i=0;i<=moves.size()-1;i++)
            {
                Move m=moves.get(i);
                System.out.println((i+1)+": row-"+m.Row+" col-"+m.Col);
            }
            int n=sc.nextInt();

            if(n<0)
            {
                break;
            }
            if(n==0)
            {
                p.undoMove();
                continue;
            }

            p.makeMove(moves.get(n-1));
            System.out.println("\n\nEval: "+Search.minimax(p,moves.size(),!p.isCrossTurn)+"\n");

            if(s.eval(p)==100||s.eval(p)==-100||moves.size()==0)
            {
                p.display();
                System.out.println("game ends");
                break;
            }
        }
    }
}

