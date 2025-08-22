import java.util.*;
public class perft
{
    public static Search s=new Search();
    public static int evcount=0;
    public static int zcount=0;

    public static void main(String[] args)
    {
        Position p=new Position(true);
        p.display();
        System.out.println(count(p,9));
        System.out.println("with eval: "+evcount+"   without eval: "+zcount);
    }

    public static int count(Position p,int depth)
    {
        /*if(depth==0)//||s.eval(p)==100||s.eval(p)==-100)
        {
            zcount++;
            //p.display();System.out.println();
            return 1;
        }*/
        if(s.eval(p)==100||s.eval(p)==-100)
        {
            evcount++;
            return 1;
        }
        int c=0;
        List<Move> moves=p.getMoves();
        for(Move move:moves)
        {
            p.makeMove(move);
            c+=count(p,depth-1);
            p.undoMove();
        }
        return c;
    }

}
