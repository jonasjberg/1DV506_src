package js224eh_lab3;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-12-08.
 *
 * Laboration 3  --  Uppgift 4
 */
public class AlarmMain
{
    public static void main(String[] args)
    {
        AlarmClock clock = new AlarmClock(23, 48);
        clock.displayTime();
        clock.setAlarm(6, 15);

        for (int i = 0; i < 500; i++) {
            clock.timeTick();
        }

        clock.displayTime();
    }
}
