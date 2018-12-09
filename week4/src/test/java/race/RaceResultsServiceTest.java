package race;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class RaceResultsServiceTest {
    private Logger logger = mock(Logger.class);
    private RaceResultsService raceResults = new RaceResultsService(logger);
    private Message message = mock(Message.class);
    private Client clientA = mock(Client.class, "clientA");
    private Client clientB = mock(Client.class, "clientB");
    private static List<RaceCategory> allCategories = new ArrayList<>();

    @Before
    public void setUp() {
        allCategories.add(RaceCategory.All);
    }

    @Test
    public void subscribedClientShouldReceiveMessage() {
        raceResults.addSubscriber(clientA);
        raceResults.send(message, RaceCategory.All);
        verify(clientA).receive(message);
    }

    @Test
    public void allSubscribedClientsShouldReceiveMessages() {
        raceResults.addSubscriber(clientA);
        raceResults.addSubscriber(clientB);
        raceResults.send(message, RaceCategory.All);
        verify(clientA).receive(message);
        verify(clientB).receive(message);
    }

    @Test
    public void shouldSendOnlyOneMessageToMultiSubscriber() {
        raceResults.addSubscriber(clientA);
        raceResults.addSubscriber(clientA);
        raceResults.send(message, RaceCategory.All);
        verify(clientA).receive(message);
    }

    @Test
    public void unsubscribedClientShouldNotReceiveMessages() {
        raceResults.addSubscriber(clientA);
        raceResults.removeSubscriber(clientA);
        raceResults.send(message, RaceCategory.All);
        verify(clientA, never()).receive(message);
    }

    @Test
    public void subscribedClientShouldReceiveMessageFromDesiredCategory() {
        List<RaceCategory> cat = new ArrayList<>();
        cat.add(RaceCategory.Horse);
        raceResults.addSubscriberToCategories(clientA, cat);
        raceResults.send(message, RaceCategory.Horse);

        verify(clientA).receive(message);
    }

    @Test
    public void subscribedClientDoesNotReceiveMessagesFromUndesiredCategories() {
        List<RaceCategory> cat = new ArrayList<>();
        cat.add(RaceCategory.Horse);
        raceResults.addSubscriberToCategories(clientA, cat);

        raceResults.send(message, RaceCategory.FormulaOne);

        verify(clientA, never()).receive(message);
    }

    @Test
    public void sentMessageTextAndTimeAreLogged() {
        raceResults.addSubscriber(clientA);
        raceResults.send(message, RaceCategory.All);

        verify(logger).logMessage(message.getText(), message.getTime());
    }

    @Test
    public void subscribedClientReceivesAllSentMessages() {
        raceResults.addSubscriber(clientA);
        raceResults.send(message, RaceCategory.All);
        raceResults.send(message, RaceCategory.All);
        raceResults.send(message, RaceCategory.All);

        verify(clientA, times(3)).receive(message);
    }

    @Test
    public void subscribedClientsReceiveAllSentMessages() {
        raceResults.addSubscriber(clientA);
        raceResults.addSubscriber(clientB);

        raceResults.send(message, RaceCategory.All);
        raceResults.send(message, RaceCategory.All);
        raceResults.send(message, RaceCategory.All);

        verify(clientA, times(3)).receive(message);
        verify(clientB, times(3)).receive(message);
    }
}