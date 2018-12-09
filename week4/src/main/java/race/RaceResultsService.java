package race;

import java.util.*;

public class RaceResultsService {
    private Map<Client, List<RaceCategory>> clients = new HashMap<>();
    private Logger logger;

    public RaceResultsService(Logger logger) {
        this.logger = logger;
    }

    public void addSubscriber(Client client) {
        List<RaceCategory> defaultAll = new ArrayList<>();
        defaultAll.add(RaceCategory.All);

        clients.put(client, defaultAll);
    }

    public void send(Message message, RaceCategory toCategory) {
        for (Client client : clients.keySet()) {
            if (clients.get(client).contains(toCategory) || clients.get(client).contains(RaceCategory.All)) {
                client.receive(message);
                logger.logMessage(message.getText(), message.getTime());
            }
        }
    }

    public void removeSubscriber(Client client) throws NotSubscribedException {
        if (clients.get(client) != null) {
            clients.remove(client);
        } else {
            throw new NotSubscribedException();
        }

    }

    public void addSubscriberToCategories(Client client, List<RaceCategory> categories) {
        clients.put(client, categories);
    }
}
