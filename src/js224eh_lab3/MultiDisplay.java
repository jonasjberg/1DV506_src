package js224eh_lab3;

/**
 * Created by Jonas Sjöberg (js224eh) on 2016-12-08.
 *
 * Laboration 3  --  Uppgift 3
 */
public class MultiDisplay
{
    private String displayMessage;
    private int displayCount;

    /**
     * Creates a new MultiDisplay instance with default parameters.
     */
    public MultiDisplay()
    {
        setDisplayMessage("");
        setDisplayCount(1);
    }

    /**
     * Creates a new MultiDisplay instance.
     * @param displayMessage The message to display.
     * @param displayCount The number of times the message is displayed.
     */
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

    /**
     * Sets the number of times the text should be display.
     * @param displayCount The number of times to display the text.
     */
    public void setDisplayCount(int displayCount)
    {
        if (displayCount >= 0) {
            this.displayCount = displayCount;
        }
    }

    /**
     * Displays the message a previously set number of times.
     */
    public void display()
    {
        for (int i = 0; i < this.displayCount; i++) {
            System.out.println(this.displayMessage);
        }
    }

    /**
     * Displays a specified message a certain number of times.
     * @param displayMessage The message to display.
     * @param displayCount The number of times the message is displayed.
     */
    public void display(String displayMessage, int displayCount)
    {
        setDisplayMessage(displayMessage);
        setDisplayCount(displayCount);
        display();
    }
}
