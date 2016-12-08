package js224eh_lab3;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-12-08.
 *
 * Laboration 3  --  Uppgift 3
 */
public class MultiDisplay
{
    private String displayMessage;
    private int displayCount;

    public MultiDisplay()
    {
        setDisplayMessage("");
        setDisplayCount(1);
    }

    public MultiDisplay(String displayMessage, int displayCount)
    {
        setDisplayMessage(displayMessage);
        setDisplayCount(displayCount);
    }

    public void setDisplayMessage(String message)
    {
        this.displayMessage = message;
    }

    public String getDisplayMessage()
    {
        return this.displayMessage;
    }

    public void setDisplayCount(int displayCount)
    {
        if (displayCount >= 0) {
            this.displayCount = displayCount;
        }
    }

    public void display()
    {
        for (int i = 0; i < this.displayCount; i++) {
            System.out.println(this.displayMessage);
        }
    }

    public void display(String displayMessage, int displayCount)
    {
        setDisplayMessage(displayMessage);
        setDisplayCount(displayCount);
        display();
    }
}
