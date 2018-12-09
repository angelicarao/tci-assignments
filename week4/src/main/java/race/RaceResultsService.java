package race;

import java.util.*;

public class RaceResultsService {
    private Map<Client, List<RaceCategory>> clients = new HashMap<>();

    public void addSubscriber(Client client) {
        clients.put(client, new ArrayList<>());
    }
    public void send(Message message, RaceCategory toCategory) {
        for (Client client : clients.keySet()) {
            if(clients.get(client).contains(toCategory) || clients.get(client).contains(RaceCategory.All))
                client.receive(message);
        }
    }
    public void removeSubscriber(Client client) {
        clients.remove(client);
    }

    public void addSubscriberToCategories(Client client, List<RaceCategory> categories) {
        clients.put(client, categories);
    }
}
