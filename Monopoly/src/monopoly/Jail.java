package monopoly;
public class Jail extends Location
{
    boolean hasVisitor;

    public Jail() 
    {
        super("Jail");
    }
    
    public boolean isVisited(){return hasVisitor;}
    
    public void setVisitor(boolean hasVisitor){this.hasVisitor = hasVisitor;}
}
