public class Move
{
    public int Row;
    public int Col;
    public int Value;

    public Move(int r,int c,int v)
    {
        Row=r;
        Col=c;
        Value=v;
    }

    public Move copy()
    {
        Move m=new Move(1,1,1);
        m.Row=this.Row;
        m.Col=this.Col;
        m.Value=this.Value;
        return m;
    }
}
